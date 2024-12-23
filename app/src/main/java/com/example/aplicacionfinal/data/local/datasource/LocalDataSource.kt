package com.example.aplicacionfinal.data.local.datasource

import com.example.aplicacionfinal.data.local.dao.MovieDao
import com.example.aplicacionfinal.data.local.entities.MovieEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    suspend fun saveMovie(movie: MovieEntity) {
        movieDao.insertMovie(movie)
    }

    suspend fun getMovieById(movieId: Int): MovieEntity? {
        return movieDao.getMovieById(movieId)
    }

    suspend fun getAllMovies(): List<MovieEntity> {
        return movieDao.getAllMovies()
    }

    suspend fun deleteMovieById(movieId: Int) {
        movieDao.deleteMovieById(movieId)
    }
}
