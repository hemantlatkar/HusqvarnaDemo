package com.example.husqvarnatest.data.dataSource

import com.example.husqvarnatest.data.remote.moviedetails.MovieDetailsEntity
import com.example.husqvarnatest.data.remote.moviespopular.ListMoviesPopularEntity
import com.example.husqvarnatest.data.dataSource.APIConstants.API_KEY_QUERY
import com.example.husqvarnatest.data.dataSource.APIConstants.MOVIES_BY_ID_URL
import com.example.husqvarnatest.data.dataSource.APIConstants.MOVIES_POPULAR_URL
import com.example.husqvarnatest.data.dataSource.APIConstants.MOVIE_ID_PATH
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIInterface {

    @GET(MOVIES_POPULAR_URL)
    fun getListPopularMovies(
        @Query(API_KEY_QUERY) key: String
    ): Call<ListMoviesPopularEntity>

    @GET(MOVIES_BY_ID_URL)
    fun getMovieDetailsById(
        @Path(MOVIE_ID_PATH) movieId: Int,
        @Query(API_KEY_QUERY) key: String
    ): Call<MovieDetailsEntity>
}