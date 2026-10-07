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
 * Represents the operational phase of the SmartHealth monitoring system.
 * - COLD_START: Initial phase with no historical baseline data.
 * - HYBRID: Transitional phase with partial baseline data available.
 * - PERSONALIZED: Full personalized monitoring with complete baseline established.
 */
enum class SystemPhase {
    COLD_START,
    HYBRID,
    PERSONALIZED
}
