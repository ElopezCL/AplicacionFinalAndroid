package com.example.aplicacionfinal.data.remote.api

import com.example.aplicacionfinal.data.remote.models.MovieDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): MovieResponse

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): MovieResponse
}

data class MovieResponse(
    val results: List<MovieDto>,
    val total_pages: Int,
    val page: Int
)
