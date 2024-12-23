package com.example.aplicacionfinal.domain.usecase

import com.example.aplicacionfinal.domain.model.Movie
import com.example.aplicacionfinal.domain.repository.MovieRepository
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend fun execute(movie: Movie) {
        if (movieRepository.getFavoriteMovies().contains(movie)) {
            movieRepository.deleteMovie(movie.id)
        } else {
            movieRepository.saveMovie(movie)
        }
    }
}
