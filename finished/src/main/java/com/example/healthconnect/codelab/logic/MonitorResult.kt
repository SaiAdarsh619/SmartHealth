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
 * Result returned by [SmartHealthMonitor.assessStatus], containing the full
 * context of a monitoring decision.
 *
 * @param alert The health alert generated for the current reading.
 * @param baseline The computed baseline, or null if insufficient history.
 * @param phase The current system monitoring phase.
 * @param metrics Additional diagnostic metrics (hr, safeMin, safeMax, etc.).
 */
data class MonitorResult(
    val alert: HealthAlert,
    val baseline: SmartHealthMonitor.Baseline?,
    val phase: SystemPhase,
    val metrics: Map<String, Any>
)
