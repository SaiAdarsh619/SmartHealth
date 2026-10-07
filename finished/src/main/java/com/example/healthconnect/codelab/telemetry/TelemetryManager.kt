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
package com.example.healthconnect.codelab.telemetry

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

/**
 * Sends telemetry data (vital readings and user info) to the remote telemetry endpoint.
 * All network operations are performed on the IO dispatcher.
 */
class TelemetryManager {

    private var endpointUrl: String = "https://telementryui.onrender.com/api/telemetry"
    private var isEnabled: Boolean = true

    fun setEndpoint(url: String) {
        endpointUrl = url
    }

    fun setEnabled(enabled: Boolean) {
        isEnabled = enabled
    }

    /** Send a vital reading telemetry snapshot. */
    fun send(snapshot: TelemetrySnapshot) {
        Log.d("Telemetry", "Attempting to send snapshot for ${snapshot.vitalType}")
        if (!isEnabled) {
            Log.d("Telemetry", "Telemetry disabled")
            return
        }
        CoroutineScope(Dispatchers.IO).launch {
            try {
                postData(snapshot.toJson())
            } catch (e: Exception) {
                Log.w("Telemetry", "Failed to send snapshot: ${e.message}")
            }
        }
    }

    /** Send a user info telemetry snapshot. */
    fun send(snapshot: UserInfoSnapshot) {
        Log.d("Telemetry", "Attempting to send USER_INFO")
        if (!isEnabled) return
        CoroutineScope(Dispatchers.IO).launch {
            try {
                postData(snapshot.toJson())
            } catch (e: Exception) {
                Log.w("Telemetry", "Failed to send user info: ${e.message}")
            }
        }
    }

    private fun postData(jsonData: String) {
        val url = URL(endpointUrl)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
        conn.setRequestProperty("Accept", "application/json")
        conn.doOutput = true
        conn.connectTimeout = 10000
        conn.readTimeout = 10000

        conn.outputStream.use { os ->
            OutputStreamWriter(os, "UTF-8").use { writer ->
                writer.write(jsonData)
                writer.flush()
            }
        }

        val responseCode = conn.responseCode
        if (responseCode in 200..299) {
            Log.d("Telemetry", "Data sent successfully: $responseCode")
        } else {
            Log.w("Telemetry", "Server returned error: $responseCode")
        }
        conn.disconnect()
    }
}
