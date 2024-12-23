package com.example.aplicacionfinal.presentation.features.movies

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import coil.compose.rememberImagePainter
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aplicacionfinal.domain.model.Movie
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(movie: Movie, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(movie.title) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { paddingValues ->
            val scrollState = rememberScrollState()

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(scrollState)
            ) {
                Image(
                    painter = rememberImagePainter("https://image.tmdb.org/t/p/w500${movie.posterPath}"),
                    contentDescription = movie.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("Release Date: ${movie.releaseDate}", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(movie.overview, style = MaterialTheme.typography.bodyLarge)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieDetailScreen() {

    val movie = Movie(
        id = 1,
        title = "Movie Title",
        overview = "This is a detailed description of the movie.",
        posterPath = "/path_to_image.jpg",
        releaseDate = "2024-01-01"
    )

    MovieDetailScreen(movie = movie, onBackClick = { })
}
