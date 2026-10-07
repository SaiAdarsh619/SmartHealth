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
package com.example.healthconnect.codelab.data

import android.content.Context
import android.content.SharedPreferences

/**
 * Manages user health profile data, persisted in SharedPreferences.
 * Stores user characteristics used for personalized health monitoring thresholds.
 */
class UserProfileManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("user_profile_prefs", Context.MODE_PRIVATE)

    var name: String
        get() = prefs.getString("name", "") ?: ""
        set(value) {
            prefs.edit().putString("name", value).apply()
        }

    var age: Int
        get() = prefs.getInt("age", 30)
        set(value) {
            prefs.edit().putInt("age", value).apply()
        }

    var gender: String
        get() = prefs.getString("gender", "Male") ?: "Male"
        set(value) {
            prefs.edit().putString("gender", value).apply()
        }

    var hasHeartCondition: Boolean
        get() = prefs.getBoolean("has_heart_condition", false)
        set(value) {
            prefs.edit().putBoolean("has_heart_condition", value).apply()
        }

    var hasRespiratoryCondition: Boolean
        get() = prefs.getBoolean("has_respiratory_condition", false)
        set(value) {
            prefs.edit().putBoolean("has_respiratory_condition", value).apply()
        }

    var isAthlete: Boolean
        get() = prefs.getBoolean("is_athlete", false)
        set(value) {
            prefs.edit().putBoolean("is_athlete", value).apply()
        }
}
