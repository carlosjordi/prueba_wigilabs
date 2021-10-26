package com.carlosjordi.pruebawigilabs.feature_movie.presentation.popular_movies_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.carlosjordi.pruebawigilabs.core.components.MovieDescription
import com.carlosjordi.pruebawigilabs.core.components.MoviePoster
import com.carlosjordi.pruebawigilabs.core.components.MovieTitle
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.imagePath
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.shortDescription

@Composable
fun MovieListItem(
    movie: Movie,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column {
            MoviePoster(moviePoster = movie.imagePath())
            Spacer(modifier = Modifier.height(8.dp))
            MovieTitle(title = movie.title)
            Spacer(modifier = Modifier.height(8.dp))
            MovieDescription(description = movie.shortDescription())
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}