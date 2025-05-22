package com.velkonost.knotion.internal.client.databases

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.internal.api.model.database.ApiDatabase
import com.velkonost.knotion.internal.api.model.page.ApiPage
import com.velkonost.knotion.internal.api.model.database.ApiResultPage
import com.velkonost.knotion.internal.api.model.database.request.CreateDatabaseRequest
import com.velkonost.knotion.internal.api.model.database.request.QueryDatabaseRequest
import com.velkonost.knotion.internal.api.model.database.request.UpdateDatabaseRequest
import com.velkonost.knotion.internal.client.base.BaseService
import com.velkonost.knotion.internal.client.base.BaseService.Companion.START_CURSOR
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

internal class DatabasesService(
    private val httpClient: HttpClient
) : BaseService {
    override val path: String
        get() = "databases"

    suspend fun getDatabase(id: UuidString): ApiDatabase {
        return httpClient.get("$path/$id").body()
    }

    suspend fun getDatabaseList(startCursor: String?): ApiResultPage<ApiDatabase> {
        return httpClient.get(path) {
            if (startCursor != null) parameter(START_CURSOR, startCursor)
        }.body()
    }

    suspend fun queryDatabase(id: UuidString, request: QueryDatabaseRequest): ApiResultPage<ApiPage> {
        return httpClient.post("$path/$id/query") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    suspend fun createDatabase(
        request: CreateDatabaseRequest,
    ): ApiDatabase {
        return httpClient.post(path) {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    suspend fun updateDatabase(
        id: UuidString,
        request: UpdateDatabaseRequest,
    ): ApiDatabase {
        return httpClient.patch("$path/$id") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}