package com.example.test.presentation

import android.provider.Settings.Global.getString
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MainScreen(
    mainViewModel: MainViewModel = koinViewModel<MainViewModel>()
) {
    val state by mainViewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        mainViewModel.initialLoad()
    }
   // val apiUrl = "https://api.themoviedb.org/3/movie/${imageid}/images"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            state.firstTitle,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 10.em),
            fontWeight = FontWeight.W900
        )
        LazyRow {
            items(state.firstMovies, key = { it.id }) {
                GlideImage(
                    model = "https://image.tmdb.org/t/p/w500${it.poster_path}",
                    contentDescription = null,
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            state.secondTitle,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 10.em),
            fontWeight = FontWeight.W900

        )
        LazyRow {
            items(state.secondMovies, key = { it.id }) {
                GlideImage(
                   model = "https://image.tmdb.org/t/p/w500${it.poster_path}",
                    contentDescription = null,
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}
