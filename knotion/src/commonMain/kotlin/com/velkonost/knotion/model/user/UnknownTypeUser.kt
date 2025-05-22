package com.velkonost.knotion.model.user

/**
 * This type is returned when a User of a type unknown to this library is returned by the Notion API.
 *
 * See [Reference](https://developers.notion.com/reference/user).
 */
interface UnknownTypeUser : User {
    val name: String?
    val type: String?
}
