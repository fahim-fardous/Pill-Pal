package com.example.pillpal.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pillpal.R
import com.example.pillpal.ui.theme.PillPalTheme

@Composable
fun PlanCard(userName:String, completedPill:Int, totalPill:Int) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(top = 8.dp, start = 32.dp)) {
            Text(
                text = "Hello,",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            Text(text = "Fahim", fontSize = 24.sp)
        }
        Card(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp, start = 32.dp, end = 32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F6C8)),
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(text = "Your plan", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "for today", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "1 of 4 completed", fontSize = 10.sp, color = Color(0xFFA1A2A1))
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Show More",
                    textDecoration = TextDecoration.Underline,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFEC7669),
                )
            }
        }
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
            Image(
                painter = painterResource(id = R.drawable.character),
                contentDescription = null,
                modifier = Modifier.size(210.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PlanCardPreview() {
    PillPalTheme {
        PlanCard(
            userName = "Fahim",
            completedPill = 2,
            totalPill = 4,
        )
    }
}
