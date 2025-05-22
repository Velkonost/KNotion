package com.velkonost.knotion.internal.network

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import java.util.concurrent.TimeUnit

internal actual fun withPlatformEngine(
    config: HttpClientConfig<*>.() -> Unit
) = HttpClient(OkHttp) {
    config(this)
    engine {
        config {
            retryOnConnectionFailure(true)
            connectTimeout(KTOR_REQUEST_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
        }
    }
}