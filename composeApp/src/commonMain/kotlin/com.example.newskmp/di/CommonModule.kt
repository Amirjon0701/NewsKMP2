package com.example.newskmp.di

import com.example.newskmp.core.HttpKtorClient
import com.example.newskmp.core.getHttpClientEngine
import com.example.newskmp.data.mapper.ArticleMapper
import com.example.newskmp.data.repository.ArticleRepository
import com.example.newskmp.data.repository.impl.ArticleRepositoryImpl
import com.example.newskmp.data.service.ArticleService
import com.example.newskmp.data.service.impl.ArticleServiceImpl
import com.example.newskmp.db.Database
import com.example.newskmp.db.DatabaseDriverFactory
import com.example.newskmp.db.provideDatabaseDriverFactory
import com.example.newskmp.presentatation.vm.ArticlesViewModel
import com.example.newskmp.presentatation.vm.DetailViewModel
import com.example.newskmp.presentatation.vm.FavoriteViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import org.koin.core.module.dsl.singleOf
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
        ArticleRepositoryImpl(get(), get(), get())
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

    single {
        DetailViewModel(get())
    }

    single {
        FavoriteViewModel(get())
    }
}

val dbModule = module {
    single<DatabaseDriverFactory>{
        provideDatabaseDriverFactory()
    }

    single<Database> {
        Database(get())
    }
}

val mapperModule = module {
    single{
        ArticleMapper()
    }
}

val allModules = listOf(
    httpClientModule,
    httpClientModuleEngine,
    repositoryModule,
    serviceModule,
    viewModelModule,
    dbModule,
    mapperModule
)