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
package com.example.healthconnect.codelab.presentation.screen.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

/**
 * Screen for displaying and editing the user's health profile.
 * Stores personalized data used for adaptive health monitoring thresholds.
 */
@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    val userProfileManager = viewModel.userProfileManager

    var name by remember { mutableStateOf(userProfileManager.name) }
    var age by remember { mutableStateOf(userProfileManager.age.toString()) }
    var gender by remember { mutableStateOf(userProfileManager.gender) }
    var hasHeartCondition by remember { mutableStateOf(userProfileManager.hasHeartCondition) }
    var hasRespiratoryCondition by remember { mutableStateOf(userProfileManager.hasRespiratoryCondition) }
    var isAthlete by remember { mutableStateOf(userProfileManager.isAthlete) }
    var saveSuccess by remember { mutableStateOf(false) }

    val systemPhaseResult by viewModel.systemPhaseResult

    val genderOptions = listOf("Male", "Female", "Other")
    var genderExpanded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    // Load system phase status when screen is shown
    LaunchedEffect(Unit) {
        viewModel.loadSystemStatus()
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colors.primary
                )
                Text(
                    text = "My Profile",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "Your profile helps personalize health monitoring thresholds and alerts.",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
            )

            // System phase status card
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = 2.dp,
                backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.08f)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "🔍 Monitoring System Status",
                        style = MaterialTheme.typography.subtitle2,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colors.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = systemPhaseResult,
                        style = MaterialTheme.typography.body2
                    )
                }
            }

            Divider()

            // --- Basic Info Section ---
            Text(
                text = "Basic Information",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.SemiBold
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            OutlinedTextField(
                value = age,
                onValueChange = { age = it.filter { c -> c.isDigit() } },
                label = { Text("Age") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Gender dropdown
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = gender,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Gender") },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        TextButton(onClick = { genderExpanded = true }) {
                            Text("▼")
                        }
                    }
                )
                DropdownMenu(
                    expanded = genderExpanded,
                    onDismissRequest = { genderExpanded = false },
                    modifier = Modifier.fillMaxWidth(0.9f)
                ) {
                    genderOptions.forEach { option ->
                        DropdownMenuItem(onClick = {
                            gender = option
                            genderExpanded = false
                        }) {
                            Text(option)
                        }
                    }
                }
            }

            Divider()

            // --- Health Conditions Section ---
            Text(
                text = "Health Conditions",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.SemiBold
            )

            Card(modifier = Modifier.fillMaxWidth(), elevation = 2.dp) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Heart Condition", style = MaterialTheme.typography.body1, fontWeight = FontWeight.Medium)
                            Text("e.g. arrhythmia, heart failure", style = MaterialTheme.typography.caption,
                                color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f))
                        }
                        Switch(checked = hasHeartCondition, onCheckedChange = { hasHeartCondition = it })
                    }

                    Divider(modifier = Modifier.padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Respiratory Condition", style = MaterialTheme.typography.body1, fontWeight = FontWeight.Medium)
                            Text("e.g. asthma, COPD", style = MaterialTheme.typography.caption,
                                color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f))
                        }
                        Switch(checked = hasRespiratoryCondition, onCheckedChange = { hasRespiratoryCondition = it })
                    }
                }
            }

            Divider()

            // --- Activity Level Section ---
            Text(
                text = "Activity Level",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.SemiBold
            )

            Card(modifier = Modifier.fillMaxWidth(), elevation = 2.dp) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Athlete", style = MaterialTheme.typography.body1, fontWeight = FontWeight.Medium)
                        Text("Adjusts heart rate thresholds for athletes", style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f))
                    }
                    Switch(checked = isAthlete, onCheckedChange = { isAthlete = it })
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Save Button
            Button(
                onClick = {
                    val parsedAge = age.toIntOrNull() ?: userProfileManager.age
                    userProfileManager.name = name
                    userProfileManager.age = parsedAge
                    userProfileManager.gender = gender
                    userProfileManager.hasHeartCondition = hasHeartCondition
                    userProfileManager.hasRespiratoryCondition = hasRespiratoryCondition
                    userProfileManager.isAthlete = isAthlete
                    saveSuccess = true
                    viewModel.loadSystemStatus()
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Save Profile")
            }

            if (saveSuccess) {
                Card(
                    backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.1f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "✓ Profile saved successfully",
                        modifier = Modifier.padding(12.dp),
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}
