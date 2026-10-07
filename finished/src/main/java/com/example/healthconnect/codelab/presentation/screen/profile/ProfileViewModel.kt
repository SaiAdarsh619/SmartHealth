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
package com.example.healthconnect.codelab.presentation.screen.profile

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthconnect.codelab.data.HealthConnectManager
import com.example.healthconnect.codelab.data.UserProfileManager
import com.example.healthconnect.codelab.logic.SmartHealthMonitor
import kotlinx.coroutines.launch

/**
 * ViewModel for the Profile screen. Loads the user's profile and system monitoring phase status.
 */
class ProfileViewModel(
    private val healthConnectManager: HealthConnectManager,
    val userProfileManager: UserProfileManager
) : ViewModel() {

    private val smartMonitor = SmartHealthMonitor(userProfileManager)

    var systemPhaseResult: MutableState<String> = mutableStateOf("Checking System Status...")
        set

    /**
     * Loads the current monitoring phase by fetching heart rate history and computing
     * the baseline phase from SmartHealthMonitor.
     */
    fun loadSystemStatus() {
        viewModelScope.launch {
            try {
                val history = healthConnectManager.getHeartRateHistory()
                val days = smartMonitor.getHistoryDurationDays(history)
                val phase = smartMonitor.getPhase(days, history.size)
                val baseline = smartMonitor.computeBaseline(history)
                systemPhaseResult.value = buildString {
                    appendLine("Phase: ${phase.name}")
                    appendLine("History: ${history.size} records over ${"%.1f".format(days)} days")
                    if (baseline != null) {
                        appendLine("Baseline HR: ${baseline.min}–${baseline.max} bpm (avg ${baseline.average})")
                    } else {
                        appendLine("Baseline: Not yet established")
                    }
                }.trim()
            } catch (e: Exception) {
                systemPhaseResult.value = "Unable to load status: ${e.message}"
            }
        }
    }
}
