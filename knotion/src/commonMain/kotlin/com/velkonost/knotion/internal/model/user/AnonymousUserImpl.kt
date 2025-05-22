package com.velkonost.knotion.internal.model.user

import com.velkonost.knotion.extension.UrlString
import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.user.AnonymousUser

internal data class AnonymousUserImpl(
    override val id: UuidString,
    override val avatarUrl: UrlString?,
) : AnonymousUser
