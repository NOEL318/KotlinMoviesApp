package com.example.test.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class TrendingResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int,
)