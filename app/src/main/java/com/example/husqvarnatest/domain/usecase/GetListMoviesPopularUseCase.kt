package com.example.husqvarnatest.domain.usecase

import com.example.husqvarnatest.domain.models.Response
import com.example.husqvarnatest.domain.models.moviespopular.ListMoviesPopularD
import com.example.husqvarnatest.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetListMoviesPopularUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute(): Flow<Response<ListMoviesPopularD>> =
        moviesRepository.getMoviesPopular()
}