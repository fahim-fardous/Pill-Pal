package com.example.pillpal.db.converters

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun fromDateToString(date: Date): Long = date.time

    @TypeConverter
    fun stringToDate(value: Long): Date = Date(value)
}