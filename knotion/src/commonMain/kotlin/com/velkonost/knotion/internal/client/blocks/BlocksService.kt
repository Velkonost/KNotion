package com.velkonost.knotion.internal.client.blocks

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.internal.api.model.database.ApiResultPage
import com.velkonost.knotion.internal.api.model.page.block.ApiBlock
import com.velkonost.knotion.internal.api.model.page.block.request.AppendBlockRequest
import com.velkonost.knotion.internal.api.model.page.block.request.UpdateBlockRequest
import com.velkonost.knotion.internal.client.base.BaseService
import com.velkonost.knotion.internal.client.base.BaseService.Companion.START_CURSOR
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

internal class BlocksService(
    private val httpClient: HttpClient
) : BaseService{
    override val path: String
        get() = "blocks"

    suspend fun getBlockList(parentId: UuidString, startCursor: String?): ApiResultPage<ApiBlock> {
        return httpClient.get("$path/$parentId/children") {
            if (startCursor != null) parameter(START_CURSOR, startCursor)
        }.body()
    }

    suspend fun appendBlockList(parentId: UuidString, request: AppendBlockRequest) {
        httpClient.patch("$path/$parentId/children") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }
    }

    suspend fun getBlock(id: UuidString): ApiBlock {
        return httpClient.get("$path/$id").body()
    }

    suspend fun updateBlock(id: UuidString, block: UpdateBlockRequest): ApiBlock {
        return httpClient.patch("$path/$id") {
            contentType(ContentType.Application.Json)
            setBody(block)
        }.body()
    }
}