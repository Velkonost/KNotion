package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.RichTextPropertySpec

internal data class RichTextPropertySpecImpl(
    override val name: String,
    override val id: String
) : RichTextPropertySpec
