package com.example.aplicacionfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.aplicacionfinal.presentation.features.search.SearchScreen
import com.example.aplicacionfinal.domain.model.Movie
import com.example.aplicacionfinal.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                SearchScreen(
                    query = "",
                    onQueryChange = {},
                    searchResults = listOf(
                        Movie(
                            id = 1,
                            title = "Example Movie",
                            overview = "An example of a movie description.",
                            posterPath = "/example_path.jpg",
                            releaseDate = "2024-01-01"
                        )
                    ),
                    onMovieClick = {  },
                    isLoading = false,
                    errorMessage = null
                )
            }
        }
    }
}
