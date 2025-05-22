package com.velkonost.knotion.model.user

import com.velkonost.knotion.extension.UrlString
import com.velkonost.knotion.extension.UuidString

/**
 * See [Reference](https://developers.notion.com/reference/user).
 */
sealed interface User {
    val id: UuidString
    val avatarUrl: UrlString?
}
