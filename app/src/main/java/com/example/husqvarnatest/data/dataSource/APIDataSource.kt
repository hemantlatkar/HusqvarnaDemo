package com.example.husqvarnatest.data.dataSource

import com.example.husqvarnatest.data.remote.moviedetails.MovieDetailsEntity
import com.example.husqvarnatest.data.remote.moviespopular.ListMoviesPopularEntity
import com.example.husqvarnatest.domain.models.Response
import kotlinx.coroutines.flow.Flow

interface APIDataSource {
    suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopularEntity>>

    suspend fun getMovieDetailsById(movieId: Int): Flow<Response<MovieDetailsEntity>>
}