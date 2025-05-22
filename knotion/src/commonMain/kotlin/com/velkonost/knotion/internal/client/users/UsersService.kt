package com.velkonost.knotion.internal.client.users

import com.velkonost.knotion.internal.api.model.database.ApiResultPage
import com.velkonost.knotion.internal.api.model.user.ApiUser
import com.velkonost.knotion.internal.client.base.BaseService
import com.velkonost.knotion.internal.client.base.BaseService.Companion.START_CURSOR
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class UsersService(
    private val httpClient: HttpClient
) : BaseService {

    override val path: String
        get() = "users"

    suspend fun getUser(id: String): ApiUser {
        return httpClient.get("$path/$id").body()
    }

    suspend fun getUserList(startCursor: String?): ApiResultPage<ApiUser> {
        return httpClient.get(path) {
            if (startCursor != null) parameter(START_CURSOR, startCursor)
        }.body()
    }
}