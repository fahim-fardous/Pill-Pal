package com.example.pillpal.notification

import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.pillpal.R
import com.example.pillpal.models.Reminder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ReminderNotification(private val context: Context) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)
    private val NOTIFICATION_ID = 1

    fun sendReminderNotification(pillName: String) {
        val notification = NotificationCompat.Builder(context, "NOTIFICATION_CHANNEL_ID")
            .setContentTitle("Reminder")
            .setContentText("It's time to take your $pillName")
            .setSmallIcon(R.drawable.logo_no_bg)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(NOTIFICATION_ID, notification)
    }
}