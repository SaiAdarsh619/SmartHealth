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
package com.example.healthconnect.codelab.service

import android.Manifest
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.IBinder
import android.telephony.SmsManager
import android.telephony.SubscriptionManager
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.healthconnect.codelab.data.EmergencyContactsManager
import com.example.healthconnect.codelab.data.HealthConnectManager
import com.example.healthconnect.codelab.data.UserProfileManager
import com.example.healthconnect.codelab.logic.AlertStatus
import com.example.healthconnect.codelab.logic.IsolationForestDetector
import com.example.healthconnect.codelab.logic.MlAnomalyResult
import com.example.healthconnect.codelab.logic.SystemPhase
import com.example.healthconnect.codelab.presentation.MainActivity
import com.example.healthconnect.codelab.presentation.screen.inputreadings.AnomalyAlertLogic
import com.example.healthconnect.codelab.telemetry.TelemetryManager
import com.example.healthconnect.codelab.telemetry.TelemetrySnapshot
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.temporal.ChronoUnit

/**
 * Foreground Service that continuously monitors health vitals in the background.
 *
 * Runs an infinite polling loop every 30 seconds to:
 *  1. Read latest vitals from Health Connect
 *  2. Run Isolation Forest ML anomaly detection
 *  3. Send SMS alerts to emergency contacts if anomalies are detected
 *  4. Send telemetry to remote backend
 *
 * The service displays a persistent notification while running so Android
 * does not kill it under memory pressure.
 */
class HealthMonitorService : Service() {

    companion object {
        const val CHANNEL_ID = "smart_health_monitor"
        const val NOTIFICATION_ID = 1001
        const val ACTION_START = "com.example.healthconnect.ACTION_START_MONITOR"
        const val ACTION_STOP  = "com.example.healthconnect.ACTION_STOP_MONITOR"

        /** How frequently (in ms) to poll Health Connect for new vitals. */
        private const val POLL_INTERVAL_MS = 30_000L

        fun startIntent(context: Context): Intent =
            Intent(context, HealthMonitorService::class.java).apply { action = ACTION_START }

        fun stopIntent(context: Context): Intent =
            Intent(context, HealthMonitorService::class.java).apply { action = ACTION_STOP }
    }

    private val serviceScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    private var monitorJob: Job? = null

    private lateinit var healthConnectManager: HealthConnectManager
    private lateinit var contactsManager: EmergencyContactsManager
    private lateinit var userProfileManager: UserProfileManager
    private lateinit var telemetryManager: TelemetryManager

    private val mlDetector = IsolationForestDetector(
        numTrees = IsolationForestDetector.NUM_TREES,
        subsampleSize = IsolationForestDetector.SUBSAMPLE_SIZE,
        seed = 42L
    )

    private var lastAlertTime: Instant? = null

    // -----------------------------------------------------------------------
    // Lifecycle
    // -----------------------------------------------------------------------

    override fun onCreate() {
        super.onCreate()
        healthConnectManager = HealthConnectManager(applicationContext)
        contactsManager     = EmergencyContactsManager(applicationContext)
        userProfileManager  = UserProfileManager(applicationContext)
        telemetryManager    = TelemetryManager()

        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_STOP -> {
                stopMonitoring()
                stopSelf()
                return START_NOT_STICKY
            }
            else -> {
                startForeground(NOTIFICATION_ID, buildNotification("Smart Health is monitoring your vitals…"))
                startMonitoring()
            }
        }
        // Restart service if killed by Android
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        stopMonitoring()
        super.onDestroy()
    }

    // -----------------------------------------------------------------------
    // Monitoring loop
    // -----------------------------------------------------------------------

    private fun startMonitoring() {
        if (monitorJob?.isActive == true) return
        monitorJob = serviceScope.launch {
            Log.i("HealthMonitorService", "Background monitoring started")
            while (true) {
                try {
                    runMonitoringCycle()
                } catch (e: Exception) {
                    Log.e("HealthMonitorService", "Error in monitoring cycle: ${e.message}")
                }
                delay(POLL_INTERVAL_MS)
            }
        }
    }

    private fun stopMonitoring() {
        monitorJob?.cancel()
        monitorJob = null
        Log.i("HealthMonitorService", "Background monitoring stopped")
    }

    private suspend fun runMonitoringCycle() {
        val permissions = healthConnectManager.vitalsPermissions
        if (!healthConnectManager.hasAllPermissions(permissions)) {
            Log.w("HealthMonitorService", "Health Connect permissions not granted — skipping cycle")
            updateNotification("Waiting for Health Connect permissions…")
            return
        }

        // ── 1. Read vitals ───────────────────────────────────────────────────
        val hrRecord   = healthConnectManager.readLatestHeartRate()
        val spo2Record = healthConnectManager.readLatestSpO2()
        val steps      = healthConnectManager.readTodaySteps()

        val hr   = hrRecord?.samples?.lastOrNull()?.beatsPerMinute?.toInt()
        val spo2 = spo2Record?.percentage?.value?.toInt()

        Log.d("HealthMonitorService", "Vitals — HR:$hr SpO2:$spo2 Steps:$steps")

        // ── 2. ML anomaly detection ──────────────────────────────────────────
        val mlResult: MlAnomalyResult = mlDetector.observe(hr, spo2, if (steps > 0) steps else null)

        val alertStatus  = if (mlResult.isAnomaly) AlertStatus.CRITICAL else AlertStatus.NORMAL
        val systemPhase  = if (mlResult.isWarmedUp) SystemPhase.PERSONALIZED else SystemPhase.COLD_START
        val timestamp    = Instant.now().toString()

        Log.i("HealthMonitorService",
            "ML: warmedUp=${mlResult.isWarmedUp} anomaly=${mlResult.isAnomaly} " +
            "score=${"%.3f".format(mlResult.score)}")

        // ── 3. Telemetry ─────────────────────────────────────────────────────
        hr?.let {
            telemetryManager.send(TelemetrySnapshot(
                timestamp     = timestamp,
                vitalType     = "HEART_RATE",
                currentValue  = it.toDouble(),
                alertStatus   = alertStatus,
                systemPhase   = systemPhase,
                decisionMessage = mlResult.reason,
                anomalyScore  = mlResult.score,
                meta          = emptyMap()
            ))
        }
        spo2?.let {
            telemetryManager.send(TelemetrySnapshot(
                timestamp     = timestamp,
                vitalType     = "SPO2",
                currentValue  = it.toDouble(),
                alertStatus   = alertStatus,
                systemPhase   = systemPhase,
                decisionMessage = mlResult.reason,
                anomalyScore  = mlResult.score,
                meta          = emptyMap()
            ))
        }
        if (steps > 0) {
            telemetryManager.send(TelemetrySnapshot(
                timestamp     = timestamp,
                vitalType     = "STEPS",
                currentValue  = steps.toDouble(),
                alertStatus   = alertStatus,
                systemPhase   = systemPhase,
                decisionMessage = mlResult.reason,
                anomalyScore  = mlResult.score,
                meta          = emptyMap()
            ))
        }

        // ── 4. Alert logic & SMS ─────────────────────────────────────────────
        val mlAnomaly = mlResult.isAnomaly && mlResult.isWarmedUp
        val (isCritical, messageBuilder) = AnomalyAlertLogic.evaluateAlert(
            hr, spo2, mlResult.isWarmedUp, mlAnomaly, mlDetector.lastScore
        )

        if (isCritical) {
            val now = Instant.now()
            if (AnomalyAlertLogic.shouldSendAlert(lastAlertTime, now)) {
                val userName     = userProfileManager.name.ifBlank { "the user" }
                val location     = getLastKnownLocation()
                val locationText = if (location != null)
                    "\nLocation: https://maps.google.com/?q=${location.latitude},${location.longitude}"
                else "\nLocation: Unavailable"

                val finalMessage =
                    "[SmartHealth ALERT] $userName's vitals are critical!\n" +
                    "$messageBuilder Please check on them immediately.$locationText"

                sendSmsToContacts(finalMessage)
                lastAlertTime = now
                updateNotification("⚠️ ALERT sent to emergency contacts!")
            } else {
                updateNotification("⚠️ Anomaly detected — HR:$hr bpm, SpO2:$spo2%")
            }
        } else {
            val statusText = buildString {
                hr?.let   { append("HR: ${it} bpm  ") }
                spo2?.let { append("SpO2: ${it}%") }
            }.ifBlank { "Monitoring…" }
            updateNotification("✅ $statusText")
        }
    }

    // -----------------------------------------------------------------------
    // SMS helpers
    // -----------------------------------------------------------------------

    private fun sendSmsToContacts(message: String) {
        val contacts = contactsManager.getContacts()
        if (contacts.isEmpty()) {
            Log.w("HealthMonitorService", "No emergency contacts to notify")
            return
        }
        try {
            val defaultSmsId = SubscriptionManager.getDefaultSmsSubscriptionId()
            val fallbackId   = SubscriptionManager.getDefaultSubscriptionId()
            val smsManager   = when {
                defaultSmsId != SubscriptionManager.INVALID_SUBSCRIPTION_ID ->
                    SmsManager.getSmsManagerForSubscriptionId(defaultSmsId)
                fallbackId != SubscriptionManager.INVALID_SUBSCRIPTION_ID ->
                    SmsManager.getSmsManagerForSubscriptionId(fallbackId)
                else -> SmsManager.getDefault()
            }
            contacts.forEach { contact ->
                smsManager.sendTextMessage(contact.phoneNumber, null, message, null, null)
            }
            Log.d("HealthMonitorService", "Emergency SMS sent to ${contacts.size} contacts")
        } catch (e: Exception) {
            Log.e("HealthMonitorService", "Failed to send SMS: ${e.message}")
        }
    }

    // -----------------------------------------------------------------------
    // Location helper
    // -----------------------------------------------------------------------

    @SuppressLint("MissingPermission")
    private fun getLastKnownLocation(): Location? {
        val fineGranted = ContextCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val coarseGranted = ContextCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        if (!fineGranted && !coarseGranted) return null

        return try {
            val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                ?: lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                ?: lm.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)
        } catch (e: Exception) {
            Log.w("HealthMonitorService", "Could not get location: ${e.message}")
            null
        }
    }

    // -----------------------------------------------------------------------
    // Notification helpers
    // -----------------------------------------------------------------------

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Smart Health Monitor",
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = "Ongoing health vitals monitoring"
            setShowBadge(false)
        }
        val nm = getSystemService(NotificationManager::class.java)
        nm.createNotificationChannel(channel)
    }

    private fun buildNotification(contentText: String): Notification {
        val openAppIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        val pendingOpen = PendingIntent.getActivity(
            this, 0, openAppIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val stopPendingIntent = PendingIntent.getService(
            this, 1, stopIntent(this),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Smart Health")
            .setContentText(contentText)
            .setSmallIcon(android.R.drawable.ic_menu_compass)
            .setOngoing(true)
            .setContentIntent(pendingOpen)
            .addAction(android.R.drawable.ic_delete, "Stop", stopPendingIntent)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
    }

    private fun updateNotification(contentText: String) {
        val nm = getSystemService(NotificationManager::class.java)
        nm.notify(NOTIFICATION_ID, buildNotification(contentText))
    }
}
