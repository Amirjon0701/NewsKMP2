package com.example.newskmp.core

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpKtorClient {
    fun provideKtorClient(httpClientEngine: HttpClientEngine): HttpClient {
        return HttpClient(httpClientEngine){
            install(ContentNegotiation){
                json(Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
            }

            defaultRequest {
                url("https://newsapi.org/")
                header(
                    "X-Api-Key", "ca9984bf10144e429d80f30de1c8ab7e"
                )
            }
        }
    }
}