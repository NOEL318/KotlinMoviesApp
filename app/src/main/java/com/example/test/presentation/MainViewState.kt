package com.example.test.presentation

import com.example.test.domain.model.Movie

data class MainViewState(
    val firstTitle: String = "",
    val firstMovies: List<Movie> = emptyList(),
    val secondTitle: String = "",
    val secondMovies: List<Movie> = emptyList()
)
