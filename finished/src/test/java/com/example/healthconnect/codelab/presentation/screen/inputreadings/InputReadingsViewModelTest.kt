package com.example.healthconnect.codelab.presentation.screen.inputreadings

import org.junit.Assert.*
import org.junit.Test
import java.time.Instant
import java.time.temporal.ChronoUnit

class InputReadingsViewModelTest {

    // -------------------------------------------------------------------------
    // e. statistical fallback being allowed during warm-up
    // -------------------------------------------------------------------------
    @Test
    fun `statistical fallback triggers alert during warm up`() {
        // HR > 100 triggers statistical alert. isMlWarmedUp = false
        val (isCritical, message) = AnomalyAlertLogic.evaluateAlert(
            hr = 105,
            spo2 = 98,
            isMlWarmedUp = false,
            mlAnomaly = false,
            mlScore = 0.0
        )
        assertTrue(isCritical)
        assertTrue(message.contains("[STAT_FALLBACK]"))
        assertFalse(message.contains("[ML_ISOLATION_FOREST]"))
    }

    @Test
    fun `statistical fallback triggers alert for SpO2 during warm up`() {
        val (isCritical, message) = AnomalyAlertLogic.evaluateAlert(
            hr = 70,
            spo2 = 92, // < 95
            isMlWarmedUp = false,
            mlAnomaly = false,
            mlScore = 0.0
        )
        assertTrue(isCritical)
        assertTrue(message.contains("[STAT_FALLBACK] Low SpO2"))
    }

    // -------------------------------------------------------------------------
    // f. statistical detector NOT independently triggering duplicate alerts after ML activation
    // -------------------------------------------------------------------------
    @Test
    fun `statistical fallback is ignored after ML is warmed up`() {
        // Extreme HR and SpO2 which normally triggers statistical fallback.
        // However, isMlWarmedUp = true, and mlAnomaly = false (say the ML learned it's normal for athlete)
        val (isCritical, message) = AnomalyAlertLogic.evaluateAlert(
            hr = 105,
            spo2 = 92,
            isMlWarmedUp = true,
            mlAnomaly = false,
            mlScore = 0.4
        )
        // Since ML is primary, statistical fallback should NOT trigger.
        assertFalse(isCritical)
        assertFalse(message.contains("[STAT_FALLBACK]"))
    }

    @Test
    fun `ML primary detector triggers alert after warm up`() {
        // ML says it's an anomaly.
        val (isCritical, message) = AnomalyAlertLogic.evaluateAlert(
            hr = 180,
            spo2 = 85,
            isMlWarmedUp = true,
            mlAnomaly = true,
            mlScore = 0.85
        )
        assertTrue(isCritical)
        assertTrue(message.contains("[ML_ISOLATION_FOREST] Anomaly detected"))
        assertFalse(message.contains("[STAT_FALLBACK]")) // should not have stat fallback text
    }

    // -------------------------------------------------------------------------
    // g. cooldown preventing duplicate notifications
    // -------------------------------------------------------------------------
    @Test
    fun `cooldown prevents duplicate notifications within 1 minute`() {
        val lastAlertTime = Instant.now()
        
        // Check within a few seconds (should be false)
        val fewSecondsLater = lastAlertTime.plusSeconds(10)
        assertFalse(AnomalyAlertLogic.shouldSendAlert(lastAlertTime, fewSecondsLater))
        
        // Check after 1 minute has passed (should be true)
        val oneMinuteLater = lastAlertTime.plus(1, ChronoUnit.MINUTES).plusSeconds(1)
        assertTrue(AnomalyAlertLogic.shouldSendAlert(lastAlertTime, oneMinuteLater))
        
        // Check if lastAlertTime is null (should be true)
        assertTrue(AnomalyAlertLogic.shouldSendAlert(null, lastAlertTime))
    }
}

