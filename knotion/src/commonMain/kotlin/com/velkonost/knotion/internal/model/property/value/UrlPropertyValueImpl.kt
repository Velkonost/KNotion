package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.value.UrlPropertyValue

internal data class UrlPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: String?,
) : UrlPropertyValue
