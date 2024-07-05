package com.example.pillpal.screens.reminder.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pillpal.ui.theme.PillPalTheme

@Composable
fun ReminderEditScreen(modifier: Modifier = Modifier) {
    PillPalTheme {
        ReminderEditScreenSkeleton()
    }
}

@Preview(showBackground = true)
@Composable
private fun ReminderEditScreenPreview() {
    PillPalTheme {
        ReminderEditScreenSkeleton()
    }
}

@Composable
fun ReminderEditScreenSkeleton() {
    Scaffold(topBar = {
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp)) {
            }
        }
    }
}
