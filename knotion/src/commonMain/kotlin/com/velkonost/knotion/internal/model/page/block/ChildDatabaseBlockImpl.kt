package com.velkonost.knotion.internal.model.page.block

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.page.block.ChildDatabaseBlock

internal data class ChildDatabaseBlockImpl(
    override val id: UuidString,
    override val created: Timestamp,
    override val lastEdited: Timestamp,
    override val title: String,
) : ChildDatabaseBlock {
    override val children: List<Block>? = null
}
