package com.example.pillpal.notification

import android.app.AlarmManager
import android.content.Context
import java.time.LocalDate
import java.util.Calendar
import java.util.Date
import kotlin.time.Duration.Companion.hours

class ScheduleNotification {
    fun scheduleNotification(
        context: Context,
        scheduleTime:Date
    ){
        val intent = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val selectedDate = Calendar.getInstance().apply {
            timeInMillis = Date().time
        }
        val year = selectedDate.get(Calendar.YEAR)
        val month = selectedDate.get(Calendar.MONTH)
        val day = selectedDate.get(Calendar.DAY_OF_MONTH)

        val calendar = Calendar.getInstance()
        calendar.set(year,month,day, scheduleTime.hours, scheduleTime.minutes)

    }
}