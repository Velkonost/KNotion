package com.velkonost.knotion.internal.api.model.user

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/user).
 */
@Serializable
internal data class ApiPerson(
    val email: String,
)
