package com.example.husqvarnatest.data.dataSource

import com.example.husqvarnatest.BuildConfig
import com.example.husqvarnatest.data.remote.moviedetails.MovieDetailsEntity
import com.example.husqvarnatest.data.remote.moviespopular.ListMoviesPopularEntity
import com.example.husqvarnatest.domain.models.Response
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback

class EndPointAPIDataSource(private val apiInterface: APIInterface) :
    APIDataSource {

    override suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopularEntity>> =
        callbackFlow {
            trySend(Response.Loading())

            apiInterface.getListPopularMovies(
                key = BuildConfig.API_KEY
            )
                .enqueue(object : Callback<ListMoviesPopularEntity> {

                    override fun onResponse(
                        call: Call<ListMoviesPopularEntity>,
                        response: retrofit2.Response<ListMoviesPopularEntity>
                    ) {
                        response.body().let {
                            it?.let { trySend(Response.Success(data = it)) }
                        }
                    }

                    override fun onFailure(call: Call<ListMoviesPopularEntity>, t: Throwable) {
                        trySend(Response.Fail(e = t as Exception))
                    }
                })

            awaitClose { this.cancel() }
        }

    override suspend fun getMovieDetailsById(movieId: Int): Flow<Response<MovieDetailsEntity>> =
        callbackFlow {
            trySend(Response.Loading())

            apiInterface.getMovieDetailsById(
                movieId = movieId,
                key = BuildConfig.API_KEY
            )
                .enqueue(object : Callback<MovieDetailsEntity> {
                override fun onResponse(
                    call: Call<MovieDetailsEntity>,
                    response: retrofit2.Response<MovieDetailsEntity>
                ) {
                    response.body().let {
                        it?.let { trySend(Response.Success(data = it)) }
                    }
                }

                override fun onFailure(call: Call<MovieDetailsEntity>, t: Throwable) {
                    trySend(Response.Fail(e = t as Exception))
                }
            })

            awaitClose { this.cancel() }
        }
}