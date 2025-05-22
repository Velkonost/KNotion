package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.LastEditedByPropertySpec

internal data class LastEditedByPropertySpecImpl(
    override val name: String,
    override val id: String,
) : LastEditedByPropertySpec
