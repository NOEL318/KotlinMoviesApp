package com.example.test.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.test.domain.model.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM latest_movies")
    suspend fun getLatestMovies(): List<Movie>

    @Query("SELECT * FROM popular_movies")
    suspend fun getPopularMovies(): List<Movie>

}