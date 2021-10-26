package com.carlosjordi.pruebawigilabs.feature_movie.domain.use_case

import com.carlosjordi.pruebawigilabs.core.ConstantsTest
import com.carlosjordi.pruebawigilabs.feature_movie.data.repository.MoviesFakeRepositoryImpl
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

private const val MOVIE_ID_TO_TEST = 580489 // Venom Let there be Carnage movie id
private const val WRONG_MOVIE_ID_TO_TEST = 580121 // Doesn't exist

class GetMovieDetailUseCaseTest {

    private lateinit var getAllPopularMoviesUseCase: GetAllPopularMoviesUseCase
    private lateinit var fakeRepository: MoviesFakeRepositoryImpl

    @Before
    fun setUp() {
        fakeRepository = MoviesFakeRepositoryImpl()
        getAllPopularMoviesUseCase = GetAllPopularMoviesUseCase(fakeRepository)
    }

    @Test
    fun `Get movie by id, correctly obtained`() = runBlocking {
        val movie = fakeRepository.getMovie(MOVIE_ID_TO_TEST)
        assertThat(movie).isEqualTo(ConstantsTest.movies.find { it.id == MOVIE_ID_TO_TEST })
    }

    @Test
    fun `Get movie by wrong id, null obtained`() = runBlocking {
        val movie = fakeRepository.getMovie(WRONG_MOVIE_ID_TO_TEST)
        assertThat(movie).isEqualTo(null)
    }
}