package com.example.pillpal.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
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
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
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
                value = value,
                onValueChange = { onValueChange("Fahim") },
                modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
                singleLine = true,
                textStyle =
                    TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                    ),
            )
        }
    }
}

fun onValueChange(str:String):Unit{
    println(str)
}

@Preview
@Composable
private fun PillTextFieldPreview() {
    PillPalTheme {
        PillTextField(value = "", onValueChange = {}, modifier = Modifier)
    }
}
