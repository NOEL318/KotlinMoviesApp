package com.example.test.domain.repository

import com.example.test.domain.model.Movie

interface MoviesRepository {
    suspend fun getLatestMovies(): List<Movie>
    suspend fun getPopularMovies(): List<Movie>

    suspend fun insertLatestMovies(movies: List<Movie>): List<Movie>
    suspend fun insertPopularMovies(movies: List<Movie>): List<Movie>
}
