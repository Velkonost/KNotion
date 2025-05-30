package com.velkonost.knotion.client

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage
import com.velkonost.knotion.model.user.User

/**
 * Interface for managing Notion users through the Notion API.
 * This interface provides methods to retrieve information about users in your Notion workspace,
 * including the current user, workspace members, and bots.
 *
 * Example usage:
 * ```
 * // Retrieve a specific user by ID
 * val user = client.users.getUser("user-id")
 *
 * // List all users in the workspace
 * val users = client.users.getUserList()
 * ```
 */
interface KNotionUsers {
    /**
     * Retrieves a user by their ID.
     * This method fetches information about a specific user, such as their name, type, and avatar.
     *
     * @param id The unique identifier of the user (UUID format)
     * @return A [User] object containing user details
     * @throws NotionApiException if the user doesn't exist or the API request fails
     * @see <a href="https://developers.notion.com/reference/get-user">Retrieve a user</a>
     */
    suspend fun getUser(id: UuidString): User

    /**
     * Lists all users in the workspace that have been shared with your integration.
     * This method returns a paginated list of users, including people and bots.
     *
     * @param pagination Optional pagination parameters to control the number of results
     * @return A [ResultPage] containing a list of [User] objects and pagination information
     * @throws NotionApiException if the API request fails
     * @see <a href="https://developers.notion.com/reference/get-users">List all users</a>
     */
    suspend fun getUserList(pagination: Pagination = Pagination()): ResultPage<User>
}