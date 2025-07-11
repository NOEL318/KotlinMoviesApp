package com.example.test.data.source.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MyHttpClientConfig {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(
                        accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZjVlYWI4M2NlNTFiNjc1ZDkzNGQyZjcwMmVkNTIxYyIsIm5iZiI6MTc1MjA3NjkxNi4yMzIsInN1YiI6IjY4NmU5Mjc0NDdkNTlhODk2YWE5NjYyOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1TagDMcgYZz6_fS3U8r7-tT2OqelBKPvhddPxyRt1DQ",
                        refreshToken = null
                    )
                }
            }
        }
    }
}