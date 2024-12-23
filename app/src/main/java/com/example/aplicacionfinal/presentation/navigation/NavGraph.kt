package com.example.aplicacionfinal.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aplicacionfinal.presentation.features.movies.MoviesScreen
import com.example.aplicacionfinal.presentation.features.search.SearchScreen
import com.example.aplicacionfinal.presentation.features.details.MovieDetailsScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "movies") {
        composable("movies") { MoviesScreen(navController) }
        composable("search") { SearchScreen(navController) }
        composable("movie_details/{movieId}") { backStackEntry ->
            MovieDetailsScreen(navController, movieId = backStackEntry.arguments?.getString("movieId"))
        }
    }
}
