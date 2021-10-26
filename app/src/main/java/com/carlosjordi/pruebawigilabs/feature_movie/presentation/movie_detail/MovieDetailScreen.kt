package com.carlosjordi.pruebawigilabs.feature_movie.presentation.movie_detail

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.carlosjordi.pruebawigilabs.feature_movie.presentation.movie_detail.components.MovieDetailItem

@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
) {
    when (val state = movieDetailViewModel.state.value) {
        MovieDetailState.Loading -> {
            CircularProgressIndicator()
        }
        is MovieDetailState.Success -> {
            MovieDetailItem(movie = state.movie)
        }
    }
}