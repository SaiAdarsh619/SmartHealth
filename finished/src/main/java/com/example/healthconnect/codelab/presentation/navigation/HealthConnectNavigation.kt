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
package com.example.healthconnect.codelab.presentation.navigation

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.example.healthconnect.codelab.data.HealthConnectManager
import com.example.healthconnect.codelab.presentation.screen.WelcomeScreen
//import com.example.healthconnect.codelab.presentation.screen.changes.DifferentialChangesScreen
//import com.example.healthconnect.codelab.presentation.screen.changes.DifferentialChangesViewModel
//import com.example.healthconnect.codelab.presentation.screen.changes.DifferentialChangesViewModelFactory
//import com.example.healthconnect.codelab.presentation.screen.exercisesession.ExerciseSessionScreen
//import com.example.healthconnect.codelab.presentation.screen.exercisesession.ExerciseSessionViewModel
//import com.example.healthconnect.codelab.presentation.screen.exercisesession.ExerciseSessionViewModelFactory
//import com.example.healthconnect.codelab.presentation.screen.exercisesessiondetail.ExerciseSessionDetailScreen
//import com.example.healthconnect.codelab.presentation.screen.exercisesessiondetail.ExerciseSessionDetailViewModel
//import com.example.healthconnect.codelab.presentation.screen.exercisesessiondetail.ExerciseSessionDetailViewModelFactory
import com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreen
import com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel
import com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModelFactory
import com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreen
import com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreen
import com.example.healthconnect.codelab.presentation.screen.profile.ProfileViewModel
import com.example.healthconnect.codelab.presentation.screen.profile.ProfileViewModelFactory
import com.example.healthconnect.codelab.data.EmergencyContactsManager
import com.example.healthconnect.codelab.data.UserProfileManager
import androidx.compose.ui.platform.LocalContext
import com.example.healthconnect.codelab.presentation.screen.privacypolicy.PrivacyPolicyScreen
import com.example.healthconnect.codelab.showExceptionSnackbar

/**
 * Provides the navigation in the app.
 */
@Composable
fun HealthConnectNavigation(
    navController: NavHostController,
    healthConnectManager: HealthConnectManager,
    scaffoldState: ScaffoldState,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Vitals.route
    ) {
        composable(Screen.Vitals.route) {
            val context = LocalContext.current
            val contactsManager = androidx.compose.runtime.remember { EmergencyContactsManager(context) }
            val userProfileManager = androidx.compose.runtime.remember { UserProfileManager(context) }
            val viewModel: InputReadingsViewModel = viewModel(
                factory = InputReadingsViewModelFactory(healthConnectManager, contactsManager, userProfileManager, context)
            )



            val permissionsGranted by viewModel.permissionsGranted
            val vitals by viewModel.vitals
            val permissions = viewModel.permissions
            val mlStatus by viewModel.mlStatus

            val permissionsLauncher =
                rememberLauncherForActivityResult(viewModel.permissionsLauncher) {
                    // THIS IS THE FIX
                    viewModel.onPermissionsGranted()
                }


            InputReadingsScreen(
                permissions = permissions,
                permissionsGranted = permissionsGranted,
                vitalsList = vitals,
                uiState = viewModel.uiState,
                mlStatusLabel = mlStatus.statusLabel,
                onPermissionsResult = { viewModel.initialLoad() },
                onPermissionsLaunch = { permissions ->
                    permissionsLauncher.launch(permissions)
                },
                onError = { /* snackbar optional */ }
            )
        }

        composable(Screen.EmergencyContacts.route) {
            val context = LocalContext.current
            val contactsManager = androidx.compose.runtime.remember { EmergencyContactsManager(context) }
            EmergencyContactsScreen(contactsManager = contactsManager)
        }

        composable(Screen.Profile.route) {
            val context = LocalContext.current
            val userProfileManager = androidx.compose.runtime.remember { UserProfileManager(context) }
            val profileViewModel: ProfileViewModel = viewModel(
                factory = ProfileViewModelFactory(healthConnectManager, userProfileManager)
            )
            ProfileScreen(viewModel = profileViewModel)
        }
    }
}

