package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.property.value.RelationPropertyValue

internal data class RelationPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: List<UuidString>,
) : RelationPropertyValue
