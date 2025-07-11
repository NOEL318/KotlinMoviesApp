package com.example.test.data.source.remote

import com.example.test.domain.model.Movie
import com.example.test.domain.model.TrendingResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MovieService {
private val client: HttpClient = MyHttpClientConfig().client
val apiUrl = "https://api.themoviedb.org/3/movie/"
    suspend fun getLatestMovies(): List<Movie> {
        var latest: TrendingResponse = client.get("https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1").body()
        val latest_list: List<Movie> = latest.results
        client.close()
        return latest_list
    }

    suspend fun getPopularMovies(): List<Movie> {
        var popular: TrendingResponse =
            client.get("https://api.themoviedb.org/3/movie/popular?language=en-US&page=1").body()
        val popular_list: List<Movie> = popular.results
        client.close()
        return popular_list
    }

}