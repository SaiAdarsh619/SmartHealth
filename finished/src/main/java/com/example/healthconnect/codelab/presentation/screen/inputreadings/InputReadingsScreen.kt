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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthconnect.codelab.R
import com.example.healthconnect.codelab.presentation.theme.HealthConnectTheme
import java.util.UUID
import com.example.healthconnect.codelab.presentation.model.VitalUiModel
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@Composable
fun InputReadingsScreen(
    permissions: Set<String>,
    permissionsGranted: Boolean,
    uiState: InputReadingsViewModel.UiState,
    onError: (Throwable?) -> Unit = {},
    onPermissionsResult: () -> Unit = {},
    onPermissionsLaunch: (Set<String>) -> Unit = {},
    vitalsList: List<VitalUiModel>,
    mlStatusLabel: String = "ML: Not started",
    ) {

  // Remember the last error ID, such that it is possible to avoid re-launching the error
  // notification for the same error when the screen is recomposed, or configuration changes etc.
  val errorId = rememberSaveable { mutableStateOf(UUID.randomUUID()) }

    val context = LocalContext.current
    val smsPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        // Permission result handled by system
    }

    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            smsPermissionLauncher.launch(Manifest.permission.SEND_SMS)
        }
        onPermissionsResult()
    }



  if (uiState != InputReadingsViewModel.UiState.Uninitialized) {
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Top,
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      if (!permissionsGranted) {
        item {

            VitalsSection(vitalsList)

          Button(
            onClick = { onPermissionsLaunch(permissions) }
          ) {
            Text(text = stringResource(R.string.permissions_button_label))
          }
        }
      } else {

          // 🔹 VITALS DASHBOARD
          item {
              VitalsSection(vitalsList)
          }

          // 🤖 ML Anomaly Detector status badge (minimal — below vitals)
          item {
              MlStatusBadge(label = mlStatusLabel)
          }

      }
    }


      }
  }


@Composable
private fun VitalCard(vital: VitalUiModel) {
    androidx.compose.material.Card(
        elevation = 6.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = vital.type.title,
                style = MaterialTheme.typography.subtitle1
            )

            Text(
                text = "${vital.value} ${vital.type.unit}",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary
            )

            Text(
                text = "Updated",
                style = MaterialTheme.typography.caption
            )
        }
    }
}


@Composable
private fun VitalsSection(vitals: List<VitalUiModel>) {
    if (vitals.isEmpty()) return

    Text(
        text = "Vitals",
        fontSize = 24.sp,
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 12.dp)
    )

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        vitals.forEach { vital ->
            VitalCard(vital)
        }
    }
}

@Preview
@Composable
fun InputReadingsScreenPreview() {
  HealthConnectTheme(darkTheme = false) {
    InputReadingsScreen(
        permissions = setOf(),
        permissionsGranted = true,
        uiState = InputReadingsViewModel.UiState.Done,
        vitalsList = listOf(
            VitalUiModel(
                type = com.example.healthconnect.codelab.presentation.model.VitalType.HEART_RATE,
                value = "72",
                time = java.time.Instant.now()
            ),
             VitalUiModel(
                type = com.example.healthconnect.codelab.presentation.model.VitalType.SPO2,
                value = "98",
                time = java.time.Instant.now()
            )
        )
    )
  }
}

/** Small badge card showing the ML detector status below the vitals dashboard. */
@Composable
fun MlStatusBadge(label: String, modifier: Modifier = Modifier) {
    val isAnomaly = label.contains("Anomaly", ignoreCase = true)
    val isWarmingUp = label.contains("Warming", ignoreCase = true) || label.contains("Not started")

    val bgColor = when {
        isAnomaly    -> Color(0xFFFFCDD2)   // light red
        isWarmingUp  -> Color(0xFFFFF9C4)   // light yellow
        else         -> Color(0xFFC8E6C9)   // light green
    }
    val textColor = when {
        isAnomaly   -> Color(0xFFB71C1C)
        isWarmingUp -> Color(0xFFF57F17)
        else        -> Color(0xFF1B5E20)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        elevation = 2.dp,
        backgroundColor = bgColor
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            style = MaterialTheme.typography.caption,
            color = textColor
        )
    }
}
