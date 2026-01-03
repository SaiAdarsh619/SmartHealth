package com.example.healthconnect.codelab.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.UUID

class EmergencyContactsManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("emergency_contacts", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun getContacts(): List<EmergencyContact> {
        val json = prefs.getString("contacts", null) ?: return emptyList()
        val type = object : TypeToken<List<EmergencyContact>>() {}.type
        return gson.fromJson(json, type)
    }

    fun addContact(name: String, phoneNumber: String) {
        val currentList = getContacts().toMutableList()
        currentList.add(EmergencyContact(UUID.randomUUID().toString(), name, phoneNumber))
        saveContacts(currentList)
    }

    fun removeContact(id: String) {
        val currentList = getContacts().toMutableList()
        currentList.removeAll { it.id == id }
        saveContacts(currentList)
    }

    fun updateContact(id: String, name: String, phoneNumber: String) {
        val currentList = getContacts().toMutableList()
        val index = currentList.indexOfFirst { it.id == id }
        if (index != -1) {
            currentList[index] = currentList[index].copy(name = name, phoneNumber = phoneNumber)
            saveContacts(currentList)
        }
    }

    private fun saveContacts(list: List<EmergencyContact>) {
        prefs.edit().putString("contacts", gson.toJson(list)).apply()
    }
}
