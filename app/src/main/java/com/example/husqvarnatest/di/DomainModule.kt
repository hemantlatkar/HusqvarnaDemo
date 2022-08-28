package com.example.husqvarnatest.di

import com.example.husqvarnatest.domain.repository.MoviesRepository
import com.example.husqvarnatest.domain.usecase.GetListMoviesPopularUseCase
import com.example.husqvarnatest.domain.usecase.GetMovieDetailsByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun providesGetListMoviesPopularUseCase(moviesRepository: MoviesRepository): GetListMoviesPopularUseCase =
        GetListMoviesPopularUseCase(moviesRepository = moviesRepository)

    @Provides
    @Singleton
    fun providesGetMovieDetailsByIdUseCase(moviesRepository: MoviesRepository): GetMovieDetailsByIdUseCase =
        GetMovieDetailsByIdUseCase(moviesRepository = moviesRepository)

}