package com.carlosjordi.pruebawigilabs.feature_movie.domain.use_case

import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie
import com.carlosjordi.pruebawigilabs.feature_movie.domain.repository.IMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: IMoviesRepository
) {
    operator fun invoke(movieId: Int): Flow<Movie?> = flow {
        emit(null)
        val movie = repository.getMovie(movieId)
        emit(movie)
    }
}