package com.example.test.domain.usecase

import com.example.test.domain.model.Movie
import com.example.test.domain.repository.MoviesRepository

class GetLatestMoviesUseCase(
    private val repository: MoviesRepository
) {
    suspend operator fun invoke(): List<Movie> {
        return repository.getLatestMovies()
    }
}
