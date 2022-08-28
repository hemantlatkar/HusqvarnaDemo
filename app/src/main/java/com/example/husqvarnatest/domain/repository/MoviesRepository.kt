package com.example.husqvarnatest.domain.repository

import com.example.husqvarnatest.domain.models.Response
import com.example.husqvarnatest.domain.models.moviedetails.MovieDetailsD
import com.example.husqvarnatest.domain.models.moviespopular.ListMoviesPopularD
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopularD>>

    suspend fun getMovieDetailsById(movieId: Int): Flow<Response<MovieDetailsD>>
}