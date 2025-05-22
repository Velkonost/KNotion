package com.velkonost.knotion.internal.network

import com.velkonost.knotion.internal.network.extension.contentNegotiation
import com.velkonost.knotion.internal.network.extension.httpTimeout
import com.velkonost.knotion.internal.network.extension.requestRetry
import io.ktor.client.*
import io.ktor.client.network.sockets.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

internal const val KTOR_REQUEST_TIMEOUT_MILLIS = 30_000L
private const val URL = "https://api.notion.com/v1"
private const val HEADER_NOTION_VERSION = "Notion-Version"
private const val NOTION_API_VERSION = "2021-08-16"

internal fun ktorClient(
    token: String
): HttpClient {
    val ktorClient = withPlatformEngine {
        Logging {
            logger = Logger.SIMPLE
            level = LogLevel.NONE
        }

        requestRetry {
            maxRetries = 5
            retryIf { _, response ->
                !response.status.isSuccess()
            }
            retryOnExceptionIf { _, cause ->
                cause is HttpRequestTimeoutException || cause is ConnectTimeoutException
            }
            delayMillis { retry ->
                retry * 3000L
            }
            modifyRequest { request ->
                request.headers.append("x-retry-count", retryCount.toString())
            }
        }

        httpTimeout {
            requestTimeoutMillis = KTOR_REQUEST_TIMEOUT_MILLIS
            socketTimeoutMillis = KTOR_REQUEST_TIMEOUT_MILLIS * 2
            connectTimeoutMillis = KTOR_REQUEST_TIMEOUT_MILLIS
        }

        contentNegotiation {
            json(
                Json {
                    explicitNulls = false
                    ignoreUnknownKeys = true
                    prettyPrint = true
                }
            )
        }

        defaultRequest {
            url(URL)
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            header(HEADER_NOTION_VERSION, NOTION_API_VERSION)
            header(
                HttpHeaders.Authorization,
                "Bearer $token"
            )
        }
    }

    return ktorClient
}