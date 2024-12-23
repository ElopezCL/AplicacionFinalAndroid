package com.example.aplicacionfinal.data.remote.datasource

import com.example.aplicacionfinal.data.remote.api.MovieApi
import com.example.aplicacionfinal.data.remote.models.MovieDto
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val movieApi: MovieApi) {

    suspend fun getPopularMovies(apiKey: String, page: Int): List<MovieDto> {
        return movieApi.getPopularMovies(apiKey, page).results
    }

    suspend fun searchMovies(query: String, apiKey: String, page: Int): List<MovieDto> {
        return movieApi.searchMovies(query, apiKey, page).results
    }
}
