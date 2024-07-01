package com.example.pillpal.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pillpal.R

@Composable
fun DropDownField(
    onValueChange: (String) -> Unit,
    onTypeChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.pill,
    typeList: List<String>,
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    var amount by remember {
        mutableStateOf("")
    }

    var type by remember {
        mutableStateOf("")
    }
    Box(
        modifier =
            modifier
                .background(color = Color(0xFFEEEEEC), shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "leading icon",
                modifier = Modifier.size(28.dp).padding(start = 8.dp),
            )
            BasicTextField(
                value = amount,
                onValueChange = {
                    amount = it
                    onValueChange(it)
                },
                modifier =
                    Modifier
                        .width(42.dp)
                        .padding(start = 8.dp),
                textStyle =

                    TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                    ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                decorationBox = { innerTextField ->

                    if (amount.isEmpty()) {
                        Text(
                            text = "0",
                            color = Color(0xFF9A9A9A),
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                        )
                    }
                    innerTextField()
                },
            )
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                BasicTextField(
                    value = type,
                    onValueChange = {
                        type = it
                        onTypeChange(it)
                    },
                    modifier = Modifier.weight(1f),
                    readOnly = true,
                    textStyle =
                        TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                        ),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        if (type.isEmpty()) {
                            if (typeList.first() == "Pills") {
                                Text(
                                    text = "Pills",
                                    color = Color(0xFF9A9A9A),
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                )
                            } else {
                                Text(
                                    text = "Day",
                                    color = Color(0xFF9A9A9A),
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                )
                            }

                            innerTextField()
                        }
                    },
                )
                Icon(
                    Icons.Filled.ArrowDropDown,
                    contentDescription = "expand",
                    modifier =
                        Modifier
                            .clickable {
                                expanded = !expanded
                            },
                )
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = !expanded }) {
                typeList.forEach {
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = it,
                                style =
                                    TextStyle(
                                        color = Color.Black,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 14.sp,
                                    ),
                            )
                        },
                        onClick = {
                            type = it
                            onTypeChange(it)
                            expanded = !expanded
                        },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DropdownFieldPreview() {
    Row(
        modifier =
            Modifier
                .padding(16.dp)
                .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        DropDownField(
            icon = R.drawable.calendar_fill,
            modifier = Modifier.weight(1f),
            onValueChange = { },
            onTypeChange = { },
            typeList = listOf("Pills", "ml", "tbsp"),
        )
        DropDownField(
            icon = R.drawable.calendar_fill_2,
            modifier = Modifier.weight(1f),
            onValueChange = { },
            onTypeChange = { },
            typeList = listOf("Day", "Week", "Month"),
        )
    }
}
