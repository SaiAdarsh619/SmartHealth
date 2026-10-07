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

import androidx.health.connect.client.records.HeartRateRecord
import com.example.healthconnect.codelab.data.UserProfileManager

/**
 * Core adaptive health monitoring engine.
 * Assesses vitals using a 3-phase approach:
 *  - COLD_START: No history; uses medical reference ranges only.
 *  - HYBRID: Some history; blends medical range with weak baseline.
 *  - PERSONALIZED: Enough history; uses personal baseline with medical fallback.
 */
class SmartHealthMonitor(private val userProfile: UserProfileManager) {

    /**
     * Computed baseline statistics from historical heart rate data.
     */
    data class Baseline(
        val min: Int,
        val max: Int,
        val average: Int,
        val dataDurationDays: Double
    )

    private fun getMedicalReferenceRange(age: Int, isAthlete: Boolean): Pair<Int, Int> {
        return when {
            isAthlete -> Pair(45, 90)
            age in 18..59 -> Pair(60, 100)
            age >= 60 -> Pair(55, 95)
            else -> Pair(60, 100)
        }
    }

    fun getPhase(dataDurationDays: Double, recordCount: Int): SystemPhase {
        return when {
            dataDurationDays >= 7 && recordCount >= 20 -> SystemPhase.PERSONALIZED
            dataDurationDays >= 1 || recordCount >= 5 -> SystemPhase.HYBRID
            else -> SystemPhase.COLD_START
        }
    }

    fun getHistoryDurationDays(history: List<HeartRateRecord>): Double {
        if (history.isEmpty()) return 0.0
        val startTimes = history.map { it.startTime.epochSecond }
        val earliest = startTimes.minOrNull() ?: 0L
        val latest = startTimes.maxOrNull() ?: 0L
        val diffSeconds = maxOf(latest - earliest, 0L)
        return diffSeconds / 86400.0
    }

    fun computeBaseline(history: List<HeartRateRecord>): Baseline? {
        if (history.isEmpty()) return null
        val days = getHistoryDurationDays(history)
        val allSamples = history.flatMap { it.samples }.map { it.beatsPerMinute.toInt() }
        if (allSamples.size < 5) return null
        val min = allSamples.minOrNull() ?: 60
        val max = allSamples.maxOrNull() ?: 100
        val average = allSamples.average().toInt()
        return Baseline(min, max, average, days)
    }

    /**
     * Assess heart rate status against user profile and historical baseline.
     */
    fun assessStatus(currentHr: Int, history: List<HeartRateRecord>): MonitorResult {
        val age = userProfile.age
        val hasCondition = userProfile.hasHeartCondition
        val isAthlete = userProfile.isAthlete
        val (safeMin, safeMax) = getMedicalReferenceRange(age, isAthlete)

        // Hard safety limit
        if (currentHr < 40 || currentHr > 180) {
            return MonitorResult(
                alert = HealthAlert(
                    AlertStatus.CRITICAL,
                    "Critical: Heart Rate $currentHr bpm is EXTREME (Danger Zone).",
                    "L1: Hard Safety Limit Hit (<40 or >180)"
                ),
                baseline = null,
                phase = SystemPhase.COLD_START,
                metrics = mapOf("hr" to currentHr, "trigger" to "hard_limit")
            )
        }

        val baseline = computeBaseline(history)
        val daysHistory = baseline?.dataDurationDays ?: 0.0
        val phase = getPhase(daysHistory, history.size)

        val alert = when (phase) {
            SystemPhase.COLD_START -> {
                if (currentHr in safeMin..safeMax) {
                    HealthAlert(AlertStatus.NORMAL, "Vitals are normal.", "Ph1 [Cold Start]: Within Medical Range ($safeMin-$safeMax)")
                } else {
                    val status = if (currentHr > safeMax + 15 || currentHr < safeMin - 10) AlertStatus.CRITICAL else AlertStatus.WARNING
                    HealthAlert(status, "Warning: Heart Rate $currentHr bpm is outside medical norms ($safeMin-$safeMax).", "Ph1 [Cold Start]: Medical Range Check")
                }
            }
            SystemPhase.HYBRID -> {
                if (currentHr in safeMin..safeMax) {
                    val base = HealthAlert(AlertStatus.NORMAL, "Vitals are normal.", "Ph2 [Hybrid]: Normal")
                    if (baseline != null && (currentHr > baseline.max + 15 || currentHr < baseline.min - 15)) {
                        HealthAlert(AlertStatus.WARNING, "Notice: Unusual activity detected ($currentHr). Learning your baseline...", "Ph2 [Hybrid]: Weak Baseline Deviation")
                    } else base
                } else {
                    val status = if (currentHr > safeMax + 20) AlertStatus.CRITICAL else AlertStatus.WARNING
                    HealthAlert(status, "Warning: Heart Rate $currentHr bpm is outside medical norms.", "Ph2 [Hybrid]: Medical Range Exceeded")
                }
            }
            SystemPhase.PERSONALIZED -> {
                var padding = if (hasCondition) 5 else 10
                if (isAthlete) padding = 12
                if (age > 60) padding = 12
                if (baseline == null) {
                    HealthAlert(AlertStatus.NORMAL, "Vitals are normal.", "Ph3 [Personalized]: Missing Baseline Data")
                } else {
                    val pMin = baseline.min - padding
                    val pMax = baseline.max + padding
                    when {
                        currentHr in pMin..pMax ->
                            HealthAlert(AlertStatus.NORMAL, "Vitals are normal.", "Ph3 [Personalized]: Within Personal Range")
                        currentHr in (safeMin - 5)..(safeMax + 10) ->
                            HealthAlert(AlertStatus.WARNING, "Warning: Rate $currentHr is unusual for your history ($pMin-$pMax).", "Ph3 [Personalized]: Baseline Anomaly")
                        else ->
                            HealthAlert(AlertStatus.CRITICAL, "Critical: Heart Rate $currentHr is abnormal for you AND medically high.", "Ph3 [Personalized]: Baseline + Medical Critical")
                    }
                }
            }
        }

        return MonitorResult(
            alert = alert,
            baseline = baseline,
            phase = phase,
            metrics = mapOf(
                "hr" to currentHr,
                "safeMin" to safeMin,
                "safeMax" to safeMax,
                "historyCount" to history.size,
                "daysHistory" to daysHistory
            )
        )
    }

    /**
     * Assess SpO2 (blood oxygen) status.
     */
    fun assessSpO2Status(currentSpO2: Int): HealthAlert {
        return when {
            currentSpO2 < 90 -> HealthAlert(AlertStatus.CRITICAL, "CRITICAL: SpO2 $currentSpO2% is Dangerously LOW.", "SpO2 Hard Limit (<90%)")
            currentSpO2 < 92 -> HealthAlert(AlertStatus.WARNING, "Warning: SpO2 $currentSpO2% is Low (Hypoxia risk).", "SpO2 Warning (<92%)")
            currentSpO2 < 95 -> HealthAlert(AlertStatus.WARNING, "Notice: SpO2 $currentSpO2% is slightly below normal.", "SpO2 Notice (<95%)")
            else -> HealthAlert(AlertStatus.NORMAL, "SpO2 is normal.", "SpO2 Normal (>=95%)")
        }
    }
}
