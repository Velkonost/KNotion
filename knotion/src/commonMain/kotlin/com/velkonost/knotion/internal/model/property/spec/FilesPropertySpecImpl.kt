package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.FilesPropertySpec

internal data class FilesPropertySpecImpl(
    override val name: String,
    override val id: String
) : FilesPropertySpec
