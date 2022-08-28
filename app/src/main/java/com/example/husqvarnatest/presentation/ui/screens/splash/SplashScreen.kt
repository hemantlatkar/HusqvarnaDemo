package com.example.husqvarnatest.presentation.ui.screens.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.husqvarnatest.presentation.navigation.NavRoute
import kotlinx.coroutines.delay
import com.example.husqvarnatest.R

@Composable
fun SplashScreen(navController: NavController) {
    val animationTimeMillis = 1500L
    var stateAnimate by remember { mutableStateOf(false) }

    val alphaAnimation = animateFloatAsState(
        targetValue = if (stateAnimate) 1f else 0f,
        animationSpec = tween(durationMillis = animationTimeMillis.toInt())
    )

    LaunchedEffect(key1 = Unit) {
        stateAnimate = true
        delay(animationTimeMillis)
        navController.navigate(NavRoute.Main.route)
    }

    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.husqvarna_logo),
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha),
            contentDescription = null,
        )
    }
}