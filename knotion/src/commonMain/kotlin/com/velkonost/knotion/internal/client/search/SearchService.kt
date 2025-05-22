package com.velkonost.knotion.internal.client.search

import com.velkonost.knotion.internal.api.model.database.ApiDatabase
import com.velkonost.knotion.internal.api.model.database.ApiResultPage
import com.velkonost.knotion.internal.api.model.page.ApiPage
import com.velkonost.knotion.internal.api.model.search.request.SearchRequest
import com.velkonost.knotion.internal.client.base.BaseService
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

internal class SearchService(
    private val httpClient: HttpClient
) : BaseService {
    override val path: String
        get() = "search"

    suspend fun searchPages(request: SearchRequest): ApiResultPage<ApiPage> {
        return httpClient.post(path) {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    suspend fun searchDatabases(request: SearchRequest): ApiResultPage<ApiDatabase> {
        return httpClient.post(path) {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

}