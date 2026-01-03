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
import android.telephony.SmsManager
import android.util.Log

class InputReadingsViewModel(
    private val healthConnectManager: HealthConnectManager,
    private val contactsManager: EmergencyContactsManager
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
                    val steps = healthConnectManager.readTodaySteps()
                    if (steps > 0) {
                        vitalList.add(
                            VitalUiModel(
                                type = VitalType.STEPS,
                                value = steps.toString(),
                                time = Instant.now()
                            )
                        )
                    }
                    vitals.value = vitalList.sortedByDescending { it.time }

                    // Monitor for Emergency
                    checkAndSendAlert(
                        hr = vitalList.find { it.type == VitalType.HEART_RATE }?.value?.toIntOrNull(),
                        spo2 = vitalList.find { it.type == VitalType.SPO2 }?.value?.toIntOrNull()
                    )
                }
                kotlinx.coroutines.delay(5000)
            }
        }
    }

  private var lastAlertTime: Instant? = null

  private fun checkAndSendAlert(hr: Int?, spo2: Int?) {
      var isCritical = false
      val alertMessage = StringBuilder("EMERGENCY ALERT: User's vitals are critical! \\n")

      if (hr != null) {
          if (hr > 100) {
              isCritical = true
              alertMessage.append("High Heart Rate: $hr bpm. ")
          } else if (hr < 60) {
              isCritical = true
              alertMessage.append("Low Heart Rate: $hr bpm. ")
          }
      }

      if (spo2 != null && spo2 < 95) {
          isCritical = true
          alertMessage.append("Low SpO2: $spo2%. ")
      }

      if (isCritical) {
          val now = Instant.now()
          if (lastAlertTime == null || ChronoUnit.MINUTES.between(lastAlertTime, now) >= 1) {
              alertMessage.append("Please check on them immediately.")
              sendSmsToContacts(alertMessage.toString())
              lastAlertTime = now
          }
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
    private val contactsManager: EmergencyContactsManager
) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(InputReadingsViewModel::class.java)) {
      @Suppress("UNCHECKED_CAST")
      return InputReadingsViewModel(
        healthConnectManager = healthConnectManager,
        contactsManager = contactsManager
      ) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}
