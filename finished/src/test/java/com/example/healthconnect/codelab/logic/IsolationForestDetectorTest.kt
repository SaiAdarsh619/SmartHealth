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

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Unit tests for [IsolationForestDetector].
 *
 * Tests cover:
 *  1. Feature extraction correctness
 *  2. Warm-up period behaviour (no anomalies before MIN_TRAINING_SAMPLES)
 *  3. Normal inputs score below threshold after warm-up
 *  4. Anomalous inputs score above threshold after warm-up
 *  5. Determinism / reproducibility with fixed seed
 *  6. Reset clears state
 *  7. [MlAnomalyResult] status labels
 *
 * ⚠️ Research prototype — NOT a medical device.
 */
class IsolationForestDetectorTest {

    private lateinit var detector: IsolationForestDetector

    @Before
    fun setUp() {
        // Fixed seed → fully reproducible results (important for paper)
        detector = IsolationForestDetector(
            numTrees = IsolationForestDetector.NUM_TREES,
            subsampleSize = IsolationForestDetector.SUBSAMPLE_SIZE,
            seed = 42L
        )
    }

    // -------------------------------------------------------------------------
    // 1. Feature extraction
    // -------------------------------------------------------------------------

    @Test
    fun `extractFeatures returns correct 3-element vector`() {
        val features = detector.extractFeatures(heartRate = 75, spo2 = 98, steps = 5000L)
        assertEquals(IsolationForestDetector.FEATURE_COUNT, features.size)
        assertEquals(75.0, features[0], 0.001)
        assertEquals(98.0, features[1], 0.001)
        assertEquals(0.5,  features[2], 0.001)   // 5000 / 10_000
    }

    @Test
    fun `extractFeatures normalises steps correctly`() {
        val f10k = detector.extractFeatures(70, 97, 10_000L)
        assertEquals(1.0, f10k[2], 0.001)

        val f0 = detector.extractFeatures(70, 97, 0L)
        assertEquals(0.0, f0[2], 0.001)

        val f20k = detector.extractFeatures(70, 97, 20_000L)
        assertEquals(2.0, f20k[2], 0.001)
    }

    // -------------------------------------------------------------------------
    // 2. Warm-up period
    // -------------------------------------------------------------------------

    @Test
    fun `detector is not warmed up below MIN_TRAINING_SAMPLES`() {
        val n = IsolationForestDetector.MIN_TRAINING_SAMPLES - 1
        repeat(n) { detector.observe(72, 98, 5000L) }
        assertFalse("Should not be warmed up with only $n samples", detector.isWarmedUp)
    }

    @Test
    fun `detector is warmed up after MIN_TRAINING_SAMPLES`() {
        repeat(IsolationForestDetector.MIN_TRAINING_SAMPLES) {
            detector.observe(72, 98, 5000L)
        }
        assertTrue("Should be warmed up after ${IsolationForestDetector.MIN_TRAINING_SAMPLES} samples",
            detector.isWarmedUp)
    }

    @Test
    fun `result during warm-up has isWarmedUp false and isAnomaly false`() {
        val result = detector.observe(72, 98, 5000L)   // only 1 sample
        assertFalse(result.isWarmedUp)
        assertFalse(result.isAnomaly)
        assertTrue(result.reason.contains("Warm-up"))
    }

    @Test
    fun `missing vitals do not crash and return not-warmed-up result`() {
        val result = detector.observe(null, null, null)
        assertFalse(result.isWarmedUp)
        assertFalse(result.isAnomaly)
    }

    // -------------------------------------------------------------------------
    // 3. Normal inputs after warm-up
    // -------------------------------------------------------------------------

    @Test
    fun `normal vitals score below anomaly threshold after warm-up`() {
        // Train on realistic normal values with slight variation
        val trainingCount = IsolationForestDetector.MIN_TRAINING_SAMPLES + 10
        repeat(trainingCount) { i ->
            detector.observe(70 + (i % 5), 98, 6000L + i * 10)
        }
        assertTrue(detector.isWarmedUp)

        // Observe a typical normal reading
        val result = detector.observe(72, 98, 6000L)
        assertTrue(
            "Normal reading should score below threshold but got ${result.score}",
            result.score <= IsolationForestDetector.ANOMALY_THRESHOLD
        )
        assertFalse(result.isAnomaly)
    }

    // -------------------------------------------------------------------------
    // 4. Anomalous inputs after warm-up
    // -------------------------------------------------------------------------

    @Test
    fun `extreme vitals score above anomaly threshold after warm-up`() {
        // Train on a tight cluster of normal values
        val trainingCount = IsolationForestDetector.MIN_TRAINING_SAMPLES + 30
        repeat(trainingCount) { i ->
            detector.observe(70 + (i % 3), 98 - (i % 2), 5000L)
        }
        assertTrue(detector.isWarmedUp)

        // Inject a clearly anomalous reading — HR=180, SpO2=82, steps=0
        val result = detector.observe(180, 82, 0L)
        assertTrue(
            "Extreme reading should score above threshold but got ${result.score}",
            result.score > IsolationForestDetector.ANOMALY_THRESHOLD
        )
        assertTrue(result.isAnomaly)
        assertTrue(result.reason.contains("Isolation"))
    }

    // -------------------------------------------------------------------------
    // 5. Determinism / reproducibility
    // -------------------------------------------------------------------------

    @Test
    fun `same seed produces identical scores for same inputs`() {
        val detector2 = IsolationForestDetector(seed = 42L)

        val inputs = listOf(
            Triple(72, 98, 5000L),
            Triple(75, 97, 7000L),
            Triple(80, 96, 8000L)
        )

        val results1 = mutableListOf<Double>()
        val results2 = mutableListOf<Double>()

        // Warm up both identically
        val warmupCount = IsolationForestDetector.MIN_TRAINING_SAMPLES
        repeat(warmupCount) { detector.observe(71, 98, 5000L) }
        repeat(warmupCount) { detector2.observe(71, 98, 5000L) }

        inputs.forEach { (hr, spo2, steps) ->
            results1 += detector.observe(hr, spo2, steps).score
            results2 += detector2.observe(hr, spo2, steps).score
        }

        results1.zip(results2).forEach { (s1, s2) ->
            assertEquals("Scores differ with same seed", s1, s2, 0.0001)
        }
    }

    // -------------------------------------------------------------------------
    // 6. Reset
    // -------------------------------------------------------------------------

    @Test
    fun `reset clears warm-up and score`() {
        repeat(IsolationForestDetector.MIN_TRAINING_SAMPLES) {
            detector.observe(72, 98, 5000L)
        }
        assertTrue(detector.isWarmedUp)

        detector.reset()

        assertFalse(detector.isWarmedUp)
        assertEquals(0.0, detector.lastScore, 0.001)
        assertEquals(0, detector.observationCount)
    }

    // -------------------------------------------------------------------------
    // 7. MlAnomalyResult status labels
    // -------------------------------------------------------------------------

    @Test
    fun `statusLabel shows Warming up when not warmed up`() {
        val result = MlAnomalyResult(0.0, false, false, "Warm-up")
        assertTrue(result.statusLabel.contains("Warming", ignoreCase = true))
    }

    @Test
    fun `statusLabel shows Anomaly when anomaly detected`() {
        val result = MlAnomalyResult(0.75, true, true, "ML anomaly")
        assertTrue(result.statusLabel.contains("Anomaly", ignoreCase = true))
        assertTrue(result.statusLabel.contains("0.75"))
    }

    @Test
    fun `statusLabel shows Normal when no anomaly`() {
        val result = MlAnomalyResult(0.42, false, true, "ML normal")
        assertTrue(result.statusLabel.contains("Normal", ignoreCase = true))
    }

    // -------------------------------------------------------------------------
    // 8. Integration: detector feeds back into alert logic
    // -------------------------------------------------------------------------

    @Test
    fun `observe returns MlAnomalyResult with all fields populated`() {
        repeat(IsolationForestDetector.MIN_TRAINING_SAMPLES) {
            detector.observe(72, 98, 5000L)
        }
        val result = detector.observe(72, 98, 5000L)
        assertTrue(result.isWarmedUp)
        assertTrue(result.score in 0.0..1.0)
        assertNotNull(result.reason)
        assertNotNull(result.statusLabel)
    }
}
