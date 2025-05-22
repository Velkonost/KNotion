package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.date.DateOrDateTime
import com.velkonost.knotion.model.property.value.LastEditedTimePropertyValue

internal data class LastEditedTimePropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: DateOrDateTime,
) : LastEditedTimePropertyValue
