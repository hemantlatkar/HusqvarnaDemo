package com.example.husqvarnatest.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple700,
    primaryVariant = Blue700,
    secondary = Teal200,
    background = White
)

private val LightColorPalette = lightColors(
    primary = Purple700,
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