package com.velkonost.knotion.internal.network.extension

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

internal suspend inline fun HttpClient.get(
    path: String,
    parameters: List<Pair<String, String>> = emptyList()
) = get {
    url {
        path(path)
        parameters.forEach { parameter(it.first, it.second) }
    }
}

internal suspend inline fun <reified T> HttpClient.post(
    path: String,
    body: T
) = post {
    url { path(path) }
    setBody(body)
}