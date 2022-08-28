package com.example.husqvarnatest.domain.usecase

import com.example.husqvarnatest.domain.models.Response
import com.example.husqvarnatest.domain.models.moviedetails.MovieDetailsD
import com.example.husqvarnatest.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetMovieDetailsByIdUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute(movieId: Int): Flow<Response<MovieDetailsD>> =
        moviesRepository.getMovieDetailsById(movieId = movieId)
}