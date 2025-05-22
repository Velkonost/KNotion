package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.value.LastEditedByPropertyValue
import com.velkonost.knotion.model.user.User

internal data class LastEditedByPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: User,
) : LastEditedByPropertyValue
