package com.carlosjordi.pruebawigilabs.feature_movie.presentation.popular_movies_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosjordi.pruebawigilabs.feature_movie.domain.use_case.GetAllPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getAllPopularMoviesUseCase: GetAllPopularMoviesUseCase
) : ViewModel() {

    private val _state = mutableStateOf<MovieListState>(MovieListState.Loading)
    val state: State<MovieListState>
        get() = _state

    init {
        getMovies()
    }

    private fun getMovies() {
        getAllPopularMoviesUseCase().onEach { movies ->
            if (movies.isEmpty())
                _state.value = MovieListState.Loading
            else
                _state.value = MovieListState.Success(movies)
        }.launchIn(viewModelScope)
    }
}