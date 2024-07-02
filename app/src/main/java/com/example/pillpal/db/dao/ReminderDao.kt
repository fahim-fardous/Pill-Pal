package com.example.pillpal.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pillpal.models.Reminder

@Dao
interface ReminderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminder: Reminder):Long

    @Query("SELECT * FROM reminders")
    suspend fun getAllReminders(): List<Reminder>


}