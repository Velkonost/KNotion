package com.velkonost.knotion.model.user

/**
 * See [Reference](https://developers.notion.com/reference/user).
 */
interface Person : User {
    val name: String
    val email: String
}
