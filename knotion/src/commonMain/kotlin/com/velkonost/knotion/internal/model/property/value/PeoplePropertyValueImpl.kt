package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.value.PeoplePropertyValue
import com.velkonost.knotion.model.user.User

internal data class PeoplePropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: List<User>,
) : PeoplePropertyValue
