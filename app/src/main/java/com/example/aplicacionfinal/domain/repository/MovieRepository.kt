package com.example.aplicacionfinal.domain.repository

import com.example.aplicacionfinal.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(apiKey: String, page: Int): List<Movie>
    suspend fun searchMovies(query: String, apiKey: String, page: Int): List<Movie>
    suspend fun saveMovie(movie: Movie)
    suspend fun getFavoriteMovies(): List<Movie>
    suspend fun deleteMovie(movieId: Int)
    suspend fun getMovieById(movieId: Int): Movie?
}
