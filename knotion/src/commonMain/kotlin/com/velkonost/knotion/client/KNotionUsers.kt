package com.velkonost.knotion.client

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage
import com.velkonost.knotion.model.user.User

interface KNotionUsers {
    /**
     * Retrieve a user.
     * @see <a href="https://developers.notion.com/reference/get-user">Retrieve a user</a>
     */
    suspend fun getUser(id: UuidString): User

    /**
     * List all users.
     * @see <a href="https://developers.notion.com/reference/get-users">List all users</a>
     */
    suspend fun getUserList(pagination: Pagination = Pagination()): ResultPage<User>
}