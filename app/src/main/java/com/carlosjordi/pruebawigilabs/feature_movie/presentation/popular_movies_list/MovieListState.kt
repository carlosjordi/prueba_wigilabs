package com.carlosjordi.pruebawigilabs.feature_movie.presentation.popular_movies_list

import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie

sealed class MovieListState {
    object Loading: MovieListState()
    data class Success(val movies: List<Movie>): MovieListState()
    data class Error(val message: String): MovieListState()
}