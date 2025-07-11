package com.example.test.domain.di

import com.example.test.domain.usecase.GetLatestMoviesUseCase
import com.example.test.domain.usecase.GetPopularMoviesUseCase
import org.koin.dsl.module

val domainModule = module {
    single {
        GetLatestMoviesUseCase(
            repository = get()
        )
    }

    single {
        GetPopularMoviesUseCase(
            repository = get()
        )
    }
}