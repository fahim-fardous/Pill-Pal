package com.example.pillpal.screens.pill.add

import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pillpal.R
import com.example.pillpal.components.DropDownField
import com.example.pillpal.components.MealTimeCard
import com.example.pillpal.components.PillTextField
import com.example.pillpal.components.TimePickerDialog
import com.example.pillpal.ui.theme.PillPalTheme
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun PillAddScreen() {
    PillAddScreenSkeleton()
}

@Preview
@Composable
private fun PillAddScreenSkeletonPreview() {
    PillPalTheme {
        PillAddScreenSkeleton()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PillAddScreenSkeleton() {
    var selectedTime by remember {
        mutableStateOf(-1)
    }
    var time by remember {
        mutableStateOf("")
    }

    var pillAmount by remember {
        mutableStateOf("")
    }

    var pillType by remember {
        mutableStateOf("")
    }

    var interval by remember {
        mutableStateOf("")
    }

    var intervalType by remember {
        mutableStateOf("")
    }

    var pillName by remember {
        mutableStateOf("")
    }

    var showTimePickerDialog by remember {
        mutableStateOf(false)
    }
    Scaffold { innerPadding ->
        Column(
            modifier =
                Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(horizontal = 32.dp, vertical = 48.dp),
        ) {
            Box(
                modifier =
                    Modifier
                        .size(40.dp)
                        .background(
                            color = Color(0xFFEEEEEC),
                            shape = RoundedCornerShape(16.dp),
                        ),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "go back",
                    tint =
                        Color(
                            0xFF9A9A9A,
                        ),
                )
            }
            Text(
                text = "Add Plan",
                modifier = Modifier.padding(top = 32.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Pills name",
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
            )

            PillTextField(
                onValueChange = {
                    pillName = it
                },
            )
            Text(
                text = "Amount & How long?",
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                DropDownField(
                    onValueChange = { pillAmount = it },
                    onTypeChange = { pillType = it },
                    icon = R.drawable.calendar_fill,
                    modifier =
                        Modifier
                            .weight(1f),
                    typeList = listOf("Pills", "ml", "tbsp"),
                )
                Spacer(modifier = Modifier.width(8.dp))
                DropDownField(
                    onValueChange = { interval = it },
                    onTypeChange = { intervalType = it },
                    icon = R.drawable.calendar_fill_2,
                    modifier =
                        Modifier
                            .weight(1f),
                    typeList = listOf("Day", "Week", "Month"),
                )
            }
            Text(
                text = "Food & Pills",
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                MealTimeCard(
                    modifier = Modifier.weight(1f),
                    isSelected = selectedTime == 0,
                    icon = R.drawable.before_food,
                    selectedColor = Color(0xFF1BD15D),
                    unSelectedColor = Color(0xFFF8F8F6),
                    onClick = {
                        selectedTime = 0
                    },
                )
                MealTimeCard(
                    modifier = Modifier.weight(1f),
                    isSelected = selectedTime == 1,
                    icon = R.drawable.middle_of_food,
                    selectedColor = Color(0xFF1BD15D),
                    unSelectedColor = Color(0xFFF8F8F6),
                    onClick = {
                        selectedTime = 1
                    },
                )
                MealTimeCard(
                    modifier = Modifier.weight(1f),
                    isSelected = selectedTime == 2,
                    icon = R.drawable.after_food,
                    selectedColor = Color(0xFF1BD15D),
                    unSelectedColor = Color(0xFFF8F8F6),
                    onClick = {
                        selectedTime = 2
                    },
                )
            }
            Text(
                text = "Notification",
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier =
                        Modifier
                            .background(color = Color(0xFFEEEEEC), shape = RoundedCornerShape(8.dp))
                            .padding(16.dp)
                            .weight(1f),
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.notification),
                            contentDescription = "pill image",
                            tint =
                                Color(
                                    0xFF9A9A9A,
                                ),
                        )

                        Text(text = time, modifier = Modifier.padding(horizontal = 16.dp))
                    }
                }
                Box(
                    modifier =
                        Modifier
                            .background(color = Color(0xFFEEFBF3), shape = RoundedCornerShape(16.dp))
                            .padding(16.dp)
                            .clickable {
                                showTimePickerDialog = true
                            },
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "add", tint = Color(0xFF1BD15D))
                }
            }
            Spacer(modifier = Modifier.height(80.dp))

            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp)
                        .background(color = Color(0xFF1BD15D), shape = RoundedCornerShape(16.dp))
                        .padding(16.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Done",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }

    // -----------------------------------------------------------------------------------
    // Dialog
    // -----------------------------------------------------------------------------------

    if (showTimePickerDialog) {
        val calendar = Calendar.getInstance()
        val timePickerState =
            rememberTimePickerState(
                initialHour = calendar.get(Calendar.HOUR_OF_DAY),
                initialMinute = calendar.get(Calendar.MINUTE),
                is24Hour = false,
            )
        TimePickerDialog(
            onDismissRequest = {
                showTimePickerDialog = false
            },
            confirmButton = {
                TextButton(onClick = {
                    val hour = timePickerState.hour
                    val minute = timePickerState.minute
                    time = convert24HourTo12Hour("$hour:$minute")
                    showTimePickerDialog = false
                }) {
                    Text(text = "Ok")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showTimePickerDialog = false
                }) {
                    Text(text = "Cancel")
                }
            },
        ) {
            TimePicker(state = timePickerState)
        }
    }
}

fun convert24HourTo12Hour(time24: String): String {
    // Define the input and output date formats
    val inputFormat = SimpleDateFormat("HH:mm")
    val outputFormat = SimpleDateFormat("hh:mm a")

    // Parse the input time string to a Date object
    val date: Date? = inputFormat.parse(time24)

    // Format the Date object to the desired output format
    return outputFormat.format(date)
}