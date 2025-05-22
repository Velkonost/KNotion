package com.velkonost.knotion.internal.model.page.block

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.page.block.ToggleBlock
import com.velkonost.knotion.model.richText.RichTextList

internal data class ToggleBlockImpl(
    override val id: UuidString,
    override val created: Timestamp,
    override val lastEdited: Timestamp,
    override val text: RichTextList,
    override var children: List<Block>?,
) : ToggleBlock, MutableBlock
