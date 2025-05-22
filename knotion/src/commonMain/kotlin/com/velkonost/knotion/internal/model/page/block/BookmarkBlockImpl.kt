package com.velkonost.knotion.internal.model.page.block

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.page.block.BookmarkBlock
import com.velkonost.knotion.model.richText.RichTextList

internal data class BookmarkBlockImpl(
    override val id: UuidString,
    override val created: Timestamp,
    override val lastEdited: Timestamp,
    override val url: String,
    override val caption: RichTextList?,
) : BookmarkBlock {
    override val children: List<Block>? = null
}
