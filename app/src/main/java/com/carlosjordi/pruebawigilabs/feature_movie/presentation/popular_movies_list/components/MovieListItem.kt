package com.carlosjordi.pruebawigilabs.feature_movie.presentation.popular_movies_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.imagePath
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.shortDescription

@Composable
fun MovieListItem(movie: Movie) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column {
            MoviePoster(moviePoster = movie.imagePath())
            Spacer(modifier = Modifier.height(8.dp))
            MovieTitle(title = movie.title)
            Spacer(modifier = Modifier.height(8.dp))
            MovieShortDescription(description = movie.shortDescription())
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun MoviePoster(moviePoster: String) {
    Image(
        painter = rememberImagePainter(moviePoster),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    )
}

@Composable
fun MovieTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth(),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun MovieShortDescription(description: String) {
    Text(
        text = description,
        modifier = Modifier.padding(horizontal = 8.dp)
    )
}