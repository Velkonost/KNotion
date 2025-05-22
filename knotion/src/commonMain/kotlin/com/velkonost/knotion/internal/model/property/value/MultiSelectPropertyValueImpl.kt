package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.SelectOption
import com.velkonost.knotion.model.property.value.MultiSelectPropertyValue

internal data class MultiSelectPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: List<SelectOption>,
) : MultiSelectPropertyValue
