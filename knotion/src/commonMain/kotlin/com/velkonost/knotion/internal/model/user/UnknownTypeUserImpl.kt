package com.velkonost.knotion.internal.model.user

import com.velkonost.knotion.extension.UrlString
import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.user.UnknownTypeUser

internal data class UnknownTypeUserImpl(
    override val id: UuidString,
    override val name: String?,
    override val avatarUrl: UrlString?,
    override val type: String,
) : UnknownTypeUser
