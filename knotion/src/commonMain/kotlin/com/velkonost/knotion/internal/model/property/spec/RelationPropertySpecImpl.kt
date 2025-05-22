package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.property.spec.RelationPropertySpec

internal data class RelationPropertySpecImpl(
    override val name: String,
    override val id: String,
    override val databaseId: UuidString,
    override val syncedPropertyName: String,
    override val syncedPropertyId: String,
) : RelationPropertySpec
