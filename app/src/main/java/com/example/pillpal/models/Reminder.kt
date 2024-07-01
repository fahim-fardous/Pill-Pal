package com.example.pillpal.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminders")
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val pillName:String,
    val pillAmount:Int,
    val pillType:String,
    val interval:Int,
    val intervalType:String,
    val foodTiming:Int,
    val time:String,
)
