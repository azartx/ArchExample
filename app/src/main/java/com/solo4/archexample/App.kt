package com.solo4.archexample

import android.app.Application
import com.solo4.archexample.data.di.dataModule
import com.solo4.archexample.di.viewModelModule
import com.solo4.archexample.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule, domainModule, dataModule))
        }
    }
}
