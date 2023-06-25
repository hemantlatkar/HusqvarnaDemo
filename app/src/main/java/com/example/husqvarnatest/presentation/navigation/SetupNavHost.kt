package com.example.husqvarnatest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.husqvarnatest.presentation.ui.screens.detailsmovie.DetailsMovieScreen
import com.example.husqvarnatest.presentation.ui.screens.main.MainScreen
import com.example.husqvarnatest.presentation.ui.screens.splash.SplashScreen
import com.example.husqvarnatest.presentation.utils.ScreensConstants
import com.example.husqvarnatest.presentation.utils.StringsConstants.EMPTY_STRING

@Composable
fun SetupNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash.route
    ) {
        composable(route = NavRoute.Splash.route) {
            SplashScreen(
                navController = navController
            )
        }
        composable(route = NavRoute.Main.route) {
            MainScreen(
                navController = navController
            )
        }
        composable(route = NavRoute.DetailsMovie.route + "/{${ScreensConstants.Args.MOVIE_ID_ARG}}") { backStackEntry ->
            DetailsMovieScreen(
                navController = navController,
                movieId = backStackEntry.arguments?.getString(ScreensConstants.Args.MOVIE_ID_ARG) ?: EMPTY_STRING)
        }
    }
}