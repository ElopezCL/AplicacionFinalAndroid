package com.example.aplicacionfinal.presentation.features.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aplicacionfinal.domain.model.Movie
import com.example.aplicacionfinal.presentation.ui.MovieItem
import androidx.compose.material3.CircularProgressIndicator
import com.example.aplicacionfinal.ui.MovieItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    query: String,
    onQueryChange: (String) -> Unit,
    searchResults: List<Movie>,
    onMovieClick: (Movie) -> Unit,
    isLoading: Boolean,
    errorMessage: String?
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Search Movies") },
                actions = {
                    IconButton(onClick = { onQueryChange("") }) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear Search")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

            TextField(
                value = query,
                onValueChange = onQueryChange,
                label = { Text("Search for a movie") },
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {

                    }
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            when {
                isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
                }
                errorMessage != null -> {
                    Text(text = errorMessage, color = Color.Red)
                }
                else -> {
                    LazyColumn {
                        items(searchResults) { movie ->
                            MovieItem(movie = movie, onClick = { onMovieClick(movie) })
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen() {
    val movie = Movie(
        id = 1,
        title = "Example Movie",
        overview = "An example of a movie description.",
        posterPath = "/example_path.jpg",
        releaseDate = "2024-01-01"
    )
    SearchScreen(
        query = "Movie",
        onQueryChange = {},
        searchResults = listOf(movie),
        onMovieClick = {},
        isLoading = false,
        errorMessage = null
    )
}
