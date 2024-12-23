package com.example.aplicacionfinal.domain.usecase

import com.example.aplicacionfinal.domain.model.Movie
import com.example.aplicacionfinal.domain.repository.MovieRepository
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend fun execute(query: String, apiKey: String, page: Int): List<Movie> {
        return movieRepository.searchMovies(query, apiKey, page)
    }
}
