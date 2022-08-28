package com.example.husqvarnatest.presentation.ui.screens.detailsmovie

import com.example.husqvarnatest.domain.models.moviedetails.MovieDetailsD

/**
 * The state data class for Movie Screen.
 */
data class MovieState(
    val isLoading: Boolean = false,
    val movieDetails: MovieDetailsD? = null,
    val error: String = ""
)