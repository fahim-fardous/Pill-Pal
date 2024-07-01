package com.example.pillpal.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun Header(data: CalendarUiModel) {
    Row {
        Text(
            text =
                if (data.selectedDate.isToday) {
                    "Today"
                } else {
                    data.selectedDate.date.format(
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL),
                    )
                },
            modifier =
                Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
            color = Color(0xFF1BD15D),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.ChevronLeft,
                contentDescription = " Previous",
                tint = Color(0xFF9B9B9B),
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.ChevronRight,
                contentDescription = " Next",
                tint = Color(0xFF9B9B9B),
            )
        }
    }
}
