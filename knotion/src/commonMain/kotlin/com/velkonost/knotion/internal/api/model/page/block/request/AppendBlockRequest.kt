package com.velkonost.knotion.internal.api.model.page.block.request

import com.velkonost.knotion.model.page.block.Block
import kotlinx.serialization.Serializable

@Serializable
internal data class AppendBlockRequest(
    val children: List<Block>,
)