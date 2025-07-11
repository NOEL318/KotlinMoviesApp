package com.example.test

import android.app.Application
import com.example.test.data.di.dataModule
import com.example.test.domain.di.domainModule
import com.example.test.presentation.di.presentationModule
import org.koin.core.context.startKoin

class BadApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(dataModule, domainModule, presentationModule)
        }
    }
}
