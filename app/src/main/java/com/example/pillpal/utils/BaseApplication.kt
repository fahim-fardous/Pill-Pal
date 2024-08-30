package com.example.pillpal.utils

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val notificationChannel =
            NotificationChannel(
                "NOTIFICATION_CHANNEL_ID",
                "REMINDER_NOTIFICATION",
                NotificationManager.IMPORTANCE_HIGH,
            )

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }
}
