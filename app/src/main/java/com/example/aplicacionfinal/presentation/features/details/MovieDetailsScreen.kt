package com.example.aplicacionfinal.presentation.features.details

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier

@Composable
fun MovieDetailsScreen(navController: NavController, movieId: String?) {

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            "Movie Details for Movie ID: $movieId",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
