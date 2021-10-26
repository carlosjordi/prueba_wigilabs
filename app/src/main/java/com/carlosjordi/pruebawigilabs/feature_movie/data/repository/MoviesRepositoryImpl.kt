package com.carlosjordi.pruebawigilabs.feature_movie.data.repository

import com.carlosjordi.pruebawigilabs.feature_movie.data.local.MovieDao
import com.carlosjordi.pruebawigilabs.feature_movie.data.remote.TheMovieDbApi
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.toMovieList
import com.carlosjordi.pruebawigilabs.feature_movie.domain.repository.IMoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val api: TheMovieDbApi,
    private val movieDao: MovieDao
) : IMoviesRepository {

    override suspend fun getPopularMovies(): List<Movie> {

        if (movieDao.getMovies().isEmpty()) {
            val moviesToBeSaved = api.getPopularMovies().results.toMovieList().toTypedArray()
            movieDao.insertMovies(*moviesToBeSaved)
        }

        return movieDao.getMovies()
    }

    override suspend fun getMovie(id: Int): Movie? =
        movieDao.getMovie(id)

}