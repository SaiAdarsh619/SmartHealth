package com.example.healthconnect.codelab.presentation.screen.emergency

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.healthconnect.codelab.data.EmergencyContact
import com.example.healthconnect.codelab.data.EmergencyContactsManager
import android.telephony.SmsManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun EmergencyContactsScreen(
    contactsManager: EmergencyContactsManager
) {
    var contacts by remember { mutableStateOf(contactsManager.getContacts()) }
    var showAddDialog by remember { mutableStateOf(false) }
    var contactToEdit by remember { mutableStateOf<EmergencyContact?>(null) }
    val context = LocalContext.current
    var hasSmsPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED
        )
    }

    val lifecycleOwner = LocalLifecycleOw   ner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                hasSmsPermission = ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.SEND_SMS
                ) == PackageManager.PERMISSION_GRANTED
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            hasSmsPermission = isGranted
            if (isGranted) {
                Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Permission Denied. Alert cannot be sent.", Toast.LENGTH_SHORT).show()
            }
        }
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { 
                contactToEdit = null
                showAddDialog = true 
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add Contact")
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding).fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Emergency Contacts",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(16.dp)
                )

                if (!hasSmsPermission) {
                    Text(
                        text = "⚠️ SMS Permission Missing. Alerts will NOT work.",
                        color = MaterialTheme.colors.error,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                LazyColumn {
                    items(contacts) { contact ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            elevation = 4.dp
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(text = contact.name, style = MaterialTheme.typography.h6)
                                    Text(text = contact.phoneNumber, style = MaterialTheme.typography.body1)
                                }
                                Row {
                                    IconButton(onClick = {
                                        contactToEdit = contact
                                        showAddDialog = true
                                    }) {
                                        Icon(
                                            Icons.Default.Edit,
                                            contentDescription = "Edit",
                                            tint = MaterialTheme.colors.primary
                                        )
                                    }
                                    IconButton(onClick = {
                                        contactsManager.removeContact(contact.id)
                                        contacts = contactsManager.getContacts()
                                    }) {
                                        Icon(
                                            Icons.Default.Delete,
                                            contentDescription = "Delete",
                                            tint = MaterialTheme.colors.error
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Test Button at Bottom Start
            Button(
                modifier = Modifier.align(Alignment.BottomStart).padding(16.dp),
                onClick = {
                    if (!hasSmsPermission) {
                        launcher.launch(Manifest.permission.SEND_SMS)
                    } else {
                        val currentContacts = contactsManager.getContacts()
                        if (currentContacts.isEmpty()) {
                            Toast.makeText(context, "No contacts to test", Toast.LENGTH_SHORT).show()
                        } else {
                            try {
                                val smsManager = SmsManager.getDefault()
                                currentContacts.forEach { contact ->
                                    smsManager.sendTextMessage(
                                        contact.phoneNumber,
                                        null,
                                        "TEST ALERT: This is a test from Health Connect App.",
                                        null,
                                        null
                                    )
                                }
                                Toast.makeText(
                                    context,
                                    "Test SMS Sent to ${currentContacts.size} contacts",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } catch (e: Exception) {
                                Toast.makeText(context, "Failed to send SMS: ${e.message}", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Text("Test Alert", color = MaterialTheme.colors.onSecondary)
            }
        }
    }

    if (showAddDialog) {
        val isEdit = contactToEdit != null
        AddContactDialog(
            initialName = contactToEdit?.name ?: "",
            initialPhone = contactToEdit?.phoneNumber ?: "",
            isEdit = isEdit,
            onDismiss = { showAddDialog = false },
            onConfirm = { name, phone ->
                if (isEdit) {
                    contactToEdit?.let {
                        contactsManager.updateContact(it.id, name, phone)
                    }
                } else {
                    contactsManager.addContact(name, phone)
                }
                contacts = contactsManager.getContacts()
                showAddDialog = false
            }
        )
    }
}

@Composable
fun AddContactDialog(
    initialName: String = "",
    initialPhone: String = "",
    isEdit: Boolean = false,
    onDismiss: () -> Unit,
    onConfirm: (String, String) -> Unit
) {
    var name by remember { mutableStateOf(initialName) }
    var phone by remember { mutableStateOf(initialPhone) }

    Dialog(onDismissRequest = onDismiss) {
        Card(modifier = Modifier.padding(16.dp), elevation = 8.dp) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(if (isEdit) "Edit Emergency Contact" else "Add Emergency Contact", style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Phone Number") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                    TextButton(onClick = onDismiss) { Text("Cancel") }
                    Button(onClick = {
                        if (name.isNotBlank() && phone.isNotBlank()) {
                            onConfirm(name, phone)
                        }
                    }) { Text("Save") }
                }
            }
        }
    }
}
