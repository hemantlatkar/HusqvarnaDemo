package com.example.husqvarnatest.presentation.navigation

import com.example.husqvarnatest.presentation.utils.ScreensConstants

sealed class NavRoute(val route: String) {

    object Splash : NavRoute(route = ScreensConstants.Screens.SPLASH_SCREEN)
    object Main : NavRoute(route = ScreensConstants.Screens.MAIN_SCREEN)
    object DetailsMovie : NavRoute(route = ScreensConstants.Screens.DETAILS_MOVIE_SCREEN)
}