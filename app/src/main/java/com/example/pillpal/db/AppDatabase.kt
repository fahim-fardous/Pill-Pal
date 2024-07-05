package com.example.pillpal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pillpal.db.converters.DateConverter
import com.example.pillpal.db.dao.ReminderDao
import com.example.pillpal.models.Reminder

@Database(entities = [Reminder::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun reminderDao(): ReminderDao

    companion object {
        operator fun invoke(context: Context) = buildDatabase(context)

        private fun buildDatabase(context: Context): AppDatabase {
            val databaseBuilder =
                Room.databaseBuilder(context, AppDatabase::class.java, "PillReminder.db")
            return databaseBuilder.build()
        }
    }
}
