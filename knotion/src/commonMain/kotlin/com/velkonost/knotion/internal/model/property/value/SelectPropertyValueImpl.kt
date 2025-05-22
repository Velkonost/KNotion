package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.SelectOption
import com.velkonost.knotion.model.property.value.SelectPropertyValue

internal data class SelectPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: SelectOption?,
) : SelectPropertyValue
