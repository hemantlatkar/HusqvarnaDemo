package com.example.husqvarnatest.presentation.utils

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class DominantColors(val mainColor: Color, val firstColor: Color, val secondColor: Color, var validLuminance: Float)