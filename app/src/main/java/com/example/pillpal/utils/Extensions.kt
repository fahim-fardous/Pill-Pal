package com.example.pillpal.utils

import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.util.Date

object Extensions {
    fun getDaysOfMonth(interval: Int): Int {
        val startDate = LocalDate.now()
        val endDate = startDate.plusMonths(interval.toLong())
        return ChronoUnit.DAYS.between(startDate, endDate).toInt()
    }

    fun getEndDate(interval: Int): Date {
        val startDate = LocalDate.now()
        val endDate = startDate.plusMonths(interval.toLong())
        return Date.from(endDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
    }
}
