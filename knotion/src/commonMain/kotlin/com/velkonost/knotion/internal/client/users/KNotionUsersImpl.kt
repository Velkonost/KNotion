package com.velkonost.knotion.internal.client.users

import com.velkonost.knotion.client.KNotionUsers
import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.internal.api.model.database.toModel
import com.velkonost.knotion.internal.api.model.user.toModel
import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage
import com.velkonost.knotion.model.user.User

internal class KNotionUsersImpl(
    private val service: UsersService
) : KNotionUsers {
    override suspend fun getUser(id: UuidString): User {
        return service.getUser(id).toModel()
    }

    override suspend fun getUserList(pagination: Pagination): ResultPage<User> {
        val response =  service.getUserList(pagination.startCursor).toModel()
        return ResultPage(
            results = response.results.map { it.toModel() },
            nextPagination = response.nextPagination
        )
    }
}