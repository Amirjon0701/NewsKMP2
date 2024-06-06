package com.example.newskmp

import android.app.Application
import com.example.newskmp.di.allModules
import org.koin.core.context.startKoin
import ru.alexgladkov.odyssey.compose.RootController
import ru.alexgladkov.odyssey.core.configuration.RootControllerType

class App: Application() {
    override fun onCreate() {
        super.onCreate()
//        val rootController = RootController(RootControllerType.Root)
//        Odyssey.initialize(rootController)
        startKoin{
            modules(allModules)
        }
    }
}