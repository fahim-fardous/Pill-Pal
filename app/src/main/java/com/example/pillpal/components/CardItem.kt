package com.example.pillpal.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pillpal.R
import com.example.pillpal.ui.theme.PillPalTheme

@Composable
fun CardItem() {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(Color(0xFFF7F7F5), shape = RoundedCornerShape(16.dp))
                .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.pill),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 8.dp).size(28.dp),
        )
        Column {
            Text(text = "Pill Name", fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = "10:00 AM", fontSize = 10.sp, modifier = Modifier.padding(end = 2.dp))
                Box(
                    modifier =
                        Modifier
                            .size(2.dp)
                            .background(color = Color(0xFF9A9A9A), shape = CircleShape),
                )
                Text(
                    text = "Completed",
                    fontSize = 10.sp,
                    modifier = Modifier.padding(start = 2.dp),
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(painter = painterResource(id = R.drawable.arrowright), contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
private fun CardItemPreview() {
    PillPalTheme {
        Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
            CardItem()
        }
    }
}
