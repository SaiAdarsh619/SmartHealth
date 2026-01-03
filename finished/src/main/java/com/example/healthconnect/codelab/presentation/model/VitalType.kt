package com.example.healthconnect.codelab.presentation.model

enum class VitalType(
    val title: String,
    val unit: String
) {
    HEART_RATE("Heart Rate", "bpm"),
    SPO2("SpO₂", "%"),
    STEPS("Steps", "steps")
}