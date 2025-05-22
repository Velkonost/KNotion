package com.velkonost.knotion.internal.api.model.user

import com.velkonost.knotion.internal.model.user.AnonymousUserImpl
import com.velkonost.knotion.internal.model.user.BotImpl
import com.velkonost.knotion.internal.model.user.PersonImpl
import com.velkonost.knotion.internal.model.user.UnknownTypeUserImpl
import com.velkonost.knotion.model.user.User
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

internal fun ApiUser?.toModel(): User {
    return when (this?.type) {
        "person" -> PersonImpl(
            id = id,
            name = name.orEmpty(),
            avatarUrl = avatarUrl,
            email = person?.email.orEmpty(),
        )

        "bot" -> BotImpl(
            id = id,
            name = name.orEmpty(),
            avatarUrl = avatarUrl,
        )

        null -> AnonymousUserImpl(
            id = this?.id.orEmpty(),
            avatarUrl = this?.avatarUrl.orEmpty()
        )

        else -> UnknownTypeUserImpl(
            id = id,
            name = name,
            avatarUrl = avatarUrl,
            type = type,
        )
    }
}