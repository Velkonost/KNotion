package com.velkonost.knotion.internal.model.user

import com.velkonost.knotion.extension.UrlString
import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.user.Bot

internal data class BotImpl(
    override val id: UuidString,
    override val name: String,
    override val avatarUrl: UrlString?,
) : Bot
