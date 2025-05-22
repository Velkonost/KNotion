package com.velkonost.knotion.internal.client.pages

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.internal.api.model.page.ApiPage
import com.velkonost.knotion.internal.api.model.page.request.CreatePageRequest
import com.velkonost.knotion.internal.api.model.page.request.UpdatePageRequest
import com.velkonost.knotion.internal.client.base.BaseService
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

internal class PagesService(
    private val httpClient: HttpClient
) : BaseService {
    override val path: String
        get() = "pages"

    suspend fun getPage(id: UuidString): ApiPage {
        return httpClient.get("$path/$id").body()
    }

    suspend fun createPage(request: CreatePageRequest): ApiPage {
        return httpClient.post(path) {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    suspend fun updatePage(id: UuidString, request: UpdatePageRequest): ApiPage {
        return httpClient.patch("$path/$id") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    suspend fun archivePage(id: UuidString, archive: Boolean): ApiPage {
        return httpClient.patch("$path/$id") {
            contentType(ContentType.Application.Json)
            setBody(mapOf("archived" to archive))
        }.body()
    }
}