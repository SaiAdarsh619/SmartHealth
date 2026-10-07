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
package com.example.healthconnect.codelab.telemetry

import com.example.healthconnect.codelab.logic.AlertStatus
import com.example.healthconnect.codelab.logic.SystemPhase
import org.json.JSONArray
import org.json.JSONObject

/**
 * A comprehensive telemetry snapshot for a single vital reading, including
 * baseline statistics, anomaly scoring, alert status, system phase and user profile.
 *
 * @param timestamp ISO-8601 timestamp of the reading.
 * @param vitalType The type of vital being measured (e.g. "HEART_RATE", "OXYGEN_SATURATION").
 * @param currentValue The current measured value.
 * @param alertStatus The alert level derived from this reading.
 * @param systemPhase The current operational phase of the monitoring system.
 * @param decisionMessage Human-readable explanation of the monitoring decision.
 * @param baselineMin Minimum value in the user's established baseline (null if not yet established).
 * @param baselineMax Maximum value in the user's established baseline (null if not yet established).
 * @param baselineAvg Average value in the user's established baseline (null if not yet established).
 * @param anomalyScore Anomaly score for this reading, higher means more unusual (null if not computed).
 * @param meta Additional key-value metadata for extensibility.
 * @param userProfile Optional snapshot of the user's profile at time of reading.
 */
data class TelemetrySnapshot(
    val timestamp: String,
    val vitalType: String,
    val currentValue: Double,
    val alertStatus: AlertStatus,
    val systemPhase: SystemPhase,
    val decisionMessage: String,
    val baselineMin: Int? = null,
    val baselineMax: Int? = null,
    val baselineAvg: Int? = null,
    val anomalyScore: Double? = null,
    val meta: Map<String, Any>,
    val userProfile: UserProfileData? = null
) {
    /**
     * Serializes this snapshot to a JSON string for logging or network transmission.
     */
    fun toJson(): String {
        val json = JSONObject()
        json.put("timestamp", timestamp)
        json.put("vital_type", vitalType)
        json.put("value", currentValue)
        json.put("status", alertStatus.name)
        json.put("phase", systemPhase.name)
        json.put("decision", decisionMessage)

        baselineMin?.let { json.put("baseline_min", it) }
        baselineMax?.let { json.put("baseline_max", it) }
        baselineAvg?.let { json.put("baseline_avg", it) }

        val metaJson = JSONObject()
        meta.forEach { (k, v) -> metaJson.put(k, v) }
        json.put("meta", metaJson)

        userProfile?.let { profile ->
            val profileJson = JSONObject()
            profileJson.put("age", profile.age)

            val condJson = JSONObject()
            profile.conditions.forEach { (k, v) -> condJson.put(k, v) }
            profileJson.put("conditions", condJson)

            val contactsArray = JSONArray()
            profile.contacts.forEach { contact ->
                val c = JSONObject()
                c.put("name", contact.name)
                c.put("phone", contact.phoneNumber)
                contactsArray.put(c)
            }
            profileJson.put("contacts", contactsArray)
            json.put("user_profile", profileJson)
        }

        return json.toString()
    }
}
