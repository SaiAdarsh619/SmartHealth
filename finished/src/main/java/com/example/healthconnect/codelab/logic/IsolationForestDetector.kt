/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.healthconnect.codelab.logic

import android.util.Log
import kotlin.math.ln
import kotlin.math.pow
import kotlin.random.Random

/**
 * On-device, unsupervised Isolation Forest anomaly detector.
 *
 * Isolation Forest (Liu et al., 2008) works by building an ensemble of random
 * isolation trees on a subsample of training data. Points that are isolated
 * quickly (short average path length) score as anomalies.
 *
 * This is a pure-Kotlin implementation – no external library or server required.
 *
 * Feature vector: [heartRate, spo2, stepsNorm]
 *   - heartRate: raw bpm
 *   - spo2: percentage (0–100)
 *   - stepsNorm: today's steps / 10_000 (normalised to roughly 0..1)
 *
 * Warm-up: requires [MIN_TRAINING_SAMPLES] data points before the model is
 * fitted and scores become meaningful. Until then [isWarmedUp] is false and
 * [score] returns 0.0.
 *
 * Thread-safety: all public state is guarded; call [observe] from any thread.
 *
 * ⚠️ Research prototype — NOT a medical device. Results should not be used
 * for clinical decision-making.
 */
class IsolationForestDetector(
    private val numTrees: Int = NUM_TREES,
    private val subsampleSize: Int = SUBSAMPLE_SIZE,
    private val anomalyThreshold: Double = ANOMALY_THRESHOLD,
    private val seed: Long = 42L   // deterministic for reproducibility
) {

    // -------------------------------------------------------------------------
    // Public constants / config
    // -------------------------------------------------------------------------
    companion object {
        const val NUM_TREES = 100
        const val SUBSAMPLE_SIZE = 64
        const val MIN_TRAINING_SAMPLES = 20   // warm-up window
        const val ANOMALY_THRESHOLD = 0.70    // score > this → anomaly flag
        const val FEATURE_COUNT = 3           // hr, spo2, stepsNorm
        private const val TAG = "IsoForest"
    }

    // -------------------------------------------------------------------------
    // Internal state
    // -------------------------------------------------------------------------
    private val buffer = mutableListOf<DoubleArray>()   // raw feature observations
    private var forest: List<ITree>? = null              // fitted forest (null until warm-up)
    private val rng = Random(seed)

    var isWarmedUp: Boolean = false
        private set

    /** Last computed anomaly score (0 = normal, 1 = highly anomalous). */
    var lastScore: Double = 0.0
        private set

    /** Number of samples observed since construction. */
    val observationCount: Int get() = buffer.size

    // -------------------------------------------------------------------------
    // Public API
    // -------------------------------------------------------------------------

    /**
     * Extract features from the current vitals snapshot and feed them into
     * the detector.
     *
     * @param heartRate  Heart rate in bpm (null = missing)
     * @param spo2       SpO2 percentage (null = missing)
     * @param steps      Step count today (null = missing)
     * @return [MlAnomalyResult] with score and warm-up status.
     */
    fun observe(heartRate: Int?, spo2: Int?, steps: Long?): MlAnomalyResult {
        // Only add to buffer when all three features are available
        if (heartRate == null || spo2 == null) {
            return MlAnomalyResult(
                score = lastScore,
                isAnomaly = false,
                isWarmedUp = isWarmedUp,
                reason = "Missing vitals – skipping observation"
            )
        }

        val feature = extractFeatures(heartRate, spo2, steps ?: 0L)
        buffer.add(feature)

        // Refit forest every time we hit a multiple of SUBSAMPLE_SIZE
        // (or first time we reach MIN_TRAINING_SAMPLES)
        if (buffer.size >= MIN_TRAINING_SAMPLES) {
            if (!isWarmedUp || buffer.size % SUBSAMPLE_SIZE == 0) {
                forest = buildForest(buffer)
                isWarmedUp = true
                Log.i(TAG, "Forest fitted/updated on ${buffer.size} samples")
            }
        }

        // Score the CURRENT observation
        val currentForest = forest
        if (currentForest == null || !isWarmedUp) {
            return MlAnomalyResult(
                score = 0.0,
                isAnomaly = false,
                isWarmedUp = false,
                reason = "Warm-up: ${buffer.size}/$MIN_TRAINING_SAMPLES samples collected"
            )
        }

        val score = averagePathLengthScore(feature, currentForest, subsampleSize)
        lastScore = score
        val isAnomaly = score > anomalyThreshold

        Log.d(TAG, "score=%.3f anomaly=$isAnomaly hr=$heartRate spo2=$spo2 steps=$steps".format(score))

        return MlAnomalyResult(
            score = score,
            isAnomaly = isAnomaly,
            isWarmedUp = true,
            reason = if (isAnomaly) "ML: Isolation score %.3f > threshold %.2f".format(score, anomalyThreshold)
                     else "ML: Normal (score %.3f)".format(score)
        )
    }

    /** Reset the detector (clears buffer and forest). Useful for testing. */
    fun reset() {
        buffer.clear()
        forest = null
        isWarmedUp = false
        lastScore = 0.0
        Log.i(TAG, "Detector reset")
    }

    // -------------------------------------------------------------------------
    // Feature extraction
    // -------------------------------------------------------------------------

    /**
     * Build the 3-element feature vector used by the Isolation Forest.
     *
     * Normalisation keeps values in comparable numeric ranges so no single
     * feature dominates the random splits.
     *
     *   [0] heartRate as-is   (typical range 40–180)
     *   [1] spo2 as-is        (typical range 85–100)
     *   [2] steps / 10_000    (typical range 0..1+)
     */
    internal fun extractFeatures(heartRate: Int, spo2: Int, steps: Long): DoubleArray {
        return doubleArrayOf(
            heartRate.toDouble(),
            spo2.toDouble(),
            steps / 10_000.0
        )
    }

    // -------------------------------------------------------------------------
    // Isolation Forest core — pure Kotlin, no dependencies
    // -------------------------------------------------------------------------

    /** A single node in an isolation tree. */
    private sealed class INode {
        data class Internal(
            val featureIndex: Int,
            val splitValue: Double,
            val left: INode,   // feature[idx] < splitValue
            val right: INode   // feature[idx] >= splitValue
        ) : INode()

        data class Leaf(val size: Int) : INode()
    }

    private data class ITree(val root: INode)

    /** Build an ensemble of [numTrees] isolation trees on subsamples of [data]. */
    private fun buildForest(data: List<DoubleArray>): List<ITree> {
        val maxDepth = Math.ceil(Math.log(subsampleSize.toDouble()) / Math.log(2.0)).toInt() + 1
        return List(numTrees) {
            val sample = data.shuffled(rng).take(subsampleSize)
            ITree(buildTree(sample, depth = 0, maxDepth = maxDepth))
        }
    }

    private fun buildTree(data: List<DoubleArray>, depth: Int, maxDepth: Int): INode {
        if (data.size <= 1 || depth >= maxDepth) {
            return INode.Leaf(data.size)
        }

        // Pick a random feature that has variance
        val featureIndex = (0 until FEATURE_COUNT).shuffled(rng).firstOrNull { idx ->
            val vals = data.map { it[idx] }
            vals.min() != vals.max()
        } ?: return INode.Leaf(data.size)

        val vals = data.map { it[featureIndex] }
        val minV = vals.min()
        val maxV = vals.max()
        val splitValue = minV + rng.nextDouble() * (maxV - minV)

        val left = data.filter { it[featureIndex] < splitValue }
        val right = data.filter { it[featureIndex] >= splitValue }

        // Guard against degenerate splits
        if (left.isEmpty() || right.isEmpty()) return INode.Leaf(data.size)

        return INode.Internal(
            featureIndex = featureIndex,
            splitValue = splitValue,
            left = buildTree(left, depth + 1, maxDepth),
            right = buildTree(right, depth + 1, maxDepth)
        )
    }

    /** Path length of a single sample through one tree. */
    private fun pathLength(node: INode, sample: DoubleArray, currentDepth: Int): Double {
        return when (node) {
            is INode.Leaf -> currentDepth + averageUnsuccessfulSearchLength(node.size)
            is INode.Internal -> {
                if (sample[node.featureIndex] < node.splitValue)
                    pathLength(node.left, sample, currentDepth + 1)
                else
                    pathLength(node.right, sample, currentDepth + 1)
            }
        }
    }

    /**
     * Expected path length for a BST with [n] elements
     * (Liu et al. 2008, Equation 1).
     */
    private fun averageUnsuccessfulSearchLength(n: Int): Double {
        if (n <= 1) return 0.0
        if (n == 2) return 1.0
        val h = ln(n - 1.0) + 0.5772156649   // harmonic number approximation
        return 2.0 * h - 2.0 * (n - 1.0) / n
    }

    /**
     * Compute anomaly score in [0, 1].
     * Score closer to 1.0 → anomalous; closer to 0.5 → uncertain; closer to 0.0 → normal.
     */
    private fun averagePathLengthScore(
        sample: DoubleArray,
        trees: List<ITree>,
        n: Int
    ): Double {
        val avgPathLength = trees.map { pathLength(it.root, sample, 0) }.average()
        val c = averageUnsuccessfulSearchLength(n)
        if (c == 0.0) return 0.5
        return 2.0.pow(-avgPathLength / c)
    }
}
