package com.example.husqvarnatest.data.repository

import com.example.husqvarnatest.data.mappers.remote.moviedetails.MovieDetailsEntityMapper
import com.example.husqvarnatest.data.mappers.remote.moviespopular.ListMoviesPopularEntityMapper
import com.example.husqvarnatest.data.dataSource.APIDataSource
import com.example.husqvarnatest.domain.models.Response
import com.example.husqvarnatest.domain.models.moviedetails.MovieDetailsD
import com.example.husqvarnatest.domain.models.moviespopular.ListMoviesPopularD
import com.example.husqvarnatest.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

class MoviesRepositoryImpl(private val moviesStorage: APIDataSource) : MoviesRepository {

    override suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopularD>> =
        moviesStorage.getMoviesPopular().transform { response ->
            when (response) {
                is Response.Loading -> emit(Response.Loading())
                is Response.Fail -> emit(Response.Fail(e = response.e))
                is Response.Success -> emit(
                    Response.Success(
                        data = ListMoviesPopularEntityMapper().mapFromEntity(type = response.data)
                    )
                )
            }
        }

    override suspend fun getMovieDetailsById(movieId: Int): Flow<Response<MovieDetailsD>> =
        moviesStorage.getMovieDetailsById(movieId = movieId).transform { response ->
            when (response) {
                is Response.Loading -> emit(Response.Loading())
                is Response.Fail -> emit(Response.Fail(e = response.e))
                is Response.Success -> emit(
                    Response.Success(
                        data = MovieDetailsEntityMapper().mapFromEntity(type = response.data)
                    )
                )
            }
        }
}