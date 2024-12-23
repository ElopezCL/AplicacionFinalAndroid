package com.example.aplicacionfinal.domain.usecase

import com.example.aplicacionfinal.domain.model.Movie
import com.example.aplicacionfinal.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend fun execute(movieId: Int): Movie? {
        return movieRepository.getMovieById(movieId)
    }
}
