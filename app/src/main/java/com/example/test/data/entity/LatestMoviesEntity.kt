package com.example.test.data.entity

import androidx.room.Entity
import com.example.test.domain.model.Movie

@Entity(tableName = "latest_movies")
data class LatestMoviesEntity
(    val page: Int=1,
    val results: List<Movie>? = emptyList(),
    val total_pages: Int ? = 0,
    val total_results: Int ? = 0)
