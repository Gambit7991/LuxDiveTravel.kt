package com.example.luxdivetravel.app

import android.app.Application
import com.example.luxdivetravel.di.koin.appModule
import com.example.luxdivetravel.di.koin.dataModule
import com.example.luxdivetravel.di.koin.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}