package com.example.test.domain.di

import com.example.test.domain.usecase.GetLatestMoviesUseCase
import com.example.test.domain.usecase.GetPopularMoviesUseCase
import com.example.test.domain.usecase.InsertLatestMoviesUseCase
import com.example.test.domain.usecase.InsertPopularMoviesUseCase
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
    single {
        InsertLatestMoviesUseCase(
            repository = get()
        )
    }
    single {
        InsertPopularMoviesUseCase(
            repository = get()
        )

    }
}