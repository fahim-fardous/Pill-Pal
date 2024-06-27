package com.example.pillpal.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pillpal.ui.theme.PillPalTheme
import java.time.LocalDate

@Composable
fun CalendarItem(date: CalendarUiModel.Date) {
    Card(
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
    ) {
        Column(
            modifier =
            Modifier
                .size(width = 40.dp, height = 48.dp)
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = date.day, style = MaterialTheme.typography.bodySmall)
            Text(text = date.date.dayOfMonth.toString(), style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview
@Composable
private fun CalendarItemPreview() {
    PillPalTheme {
        CalendarItem(CalendarUiModel.Date(LocalDate.now(), isSelected = true, isToday = true))
    }
}
