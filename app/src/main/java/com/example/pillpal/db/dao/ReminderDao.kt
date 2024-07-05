package com.example.pillpal.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pillpal.models.Reminder
import java.util.Date

@Dao
interface ReminderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminder: Reminder):Long

    @Query("SELECT * FROM reminders")
    suspend fun getAllReminders(): List<Reminder>

    // Get current day's reminders
    @Query("SELECT * FROM reminders WHERE startDate<:currentDay LIMIT 1")
    suspend fun getTodayReminders(currentDay: Date):List<Reminder>


}