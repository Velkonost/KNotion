package com.velkonost.knotion.internal.model.page.block

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.page.block.UnknownTypeBlock

internal data class UnknownTypeBlockImpl(
    override val id: UuidString,
    override val created: Timestamp,
    override val lastEdited: Timestamp,
    override val type: String,
) : UnknownTypeBlock {
    override val children: List<Block>? = null
}
