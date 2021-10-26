package com.carlosjordi.pruebawigilabs.feature_movie.presentation.movie_detail

import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie

sealed class MovieDetailState {
    object Loading : MovieDetailState()
    data class Success(val movie: Movie) : MovieDetailState()
}
