package com.example.healthconnect.codelab.presentation.model

import java.time.Instant

data class VitalUiModel(
    val type: VitalType,
    val value: String,
    val time: Instant
)
