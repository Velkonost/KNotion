package com.velkonost.knotion.internal.api.model.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/user).
 */
@Serializable
internal data class ApiUser(
    val id: String,
    val type: String? = null,
    val person: ApiPerson? = null,
    val bot: ApiBot? = null,
    val name: String? = null,
    @SerialName("avatar_url")
    val avatarUrl: String? = null,
)
