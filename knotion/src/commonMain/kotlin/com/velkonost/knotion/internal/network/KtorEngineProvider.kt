package com.velkonost.knotion.internal.network

import io.ktor.client.*

internal expect fun withPlatformEngine(config: HttpClientConfig<*>.() -> Unit): HttpClient