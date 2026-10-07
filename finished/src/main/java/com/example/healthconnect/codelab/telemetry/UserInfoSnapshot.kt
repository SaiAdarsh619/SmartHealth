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

import com.example.healthconnect.codelab.data.EmergencyContact
import org.json.JSONArray
import org.json.JSONObject

/**
 * A telemetry snapshot of the user's info and health conditions at a point in time.
 * Used for logging user context alongside health readings.
 *
 * @param timestamp ISO-8601 timestamp of the snapshot.
 * @param age User's age in years.
 * @param conditions Map of health condition names to boolean flags.
 * @param contacts List of emergency contacts associated with the user.
 */
data class UserInfoSnapshot(
    val timestamp: String,
    val age: Int,
    val conditions: Map<String, Boolean>,
    val contacts: List<EmergencyContact>
) {
    /**
     * Serializes this snapshot to a JSON string for logging or network transmission.
     */
    fun toJson(): String {
        val json = JSONObject()
        json.put("type", "USER_INFO")
        json.put("timestamp", timestamp)
        json.put("age", age)

        val condJson = JSONObject()
        conditions.forEach { (k, v) -> condJson.put(k, v) }
        json.put("conditions", condJson)

        val contactsArray = JSONArray()
        contacts.forEach { contact ->
            val c = JSONObject()
            c.put("name", contact.name)
            c.put("phone", contact.phoneNumber)
            contactsArray.put(c)
        }
        json.put("contacts", contactsArray)

        return json.toString()
    }
}
