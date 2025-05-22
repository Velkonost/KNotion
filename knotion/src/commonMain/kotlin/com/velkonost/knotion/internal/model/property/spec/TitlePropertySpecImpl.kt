package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.TitlePropertySpec

internal data class TitlePropertySpecImpl(
    override val name: String,
    override val id: String
) : TitlePropertySpec
