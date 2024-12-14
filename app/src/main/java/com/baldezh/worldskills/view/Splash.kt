package com.baldezh.worldskills.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun Splash(navigateToMainScreen: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xff48B2E7),
                        Color(0xff0076B1),
                    ),
                )
            ), contentAlignment = Alignment.Center
    ) {
        Text(
            text = "MATULE Me",
            fontSize = 42.sp,
            color = Color.White
        )
    }
    LaunchedEffect(Unit) {
        delay(2000)
        navigateToMainScreen()
    }
}