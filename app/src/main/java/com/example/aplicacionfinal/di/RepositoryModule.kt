package com.example.aplicacionfinal.di

import com.example.aplicacionfinal.data.repository.MovieRepositoryImpl
import com.example.aplicacionfinal.domain.repository.MovieRepository
import com.example.aplicacionfinal.data.remote.datasource.RemoteDataSource
import com.example.aplicacionfinal.data.local.datasource.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMovieRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(remoteDataSource, localDataSource)
    }
}
