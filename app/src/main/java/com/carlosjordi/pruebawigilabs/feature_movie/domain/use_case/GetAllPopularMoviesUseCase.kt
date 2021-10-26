package com.carlosjordi.pruebawigilabs.feature_movie.domain.use_case

import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie
import com.carlosjordi.pruebawigilabs.feature_movie.domain.repository.IMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllPopularMoviesUseCase @Inject constructor(
    private val repository: IMoviesRepository
) {
    operator fun invoke(): Flow<List<Movie>> = flow {
        try {
            emit(emptyList())
            val movies = repository.getPopularMovies()
            emit(movies)
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}