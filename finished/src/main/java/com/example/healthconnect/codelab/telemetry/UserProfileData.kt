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

/**
 * Snapshot of user profile data for telemetry reporting.
 *
 * @param age User's age in years.
 * @param conditions Map of condition names to their boolean status (e.g. "has_heart_condition" -> true).
 * @param contacts List of emergency contacts associated with the user.
 */
data class UserProfileData(
    val age: Int,
    val conditions: Map<String, Boolean>,
    val contacts: List<EmergencyContact>
)
