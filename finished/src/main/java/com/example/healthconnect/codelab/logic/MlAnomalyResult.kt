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

/**
 * Result from the on-device ML anomaly detector ([IsolationForestDetector]).
 *
 * @param score         Anomaly score in [0, 1]. Higher = more anomalous.
 *                      Scores above [IsolationForestDetector.ANOMALY_THRESHOLD]
 *                      are flagged as anomalies.
 * @param isAnomaly     True if [score] exceeds the configured threshold.
 * @param isWarmedUp    False during the initial warm-up period; scores are not
 *                      meaningful until this becomes true.
 * @param reason        Human-readable explanation for logging / display.
 *
 * ⚠️ NOT a medical diagnosis. Research prototype only.
 */
data class MlAnomalyResult(
    val score: Double,
    val isAnomaly: Boolean,
    val isWarmedUp: Boolean,
    val reason: String
) {
    /** Display label for the UI status badge. */
    val statusLabel: String get() = when {
        !isWarmedUp -> "ML: Warming up…"
        isAnomaly   -> "ML: ⚠ Anomaly (%.2f)".format(score)
        else        -> "ML: Normal (%.2f)".format(score)
    }
}
