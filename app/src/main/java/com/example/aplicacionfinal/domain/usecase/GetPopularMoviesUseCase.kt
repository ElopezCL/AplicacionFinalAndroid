package com.example.aplicacionfinal.domain.usecase

import com.example.aplicacionfinal.domain.model.Movie
import com.example.aplicacionfinal.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend fun execute(apiKey: String, page: Int): List<Movie> {
        return movieRepository.getPopularMovies(apiKey, page)
    }
}
