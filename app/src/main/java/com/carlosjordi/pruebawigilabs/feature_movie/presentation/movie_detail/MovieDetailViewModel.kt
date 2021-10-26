package com.carlosjordi.pruebawigilabs.feature_movie.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosjordi.pruebawigilabs.core.Constants
import com.carlosjordi.pruebawigilabs.feature_movie.domain.use_case.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCase: GetMovieDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState.Loading)
    val state: State<MovieDetailState>
        get() = _state

    init {
        savedStateHandle.get<Int>(Constants.KEY_MOVIE_ID)?.let { movieId ->
            getMovieById(movieId)
        }
    }

    private fun getMovieById(id: Int) {
        movieDetailUseCase(id).onEach { movie ->
            if (movie == null)
                _state.value = MovieDetailState.Loading
            else
                _state.value = MovieDetailState.Success(movie)
        }.launchIn(viewModelScope)
    }
}