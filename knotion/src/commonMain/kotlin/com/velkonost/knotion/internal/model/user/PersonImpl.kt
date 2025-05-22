package com.velkonost.knotion.internal.model.user

import com.velkonost.knotion.extension.UrlString
import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.user.Person

internal data class PersonImpl(
    override val id: UuidString,
    override val name: String,
    override val avatarUrl: UrlString?,
    override val email: String
) : Person
