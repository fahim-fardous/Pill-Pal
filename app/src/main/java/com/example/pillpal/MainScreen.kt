package com.example.pillpal

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Surface {
        MainNavHost(
            navController = navController
        )
    }
}
