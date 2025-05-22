package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.value.CreatedByPropertyValue
import com.velkonost.knotion.model.user.User

internal data class CreatedByPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: User,
) : CreatedByPropertyValue
