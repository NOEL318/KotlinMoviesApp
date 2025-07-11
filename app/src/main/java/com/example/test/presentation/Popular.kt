package com.example.test.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.test.domain.model.Movie
import com.example.test.data.source.remote.MovieService

@Composable
fun Popular() {
    val service = MovieService()
    var popular_list: List<Movie> = emptyList()

    LaunchedEffect(true) {
        popular_list = service.getPopularMovies()
        println(popular_list)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Popular List", modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 10.em),
            fontWeight = FontWeight.W900
        )
        if (popular_list.isNotEmpty()) {
            print("SI entra al if")
            for (movie in popular_list) {
                Text(
                    movie.title, modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = TextStyle(fontSize = 5.em),
                    fontWeight = FontWeight.W900
                )
                println(movie.title)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PopularPreview() {
    Popular()
}
