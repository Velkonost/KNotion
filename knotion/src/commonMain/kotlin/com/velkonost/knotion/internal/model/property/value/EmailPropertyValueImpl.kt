package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.value.EmailPropertyValue

internal data class EmailPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: String?,
) : EmailPropertyValue
