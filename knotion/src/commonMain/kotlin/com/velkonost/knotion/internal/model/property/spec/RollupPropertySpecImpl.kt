package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.RollupPropertySpec

internal data class RollupPropertySpecImpl(
    override val name: String,
    override val id: String,
    override val relationPropertyName: String,
    override val relationPropertyId: String,
    override val rollupPropertyName: String,
    override val rollupPropertyId: String,
    override val function: RollupPropertySpec.RollupFunction,
) : RollupPropertySpec
