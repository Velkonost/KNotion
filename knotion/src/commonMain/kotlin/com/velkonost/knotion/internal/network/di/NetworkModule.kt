package com.velkonost.knotion.internal.network.di

import com.velkonost.knotion.internal.network.ktorClient
import io.ktor.client.*
import org.koin.dsl.module

internal fun networkModule(token: String) = module {
    factory<HttpClient> {ktorClient(token) }
}