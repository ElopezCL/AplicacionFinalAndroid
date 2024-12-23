package com.example.aplicacionfinal.presentation.features.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun SearchScreen(navController: NavHostController) {
    Column {
        Text(text = "Search Movies")

        // Puedes agregar un campo de búsqueda o funcionalidad adicional aquí.
        Button(onClick = {
            // Navegar a la pantalla de detalles de la película (por ejemplo, usando un ID de película)
            navController.navigate("movie_details/1")
        }) {
            Text("Go to Movie Details")
        }
    }
}
