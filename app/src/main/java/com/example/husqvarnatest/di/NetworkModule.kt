package com.example.husqvarnatest.di

import com.example.husqvarnatest.data.repository.MoviesRepositoryImpl
import com.example.husqvarnatest.data.dataSource.APIDataSource
import com.example.husqvarnatest.data.dataSource.APIInterface
import com.example.husqvarnatest.data.dataSource.EndPointAPIDataSource
import com.example.husqvarnatest.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesMoviesStorage(apiInterface: APIInterface): APIDataSource =
        EndPointAPIDataSource(apiInterface = apiInterface)

    @Provides
    @Singleton
    fun providesMoviesRepository(moviesStorage: APIDataSource): MoviesRepository =
        MoviesRepositoryImpl(moviesStorage = moviesStorage)
}