package com.velkonost.knotion.internal.model.page.block

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.page.block.QuoteBlock
import com.velkonost.knotion.model.richText.RichTextList

internal data class QuoteBlockImpl(
    override val id: UuidString,
    override val text: RichTextList?,
    override val created: Timestamp,
    override val lastEdited: Timestamp,
    override var children: List<Block>?,
) : QuoteBlock, MutableBlock
