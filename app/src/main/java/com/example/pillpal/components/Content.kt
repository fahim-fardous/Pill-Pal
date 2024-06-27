package com.example.pillpal.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun Content(data: CalendarUiModel) {
    LazyRow {
        items(
            data
                .visibleDates,
        ) { date ->
            CalendarItem(date)
        }
    }
}
