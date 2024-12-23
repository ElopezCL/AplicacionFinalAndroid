package com.example.aplicacionfinal.presentation.features.movies

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import com.example.aplicacionfinal.domain.model.Movie
import com.example.aplicacionfinal.viewmodel.MoviesViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MoviesScreen(navController: NavController, viewModel: MoviesViewModel = viewModel()) {
    val state = viewModel.movies.collectAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Popular Movies", style = MaterialTheme.typography.headlineLarge)
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.value) { movie ->
                MovieItem(movie = movie, onClick = {
                    navController.navigate("movie_details/${movie.id}")
                })
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    Text(movie.title, modifier = Modifier
        .padding(16.dp)
        .clickable(onClick = onClick))
}
