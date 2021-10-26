package com.carlosjordi.pruebawigilabs.feature_movie.domain.use_case

import com.carlosjordi.pruebawigilabs.core.ConstantsTest
import com.carlosjordi.pruebawigilabs.feature_movie.data.repository.MoviesFakeRepositoryImpl
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllPopularMoviesUseCaseTest {

    private lateinit var getAllPopularMoviesUseCase: GetAllPopularMoviesUseCase
    private lateinit var fakeRepository: MoviesFakeRepositoryImpl

    @Before
    fun setUp() {
        fakeRepository = MoviesFakeRepositoryImpl()
        getAllPopularMoviesUseCase = GetAllPopularMoviesUseCase(fakeRepository)
    }

    @Test
    fun `Get movies, correctly obtained`() = runBlocking {
        val movies = fakeRepository.getPopularMovies()
        assertThat(movies).isEqualTo(ConstantsTest.movies)
    }

    @Test
    fun `Get movies, empty list obtained`() = runBlocking {
        fakeRepository.shouldReturnEmptyList()
        val movies = fakeRepository.getPopularMovies()
        assertThat(movies).isEqualTo(emptyList<Movie>())
    }
}