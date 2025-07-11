package com.example.test.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.domain.usecase.GetLatestMoviesUseCase
import com.example.test.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MainViewModel(
    private val getLatestMoviesUseCase: GetLatestMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(MainViewState())
    val state = _state.asStateFlow()

    fun initialLoad() {
        viewModelScope.launch(Dispatchers.IO) {

            val popularMovies = async { getPopularMoviesUseCase() }
            val latestMovies = async { getLatestMoviesUseCase() }

            _state.value = _state.value.copy(
                firstTitle = "Latest",
                firstMovies = latestMovies.await(),
                secondTitle = "Popular",
                secondMovies = popularMovies.await()
            )
        }
    }
}