package com.example.pillpal.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pillpal.R

@Composable
fun MealTimeCard(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    icon: Int,
    selectedColor: Color,
    unSelectedColor: Color,
    onClick: () -> Unit = {},
) {
    Box(
        modifier =
            modifier
                .size(width = 96.dp, height = 90.dp)
                .clickable {
                    onClick()
                }.background(
                    color = if (isSelected) selectedColor else Color(0xFFEEEEEC),
                    shape = RoundedCornerShape(8.dp),
                ),
        contentAlignment = Alignment.Center,
    ) {
        if (isSelected) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "selected icon",
                tint = Color.White,
                modifier = Modifier.size(width = 57.dp, height = 48.dp),
            )
        } else {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "unselected icon",
                tint = Color(0xFF9B9B9B),
                modifier = Modifier.size(width = 57.dp, height = 48.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FoodCardPreview() {
    MealTimeCard(
        icon = R.drawable.after_food,
        selectedColor = Color.Black,
        unSelectedColor = Color.Gray,
    )
}
