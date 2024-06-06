package com.example.newskmp.di

import com.example.newskmp.core.HttpKtorClient
import com.example.newskmp.core.getHttpClientEngine
import com.example.newskmp.data.repository.ArticleRepository
import com.example.newskmp.data.repository.impl.ArticleRepositoryImpl
import com.example.newskmp.data.service.ArticleService
import com.example.newskmp.data.service.impl.ArticleServiceImpl
import com.example.newskmp.presentatation.vm.ArticlesViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import org.koin.dsl.module

val httpClientModule = module {
    single<HttpClient> {
        HttpKtorClient().provideKtorClient(get())
    }
}

val httpClientModuleEngine = module {
    single<HttpClientEngine> {
        getHttpClientEngine()
    }
}

val repositoryModule = module {
    single<ArticleRepository> {
        ArticleRepositoryImpl(get())
    }
}

val serviceModule = module {
    single<ArticleService> {
        ArticleServiceImpl(get())
    }
}

val viewModelModule = module {
    single {
        ArticlesViewModel(get())
    }
}

val allModules = listOf(
    httpClientModule,
    httpClientModuleEngine,
    repositoryModule,
    serviceModule,
    viewModelModule
)