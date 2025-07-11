package com.example.test.domain.usecase

import com.example.test.domain.model.Movie
import com.example.test.domain.repository.MoviesRepository


class InsertLatestMoviesUseCase(private val repository: MoviesRepository)  {
    suspend operator fun invoke(movies: List<Movie>) {
        repository.insertLatestMovies(movies)
    }

}