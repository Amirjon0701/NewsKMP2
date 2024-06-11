package com.example.newskmp

import android.app.Application
import com.example.newskmp.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
//        val rootController = RootController(RootControllerType.Root)
//        Odyssey.initialize(rootController)
        startKoin{
            androidContext(this@App)
            modules(allModules)
        }
    }
}