package com.example.aplicacionfinal.di

import android.content.Context
import androidx.room.Room
import com.example.aplicacionfinal.data.local.dao.MovieDao
import com.example.aplicacionfinal.data.local.datasource.LocalDataSource
import com.example.aplicacionfinal.data.local.entities.MovieEntity
import com.example.aplicacionfinal.data.local.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideMovieDatabase(appContext: Context): MovieDatabase {
        return Room.databaseBuilder(
            appContext,
            MovieDatabase::class.java,
            "movie_db"
        ).build()
    }

    @Provides
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDao()
    }

    @Provides
    fun provideLocalDataSource(movieDao: MovieDao): LocalDataSource {
        return LocalDataSource(movieDao)
    }
}
