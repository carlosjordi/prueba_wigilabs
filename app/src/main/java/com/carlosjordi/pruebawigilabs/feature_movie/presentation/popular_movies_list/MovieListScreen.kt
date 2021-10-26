package com.carlosjordi.pruebawigilabs.feature_movie.presentation.popular_movies_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.carlosjordi.pruebawigilabs.feature_movie.presentation.popular_movies_list.components.MovieListItem

@Composable
fun MovieListScreen(
    movieListViewModel: MovieListViewModel = hiltViewModel()
) {
    when (val state = movieListViewModel.state.value) {
        is MovieListState.Error -> {
        }
        MovieListState.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier.fillMaxSize()
            )
        }
        is MovieListState.Success -> {
            LazyColumn() {
                items(items = state.movies) { movie ->
                    MovieListItem(movie = movie)
                }
            }
        }
    }
}