/*
 * Copyright 2022 The Android Open Source Project
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
package com.example.healthconnect.codelab.presentation.screen.inputreadings

import androidx.health.connect.client.records.HeartRateRecord
import androidx.health.connect.client.records.OxygenSaturationRecord
import com.example.healthconnect.codelab.presentation.model.VitalType
import com.example.healthconnect.codelab.presentation.model.VitalUiModel


import android.os.RemoteException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.health.connect.client.permission.HealthPermission
import androidx.health.connect.client.records.StepsRecord
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.healthconnect.codelab.data.HealthConnectManager
import java.io.IOException
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.UUID
import kotlinx.coroutines.launch

import com.example.healthconnect.codelab.data.EmergencyContactsManager
import com.example.healthconnect.codelab.data.UserProfileManager
import com.example.healthconnect.codelab.logic.AlertStatus
import com.example.healthconnect.codelab.logic.IsolationForestDetector
import com.example.healthconnect.codelab.logic.MlAnomalyResult
import com.example.healthconnect.codelab.logic.SystemPhase
import com.example.healthconnect.codelab.telemetry.TelemetryManager
import com.example.healthconnect.codelab.telemetry.TelemetrySnapshot
import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.telephony.SmsManager
import android.util.Log
import androidx.core.content.ContextCompat

class InputReadingsViewModel(
    private val healthConnectManager: HealthConnectManager,
    private val contactsManager: EmergencyContactsManager,
    private val userProfileManager: UserProfileManager,
    private val context: Context
) :
  ViewModel() {
  val permissions = setOf(
      // Vitals (read-only)
      HealthPermission.getReadPermission(androidx.health.connect.client.records.HeartRateRecord::class),
      HealthPermission.getReadPermission(androidx.health.connect.client.records.OxygenSaturationRecord::class),
      HealthPermission.getReadPermission(StepsRecord::class)
  )

    var vitals = mutableStateOf<List<VitalUiModel>>(emptyList())
        private set

    var permissionsGranted = mutableStateOf(false)
        private set

    var uiState: UiState by mutableStateOf(UiState.Uninitialized)
        private set

    // -----------------------------------------------------------------------
    // ML Anomaly Detector — on-device Isolation Forest (no server required)
    // ⚠️ Research prototype. NOT a medical device.
    // -----------------------------------------------------------------------
    private val mlDetector = IsolationForestDetector(
        numTrees = IsolationForestDetector.NUM_TREES,
        subsampleSize = IsolationForestDetector.SUBSAMPLE_SIZE,
        seed = 42L   // fixed seed → reproducible results for paper
    )
    
    private val telemetryManager = TelemetryManager()

    /** Latest ML detection result — observed by the UI. */
    var mlStatus = mutableStateOf(
        MlAnomalyResult(0.0, false, false, "Not yet started")
    )
        private set

    val permissionsLauncher = healthConnectManager.requestPermissionsActivityContract()

    fun onPermissionsGranted() {
        viewModelScope.launch {
            permissionsGranted.value =
                healthConnectManager.hasAllPermissions(permissions)
//            Log.d("Vitals", "loadVitals called")


            if (permissionsGranted.value) {

                uiState = UiState.Done
                loadVitals()
            }
        }
    }



    fun initialLoad() {
    viewModelScope.launch {
      tryWithPermissionsCheck {
//        readWeightInputs()
          loadVitals()
      }
    }
  }

//  fun inputReadings(inputValue: Double) {
//    viewModelScope.launch {
//      tryWithPermissionsCheck {
//        healthConnectManager.writeWeightInput(inputValue)
////        readWeightInputs()
//      }
//    }
//  }

//  private suspend fun readWeightInputs() {
//    val now = Instant.now()
//    val start = now.minus(7, ChronoUnit.DAYS)
//    readingsList.value = healthConnectManager.readWeightInputs(start, now)
//    weeklyAvg.value = healthConnectManager.computeWeeklyAverage(start, now)
//  }

    fun loadVitals() {
        viewModelScope.launch {
            // Keep the loop running to ensure periodic updates
            while (true) {
                tryWithPermissionsCheck {
                    val vitalList = mutableListOf<VitalUiModel>()
                    // ❤️ Heart Rate
                    healthConnectManager.readLatestHeartRate()
                        ?.samples
                        ?.lastOrNull()
                        ?.let { sample ->
                            vitalList.add(
                                VitalUiModel(
                                    type = VitalType.HEART_RATE,
                                    value = sample.beatsPerMinute.toInt().toString(),
                                    time = sample.time
                                )
                            )
                        }

                    // 🫁 SpO₂
                    healthConnectManager.readLatestSpO2()
                        ?.let { record ->
                            vitalList.add(
                                VitalUiModel(
                                    type = VitalType.SPO2,
                                    value = (record.percentage.value).toInt().toString(),
                                    time = record.time
                                )
                            )
                        }

                    // 👣 Steps
                    val todaySteps = healthConnectManager.readTodaySteps()
                    if (todaySteps > 0) {
                        vitalList.add(
                            VitalUiModel(
                                type = VitalType.STEPS,
                                value = todaySteps.toString(),
                                time = Instant.now()
                            )
                        )
                    }
                    vitals.value = vitalList.sortedByDescending { it.time }

                    val hr   = vitalList.find { it.type == VitalType.HEART_RATE }?.value?.toIntOrNull()
                    val spo2 = vitalList.find { it.type == VitalType.SPO2 }?.value?.toIntOrNull()
                    val steps = vitalList.find { it.type == VitalType.STEPS }?.value?.toLongOrNull()

                    // ── ML Anomaly Detection ──────────────────────────────
                    // Feed current vitals into Isolation Forest on IO thread
                    val mlResult = mlDetector.observe(hr, spo2, steps)
                    mlStatus.value = mlResult
                    Log.i("ML_Eval",
                        "obs=${mlDetector.observationCount} " +
                        "warmedUp=${mlResult.isWarmedUp} " +
                        "score=${"%,.3f".format(mlResult.score)} " +
                        "anomaly=${mlResult.isAnomaly} " +
                        "hr=$hr spo2=$spo2 steps=$steps"
                    )

                    val alertStatus = if (mlResult.isAnomaly) AlertStatus.CRITICAL else AlertStatus.NORMAL
                    val systemPhase = if (mlResult.isWarmedUp) SystemPhase.PERSONALIZED else SystemPhase.COLD_START
                    val timestamp = Instant.now().toString()

                    hr?.let {
                        telemetryManager.send(TelemetrySnapshot(
                            timestamp = timestamp,
                            vitalType = "HEART_RATE",
                            currentValue = it.toDouble(),
                            alertStatus = alertStatus,
                            systemPhase = systemPhase,
                            decisionMessage = mlResult.reason,
                            anomalyScore = mlResult.score,
                            meta = emptyMap()
                        ))
                    }

                    spo2?.let {
                        telemetryManager.send(TelemetrySnapshot(
                            timestamp = timestamp,
                            vitalType = "SPO2",
                            currentValue = it.toDouble(),
                            alertStatus = alertStatus,
                            systemPhase = systemPhase,
                            decisionMessage = mlResult.reason,
                            anomalyScore = mlResult.score,
                            meta = emptyMap()
                        ))
                    }

                    steps?.let {
                        telemetryManager.send(TelemetrySnapshot(
                            timestamp = timestamp,
                            vitalType = "STEPS",
                            currentValue = it.toDouble(),
                            alertStatus = alertStatus,
                            systemPhase = systemPhase,
                            decisionMessage = mlResult.reason,
                            anomalyScore = mlResult.score,
                            meta = emptyMap()
                        ))
                    }
                    // ── Combined alert: stat fallback OR ML primary ────────
                    // During warm-up, the statistical check acts as a fallback.
                    // Once ML is initialized (warmed up), ML becomes the PRIMARY
                    // detector and statistical alerts are suppressed to prevent duplicates.
                    checkAndSendAlert(
                        hr = hr,
                        spo2 = spo2,
                        isMlWarmedUp = mlResult.isWarmedUp,
                        mlAnomaly = mlResult.isAnomaly && mlResult.isWarmedUp
                    )
                }
                kotlinx.coroutines.delay(5000)
            }
        }
    }

  private var lastAlertTime: Instant? = null

  /**
   * Combined statistical + ML anomaly checker.
   *
   * - WARM-UP PHASE: When [isMlWarmedUp] is false, uses the existing statistical
   *   thresholds (HR >100 / <60, SpO2 <95) as a temporary safety fallback.
   * - ACTIVE PHASE: Once [isMlWarmedUp] is true, the ML detector becomes the
   *   PRIMARY source of truth. Statistical alerts are disabled to prevent duplicate
   *   notifications.
   *
   * A single 1-minute cooldown prevents duplicate SMS alerts.
   *
   * ⚠️ Research prototype — NOT a medical device.
   */
  private fun checkAndSendAlert(hr: Int?, spo2: Int?, isMlWarmedUp: Boolean, mlAnomaly: Boolean) {
      val (isCritical, messageBuilder) = AnomalyAlertLogic.evaluateAlert(hr, spo2, isMlWarmedUp, mlAnomaly, mlDetector.lastScore)

      if (isCritical) {
          val now = Instant.now()
          if (AnomalyAlertLogic.shouldSendAlert(lastAlertTime, now)) {
              val userName = userProfileManager.name.ifBlank { "the user" }
              val location = getLastKnownLocation()
              val locationText = if (location != null) {
                  "\nLocation: https://maps.google.com/?q=${location.latitude},${location.longitude}"
              } else {
                  "\nLocation: Unavailable"
              }
              val finalMessage = "[SmartHealth ALERT] $userName's vitals are critical!\n" +
                  messageBuilder + "Please check on them immediately.$locationText"
              sendSmsToContacts(finalMessage)
              lastAlertTime = now
          }
      }
  }

  @SuppressLint("MissingPermission")
  private fun getLastKnownLocation(): Location? {
      val fineGranted = ContextCompat.checkSelfPermission(
          context, Manifest.permission.ACCESS_FINE_LOCATION
      ) == PackageManager.PERMISSION_GRANTED
      val coarseGranted = ContextCompat.checkSelfPermission(
          context, Manifest.permission.ACCESS_COARSE_LOCATION
      ) == PackageManager.PERMISSION_GRANTED
      if (!fineGranted && !coarseGranted) return null

      return try {
          val lm = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
          lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
              ?: lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
              ?: lm.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)
      } catch (e: Exception) {
          Log.w("Location", "Could not get last known location: ${e.message}")
          null
      }
  }

  private fun sendSmsToContacts(message: String) {
      val contacts = contactsManager.getContacts()
      if (contacts.isEmpty()) return

      try {
          val smsManager = SmsManager.getDefault()
          contacts.forEach { contact ->
              smsManager.sendTextMessage(contact.phoneNumber, null, message, null, null)
          }
          Log.d("Vitals", "Emergency SMS sent to ${contacts.size} contacts")
      } catch (e: Exception) {
          Log.e("Vitals", "Failed to send SMS: ${e.message}")
      }
  }

  /**
   * Provides permission check and error handling for Health Connect suspend function calls.
   *
   * Permissions are checked prior to execution of [block], and if all permissions aren't granted
   * the [block] won't be executed, and [permissionsGranted] will be set to false, which will
   * result in the UI showing the permissions button.
   *
   * Where an error is caught, of the type Health Connect is known to throw, [uiState] is set to
   * [UiState.Error], which results in the snackbar being used to show the error message.
   */
  private suspend fun tryWithPermissionsCheck(block: suspend () -> Unit) {
    permissionsGranted.value = healthConnectManager.hasAllPermissions(permissions)
    uiState = try {
      if (permissionsGranted.value) {
        block()
      }
      UiState.Done
    } catch (remoteException: RemoteException) {
      UiState.Error(remoteException)
    } catch (securityException: SecurityException) {
      UiState.Error(securityException)
    } catch (ioException: IOException) {
      UiState.Error(ioException)
    } catch (illegalStateException: IllegalStateException) {
      UiState.Error(illegalStateException)
    }
  }

  sealed class UiState {
    object Uninitialized : UiState()
    object Done : UiState()

    // A random UUID is used in each Error object to allow errors to be uniquely identified,
    // and recomposition won't result in multiple snackbars.
    data class Error(val exception: Throwable, val uuid: UUID = UUID.randomUUID()) : UiState()
  }
}

class InputReadingsViewModelFactory(
    private val healthConnectManager: HealthConnectManager,
    private val contactsManager: EmergencyContactsManager,
    private val userProfileManager: com.example.healthconnect.codelab.data.UserProfileManager,
    private val context: android.content.Context
) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(InputReadingsViewModel::class.java)) {
      @Suppress("UNCHECKED_CAST")
      return InputReadingsViewModel(
        healthConnectManager = healthConnectManager,
        contactsManager = contactsManager,
        userProfileManager = userProfileManager,
        context = context
      ) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}

/**
 * Pure logic object for determining anomaly alerts.
 * Extracted for pure unit testing without Android dependencies.
 */
object AnomalyAlertLogic {
    fun evaluateAlert(hr: Int?, spo2: Int?, isMlWarmedUp: Boolean, mlAnomaly: Boolean, mlScore: Double): Pair<Boolean, String> {
        var isCritical = false
        val alertMessage = StringBuilder("EMERGENCY ALERT: User's vitals are critical! \\n")

        if (!isMlWarmedUp) {
            // ── Statistical detector (temporary fallback during warm-up) ──
            if (hr != null) {
                if (hr > 100) {
                    isCritical = true
                    alertMessage.append("[STAT_FALLBACK] High Heart Rate: $hr bpm. ")
                } else if (hr < 60) {
                    isCritical = true
                    alertMessage.append("[STAT_FALLBACK] Low Heart Rate: $hr bpm. ")
                }
            }

            if (spo2 != null && spo2 < 95) {
                isCritical = true
                alertMessage.append("[STAT_FALLBACK] Low SpO2: $spo2%. ")
            }
        } else {
            // ── ML detector (PRIMARY after warm-up) ──────
            if (mlAnomaly) {
                isCritical = true
                alertMessage.append(
                    "[ML_ISOLATION_FOREST] Anomaly detected (score=${"%,.2f".format(mlScore)}). "
                )
            }
        }
        return Pair(isCritical, alertMessage.toString())
    }

    fun shouldSendAlert(lastAlertTime: Instant?, now: Instant): Boolean {
        return lastAlertTime == null || ChronoUnit.MINUTES.between(lastAlertTime, now) >= 1
    }
}
