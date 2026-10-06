package com.example.healthconnect.codelab.presentation.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Drawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController
) {
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Vitals",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .clickable {
                    scope.launch {
                        navController.navigate(Screen.Vitals.route) {
                            popUpTo(0)
                        }
                        scaffoldState.drawerState.close()
                    }
                }
        )

        Text(
            text = "Emergency Contacts",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .clickable {
                    scope.launch {
                        navController.navigate(Screen.EmergencyContacts.route) {
                            popUpTo(0)
                        }
                        scaffoldState.drawerState.close()
                    }
                }
        )

        Text(
            text = "My Profile",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .clickable {
                    scope.launch {
                        navController.navigate(Screen.Profile.route) {
                            popUpTo(0)
                        }
                        scaffoldState.drawerState.close()
                    }
                }
        )
    }
}
