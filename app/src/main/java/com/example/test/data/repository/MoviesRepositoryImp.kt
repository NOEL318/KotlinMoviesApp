package com.example.test.data.repository

import com.example.test.data.source.remote.MovieService
import com.example.test.domain.model.Movie
import com.example.test.domain.repository.MoviesRepository

class MoviesRepositoryImp(
    private val remoteMovies: MovieService
): MoviesRepository {

    override suspend fun getLatestMovies(): List<Movie> {
        return remoteMovies.getLatestMovies()
    }

    override suspend fun getPopularMovies(): List<Movie> {
        return remoteMovies.getPopularMovies()
    }
}