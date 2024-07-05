package com.example.pillpal.screens.reminder.list

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pillpal.components.CardItem
import com.example.pillpal.components.PlanCard
import com.example.pillpal.components.Search
import com.example.pillpal.models.Reminder
import com.example.pillpal.ui.theme.PillPalTheme
import com.example.pillpal.ui.theme.appColor
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun ReminderListScreen(
    viewModel: ReminderListViewModel,
    gotoAddReminder: () -> Unit,
) {
    val reminders by viewModel.reminders.collectAsState()
    LaunchedEffect(reminders) {
        viewModel.getReminders()
    }
    ReminderListScreenSkeleton(
        reminders = reminders,
        gotoAddReminder = gotoAddReminder,
        getReminders = { viewModel.getReminders() },
    )
}

@Preview(showBackground = true)
@Composable
private fun ReminderListScreenSkeletonPreview() {
    PillPalTheme {
        ReminderListScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ReminderListScreenPreviewDark() {
    PillPalTheme {
        ReminderListScreenSkeleton()
    }
}

@Composable
fun ReminderListScreenSkeleton(
    reminders: List<Reminder> = emptyList(),
    gotoAddReminder: () -> Unit = {},
    getReminders: () -> Unit = {},
) {
    LaunchedEffect(Unit) {
        getReminders()
    }
    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    gotoAddReminder()
                },
                containerColor = appColor
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Go to add",
                    tint = Color.White
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(top = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Search(
                query = "",
                onQueryChange = {},
                onSearch = {},
                active = false,
                onActiveChange = {},
                placeholder = { Text(text = "Search") },
                leadingIcon = {
                    Icon(Icons.Filled.Search, contentDescription = "search")
                },
            ) {}
            Spacer(modifier = Modifier.height(32.dp))
            PlanCard(
                userName = "Fahim",
                completedPill = 2,
                totalPill = reminders.size,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
            ) {
                Text(
                    text = "Daily Review",
                    modifier = Modifier.padding(top = 16.dp, start = 32.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )

                LazyColumn(
                    modifier = Modifier.height(400.dp),
                    contentPadding = PaddingValues(top = 16.dp, start = 32.dp, end = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(reminders) { reminder ->
                        CardItem(
                            pillName = reminder.pillName,
                            time = reminder.time,
                            status = if (reminder.status != "Completed") getCurrentTime(reminder.time) else "Completed",
                        )
                    }
                }
            }
        }
    }
}


fun getCurrentTime(reminderTime: String): String {
    val formatter = DateTimeFormatter.ofPattern("hh:mm a")
    val setTime = LocalTime.parse(reminderTime, formatter)
    val currentTime = LocalTime.parse(LocalTime.now().format(formatter),formatter)
    if(currentTime.isBefore(setTime)){
        return "Pending"
    }
    return "Skipped"

}
