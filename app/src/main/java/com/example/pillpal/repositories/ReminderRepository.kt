package com.example.pillpal.repositories

import com.example.pillpal.db.AppDatabase
import com.example.pillpal.models.Reminder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReminderRepository @Inject constructor(private val db:AppDatabase) {
    suspend fun insertReminder(reminder: Reminder) = withContext(Dispatchers.IO) {
        db.reminderDao().insertReminder(reminder)
    }

    suspend fun getAllReminders() = withContext(Dispatchers.IO) {
        db.reminderDao().getAllReminders()
    }

}