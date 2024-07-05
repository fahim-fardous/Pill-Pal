package com.example.pillpal.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pillpal.R
import com.example.pillpal.SplashScreen
import com.example.pillpal.ui.theme.appColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(gotoListScreen: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000)
        gotoListScreen()
    }
    Box(
        modifier =
        Modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_no_bg),
            contentDescription = null,
            modifier = Modifier.size(280.dp),
        )
        Text(
            modifier = Modifier.padding(top = 164.dp),
            text = "Pill Pal",
            style =
            MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.Bold,
                brush =
                Brush.linearGradient(
                    colors =
                    listOf(
                        appColor,
                        Color(0xFFEE6EC6),
                    ),
                ),
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen(gotoListScreen = {})
}
