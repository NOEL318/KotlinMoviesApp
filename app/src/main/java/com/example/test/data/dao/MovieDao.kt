package com.example.test.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.test.domain.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM latest_movies")
    fun getLatestMovies(): List<Movie>

    @Query("SELECT * FROM popular_movies")
    fun getPopularMovies(): List<Movie>

    @Insert
    suspend fun insertLatestMovies(movies: List<Movie>)

    @Insert
    suspend fun insertPopularMovies(movies: List<Movie>)

}