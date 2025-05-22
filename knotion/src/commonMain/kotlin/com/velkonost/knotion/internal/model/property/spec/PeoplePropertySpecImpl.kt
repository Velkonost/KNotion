package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.PeoplePropertySpec

internal data class PeoplePropertySpecImpl(
    override val name: String,
    override val id: String
) : PeoplePropertySpec
