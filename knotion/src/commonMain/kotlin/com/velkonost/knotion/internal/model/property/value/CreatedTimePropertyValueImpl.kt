package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.date.DateOrDateTime
import com.velkonost.knotion.model.property.value.CreatedTimePropertyValue

internal data class CreatedTimePropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: DateOrDateTime,
) : CreatedTimePropertyValue
