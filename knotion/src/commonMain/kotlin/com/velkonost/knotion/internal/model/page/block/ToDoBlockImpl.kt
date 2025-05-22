package com.velkonost.knotion.internal.model.page.block

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.page.block.ToDoBlock
import com.velkonost.knotion.model.richText.RichTextList

internal data class ToDoBlockImpl(
    override val id: UuidString,
    override val created: Timestamp,
    override val lastEdited: Timestamp,
    override val text: RichTextList,
    override val checked: Boolean,
    override var children: List<Block>?,
) : ToDoBlock, MutableBlock
