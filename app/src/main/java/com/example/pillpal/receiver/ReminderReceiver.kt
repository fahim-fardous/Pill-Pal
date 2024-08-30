package com.example.pillpal.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.pillpal.notification.ReminderNotification

class ReminderReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val scheduleNotificationService = context?.let {
            ReminderNotification(it)
        }
        val pillName = intent?.getStringExtra("pillName")
        if (pillName != null) {
            scheduleNotificationService?.sendReminderNotification(pillName)
        }
    }
}