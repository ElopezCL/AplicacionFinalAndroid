package com.example.aplicacionfinal.data.repository

import com.example.aplicacionfinal.data.local.datasource.LocalDataSource
import com.example.aplicacionfinal.data.remote.datasource.RemoteDataSource
import com.example.aplicacionfinal.domain.model.Movie
import com.example.aplicacionfinal.domain.repository.MovieRepository
import com.example.aplicacionfinal.data.local.entities.MovieEntity
import com.example.aplicacionfinal.data.local.entities.toMovie
import com.example.aplicacionfinal.data.remote.models.MovieDto
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MovieRepository {

    override suspend fun getPopularMovies(apiKey: String, page: Int): List<Movie> {
        val moviesDto = remoteDataSource.getPopularMovies(apiKey, page)
        return moviesDto.map { it.toMovie() }
    }

    override suspend fun searchMovies(query: String, apiKey: String, page: Int): List<Movie> {
        val moviesDto = remoteDataSource.searchMovies(query, apiKey, page)
        return moviesDto.map { it.toMovie() }
    }

    override suspend fun saveMovie(movie: Movie) {
        localDataSource.saveMovie(movie.toMovieEntity())
    }

    override suspend fun getFavoriteMovies(): List<Movie> {
        val favoriteMovies = localDataSource.getAllMovies()
        return favoriteMovies.map { it.toMovie() }
    }


    override suspend fun getMovieById(movieId: Int): Movie? {

        val movieEntity = localDataSource.getMovieById(movieId)


        return movieEntity?.toMovie()
    }

    override suspend fun deleteMovie(movieId: Int) {
        localDataSource.deleteMovieById(movieId)
    }
}

fun MovieDto.toMovie(): Movie {
    return Movie(id, title, overview, poster_path, release_date)
}

fun Movie.toMovieEntity(): MovieEntity {
    return MovieEntity(id, title, overview, posterPath, releaseDate)
}
