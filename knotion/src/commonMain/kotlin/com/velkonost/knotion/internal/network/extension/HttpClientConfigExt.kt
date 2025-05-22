package com.velkonost.knotion.internal.network.extension

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*

internal fun HttpClientConfig<*>.httpTimeout(block: HttpTimeoutConfig.() -> Unit) =
    install(HttpTimeout, block)

internal fun HttpClientConfig<*>.contentNegotiation(block: ContentNegotiationConfig.() -> Unit) =
    install(ContentNegotiation, block)


internal fun HttpClientConfig<*>.requestRetry(block: HttpRequestRetryConfig.() -> Unit) =
    install(HttpRequestRetry, block)