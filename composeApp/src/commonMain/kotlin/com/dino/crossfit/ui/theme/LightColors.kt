package com.dino.crossfit.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    surfaceContainer = Color.White,
    background = Color.White,
    surface = Color.White,
)

// TODO: Add dark color scheme
private val DarkColors = LightColors

@Composable
fun DinoTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colors = when {
        darkTheme -> DarkColors
        else -> LightColors
    }
    MaterialTheme(
        colorScheme = colors,
        content = content,
    )
}
