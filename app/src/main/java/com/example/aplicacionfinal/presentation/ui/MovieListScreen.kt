package com.example.aplicacionfinal.presentation.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplicacionfinal.domain.model.Movie
import com.example.aplicacionfinal.viewmodel.MoviesViewModel

@Composable
fun MovieListScreen(viewModel: MoviesViewModel = viewModel()) {
    val movies by viewModel.movies.collectAsState(initial = emptyList())
    val isLoading by viewModel.isLoading.collectAsState(initial = false)
    val error by viewModel.error.collectAsState(initial = "")

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (error.isNotEmpty()) {
            Text(text = "Error: $error", color = MaterialTheme.colorScheme.error)
        }

        // Título de la pantalla
        Text(
            text = "Películas Populares",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(movies) { movie ->
                MovieItem(movie)
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),

    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieListScreen(viewModel = viewModel())
}
