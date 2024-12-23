import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Card
import coil.compose.rememberImagePainter
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.unit.dp
import com.example.aplicacionfinal.domain.model.Movie
import androidx.compose.material3.CardDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(
    movies: List<Movie>,
    onMovieClick: (Movie) -> Unit,
    onFavoritesClick: () -> Unit,
    onSearchClick: () -> Unit,
    isLoading: Boolean,
    errorMessage: String?
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Movie Explorer") },
                actions = {
                    IconButton(onClick = onSearchClick) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = onFavoritesClick) {
                        Icon(Icons.Filled.Favorite, contentDescription = "Favorites")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        } else if (errorMessage != null) {
            Text(
                text = errorMessage,
                modifier = Modifier.fillMaxSize(),
                color = Color.Red
            )
        } else {
            LazyColumn(contentPadding = paddingValues) {
                items(movies) { movie ->
                    MovieItem(movie = movie, onClick = { onMovieClick(movie) })
                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter("https://image.tmdb.org/t/p/w500${movie.posterPath}"),
                contentDescription = movie.title,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(movie.title, style = MaterialTheme.typography.headlineSmall)
                Text(movie.releaseDate, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}