package com.example.husqvarnatest.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

private val DarkColorPalette = darkColors(
    primary = Red500,
    primaryVariant = Blue700,
    secondary = Teal200,
    background = Blue700
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Blue700,
    secondary = Teal200,
    background = White

)

@Composable
fun TestTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}


val TestTheme
    @Composable get() = MaterialTheme