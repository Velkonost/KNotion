package com.velkonost.knotion.internal.network

import io.ktor.client.*
import io.ktor.client.engine.js.*

internal actual fun withPlatformEngine(
    config: HttpClientConfig<*>.() -> Unit
) = HttpClient(Js) {
    config(this)
}