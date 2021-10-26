package com.carlosjordi.pruebawigilabs.feature_movie.domain.repository

import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie

interface IMoviesRepository {

    suspend fun getPopularMovies(): List<Movie>

    suspend fun getMovie(id: Int): Movie?
}