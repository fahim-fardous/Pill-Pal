package com.example.pillpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pillpal.screens.reminder.list.ReminderListScreen
import com.example.pillpal.screens.reminder.list.ReminderListViewModel
import com.example.pillpal.ui.theme.PillPalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            PillPalTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PillPalTheme {
        val viewModel:ReminderListViewModel = hiltViewModel()
        ReminderListScreen(viewModel = viewModel, gotoAddReminder = {})
    }
}
