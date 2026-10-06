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
package com.example.healthconnect.codelab.data

import androidx.health.connect.client.records.OxygenSaturationRecord
import android.content.Context
import android.os.Build
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.runtime.mutableStateOf
import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.HealthConnectClient.Companion.SDK_AVAILABLE
import androidx.health.connect.client.HealthConnectFeatures
import androidx.health.connect.client.PermissionController
import androidx.health.connect.client.permission.HealthPermission
import androidx.health.connect.client.records.HeartRateRecord
import androidx.health.connect.client.records.Record
import androidx.health.connect.client.records.StepsRecord
import androidx.health.connect.client.records.metadata.DataOrigin
import androidx.health.connect.client.request.ReadRecordsRequest
import androidx.health.connect.client.time.TimeRangeFilter
import java.time.Instant
import java.time.ZonedDateTime

// The minimum android level that can use Health Connect
const val MIN_SUPPORTED_SDK = Build.VERSION_CODES.O_MR1

/**
 * Demonstrates reading and writing from Health Connect.
 */
class HealthConnectManager(private val context: Context) {
  private val healthConnectClient by lazy { HealthConnectClient.getOrCreate(context) }

    val vitalsPermissions = setOf(
        HealthPermission.getReadPermission(HeartRateRecord::class),
        HealthPermission.getReadPermission(OxygenSaturationRecord::class),
        HealthPermission.getReadPermission(StepsRecord::class),
    )

  var availability = mutableStateOf(HealthConnectAvailability.NOT_SUPPORTED)
    private set

  init {
    checkAvailability()
  }

  fun checkAvailability() {
    availability.value = when {
      HealthConnectClient.getSdkStatus(context) == SDK_AVAILABLE -> HealthConnectAvailability.INSTALLED
      isSupported() -> HealthConnectAvailability.NOT_INSTALLED
      else -> HealthConnectAvailability.NOT_SUPPORTED
    }
  }

  fun isFeatureAvailable(feature: Int): Boolean{
    return healthConnectClient
      .features
      .getFeatureStatus(feature) == HealthConnectFeatures.FEATURE_STATUS_AVAILABLE
  }

    suspend fun readLatestHeartRate(): HeartRateRecord? {
        val now = Instant.now()
        val yesterday = now.minusSeconds(24 * 60 * 60)

        return readData<HeartRateRecord>(
            timeRangeFilter = TimeRangeFilter.between(yesterday, now)
        ).maxByOrNull { it.endTime }
    }

    /**
     * Reads heart rate history over a given window (defaults to 30 days).
     * Used by [com.example.healthconnect.codelab.logic.SmartHealthMonitor] to compute
     * the adaptive baseline and determine the monitoring phase.
     */
    suspend fun getHeartRateHistory(
        start: Instant = Instant.now().minusSeconds(30L * 24 * 60 * 60),
        end: Instant = Instant.now()
    ): List<HeartRateRecord> {
        return readData<HeartRateRecord>(
            timeRangeFilter = TimeRangeFilter.between(start, end)
        )
    }

    suspend fun readLatestSpO2(): OxygenSaturationRecord? {
        val now = Instant.now()
        val yesterday = now.minusSeconds(24 * 60 * 60)

        return readData<OxygenSaturationRecord>(
            timeRangeFilter = TimeRangeFilter.between(yesterday, now)
        ).maxByOrNull { it.time }
    }

    suspend fun readTodaySteps(): Long {
        val startOfDay = ZonedDateTime.now()
            .toLocalDate()
            .atStartOfDay(ZonedDateTime.now().zone)
            .toInstant()

        val now = Instant.now()

        val steps = readData<StepsRecord>(
            timeRangeFilter = TimeRangeFilter.between(startOfDay, now)
        )

        return steps.sumOf { it.count }
    }

//    suspend fun readLatestWeight(): WeightRecord? {
//        val now = Instant.now()
//        val lastMonth = now.minusSeconds(30L * 24 * 60 * 60)
//
//        return readData<WeightRecord>(
//            timeRangeFilter = TimeRangeFilter.between(lastMonth, now)
//        ).maxByOrNull { it.time }
//    }



  /**
   * Determines whether all the specified permissions are already granted. It is recommended to
   * call [PermissionController.getGrantedPermissions] first in the permissions flow, as if the
   * permissions are already granted then there is no need to request permissions via
   * [PermissionController.createRequestPermissionResultContract].
   */
  suspend fun hasAllPermissions(permissions: Set<String>): Boolean {
    return healthConnectClient.permissionController.getGrantedPermissions().containsAll(permissions)
  }

  fun requestPermissionsActivityContract(): ActivityResultContract<Set<String>, Set<String>> {
    return PermissionController.createRequestPermissionResultContract()
  }

  /**
   * Convenience function to reuse code for reading data.
   */
  private suspend inline fun <reified T : Record> readData(
      timeRangeFilter: TimeRangeFilter,
      dataOriginFilter: Set<DataOrigin> = setOf(),
  ): List<T> {
    val request = ReadRecordsRequest(
      recordType = T::class,
      dataOriginFilter = dataOriginFilter,
      timeRangeFilter = timeRangeFilter
    )
    return healthConnectClient.readRecords(request).records
  }

  private fun isSupported() = Build.VERSION.SDK_INT >= MIN_SUPPORTED_SDK
}

/**
 * Health Connect requires that the underlying Health Connect APK is installed on the device.
 * [HealthConnectAvailability] represents whether this APK is indeed installed, whether it is not
 * installed but supported on the device, or whether the device is not supported (based on Android
 * version).
 */
enum class HealthConnectAvailability {
  INSTALLED,
  NOT_INSTALLED,
  NOT_SUPPORTED
}
