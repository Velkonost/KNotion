package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.value.CheckboxPropertyValue

internal data class CheckboxPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: Boolean,
) : CheckboxPropertyValue
