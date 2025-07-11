package com.example.test.data.di

import com.example.test.data.repository.MoviesRepositoryImp
import com.example.test.data.source.remote.MovieService
import com.example.test.domain.repository.MoviesRepository
import org.koin.dsl.module

val dataModule = module {

    single { MovieService() }

    single<MoviesRepository> {
        MoviesRepositoryImp(
            remoteMovies = get()
        )
    }
}