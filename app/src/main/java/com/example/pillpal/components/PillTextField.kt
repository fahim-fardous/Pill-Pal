package com.example.pillpal.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pillpal.R
import com.example.pillpal.ui.theme.PillPalTheme

@Composable
fun PillTextField(
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var name by remember {
        mutableStateOf("")
    }
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFEEEEEC), shape = RoundedCornerShape(8.dp))
                .padding(16.dp),
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.pill),
                contentDescription = "pill image",
                tint =
                    Color(
                        0xFF9A9A9A,
                    ),
            )

            BasicTextField(
                value = name,
                onValueChange = {
                    name = it
                    onValueChange(it)
                },
                modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
                singleLine = true,
                textStyle =
                    TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                    ),
                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically)) {
                        if (name.isEmpty()) {
                            Text(
                                text = "Ex. : Napa Extra",
                                color = Color(0xFF9A9A9A),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                            )
                        }
                        innerTextField()
                    }
                },
            )
        }
    }
}

fun onValueChange(str: String) {
    println(str)
}

@Preview
@Composable
private fun PillTextFieldPreview() {
    PillPalTheme {
        PillTextField(onValueChange = {}, modifier = Modifier)
    }
}
