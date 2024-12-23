package com.example.aplicacionfinal.data.local.entities

import com.example.aplicacionfinal.domain.model.Movie

fun MovieEntity.toMovie(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        overview = this.overview,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate
    )
}
