package com.example.aplicacionfinal.data.remote.models

data class MovieDto(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String?,
    val release_date: String
)