package com.velkonost.knotion.internal.api.model.page.block

import com.velkonost.knotion.internal.api.model.emojiOrFile.toModel
import com.velkonost.knotion.internal.api.model.page.toDateModel
import com.velkonost.knotion.internal.api.model.richText.toModel
import com.velkonost.knotion.internal.model.page.block.*
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.richText.RichTextList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/block).
 */
@Serializable
internal data class ApiBlock(
    val id: String,
    @SerialName("created_time")
    val createdTime: String,
    @SerialName("last_edited_time")
    val lastEditedTime: String,
    @SerialName("has_children")
    val hasChildren: Boolean,
    val type: String,
    val paragraph: ApiBlockText? = null,
    @SerialName("heading_1")
    val heading1: ApiBlockText? = null,
    @SerialName("heading_2")
    val heading2: ApiBlockText? = null,
    @SerialName("heading_3")
    val heading3: ApiBlockText? = null,
    @SerialName("bulleted_list_item")
    val bulletedListItem: ApiBlockText? = null,
    @SerialName("numbered_list_item")
    val numberedListItem: ApiBlockText? = null,
    val toggle: ApiBlockText? = null,
    @SerialName("to_do")
    val toDo: ApiBlockTodo? = null,
    @SerialName("child_page")
    val childPage: ApiBlockChildPage? = null,
    @SerialName("child_database")
    val childDatabase: ApiBlockChildDatabase? = null,
    val code: ApiBlockCode? = null,
    val equation: ApiBlockEquation? = null,
    val callout: ApiBlockCallout? = null,
    val embed: ApiBlockEmbed? = null,
    val quote: ApiBlockText? = null,
    val bookmark: ApiBlockBookmark? = null,
    val image: ApiBlockImage? = null,
    val video: ApiBlockVideo? = null,
    @SerialName("synced_block")
    val syncedBlock: ApiSyncedBlock? = null,
)

internal fun ApiBlock.toModel(): Block {
    val id = this.id
    val created = createdTime.toDateModel().timestamp
    val lastEdited = lastEditedTime.toDateModel().timestamp
    // HACK: we use empty list as a signal that there are children that need fetching
    val children: List<Block>? = if (this.hasChildren) emptyList() else null
    return when (val type = this.type) {
        "paragraph" -> {
            ParagraphBlockImpl(
                id = id,
                created = created,
                lastEdited = lastEdited,
                text = paragraph.toRichTextList(),
                children = children
            )
        }

        "heading_1" -> Heading1BlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            text = heading1.toRichTextList()
        )

        "heading_2" -> Heading2BlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            text = heading2.toRichTextList()
        )

        "heading_3" -> Heading3BlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            text = heading3.toRichTextList()
        )

        "bulleted_list_item" -> BulletedListItemBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            text = bulletedListItem.toRichTextList(),
            children = children
        )

        "numbered_list_item" -> NumberedListItemBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            text = numberedListItem.toRichTextList(),
            children = children
        )

        "to_do" -> ToDoBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            text = toDo.toRichTextList(),
            checked = toDo!!.checked,
            children = children
        )

        "toggle" -> ToggleBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            text = toggle.toRichTextList(),
            children = children
        )

        "child_page" -> ChildPageBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            title = childPage!!.title
        )

        "child_database" -> ChildDatabaseBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            title = childDatabase!!.title
        )

        "code" -> CodeBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            language = code!!.language,
            text = code.toRichTextList()
        )

        "equation" -> EquationBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            expression = equation!!.expression
        )

        "callout" -> CalloutBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            text = callout!!.toRichTextList(),
            children = children,
            icon = callout?.icon?.toModel()
        )

        "quote" -> QuoteBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            children = children,
            text = quote!!.toRichTextList()
        )

        "embed" -> EmbedBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            url = embed!!.url
        )

        "bookmark" -> BookmarkBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            url = bookmark!!.url,
            caption = bookmark.toRichTextList()
        )

        "divider" -> DividerBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
        )

        "table_of_contents" -> TableOfContentsBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
        )

        "image" -> ImageBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            caption = image!!.toRichTextList(),
            image = image.toModel()
        )

        "video" -> VideoBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            caption = video!!.toRichTextList(),
            video = video.toModel()
        )

        "synced_block" -> SyncedBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            syncedFrom = syncedBlock?.syncedFrom?.blockId,
        )

        else -> UnknownTypeBlockImpl(
            id = id,
            created = created,
            lastEdited = lastEdited,
            type = type,
        )
    }
}

private fun ApiBlockText?.toRichTextList() =
    RichTextList().apply { items.addAll(this@toRichTextList!!.text.map { it.toModel() }) }

private fun ApiBlockTodo?.toRichTextList() =
    RichTextList().apply { items.addAll(this@toRichTextList!!.text.map { it.toModel() }) }

private fun ApiBlockCode.toRichTextList() =
    RichTextList().apply { items.addAll(this@toRichTextList.text.map { it.toModel() }) }

private fun ApiBlockCallout.toRichTextList() =
    RichTextList().apply { items.addAll(this@toRichTextList.text.map { it.toModel() }) }

private fun ApiBlockBookmark.toRichTextList() =
    RichTextList().apply { items.addAll(this@toRichTextList.caption.map { it.toModel() }) }

private fun ApiBlockImage.toRichTextList() =
    this.caption?.let { RichTextList().apply { items.addAll(this@toRichTextList.caption.map { it.toModel() }) } }

private fun ApiBlockVideo.toRichTextList() =
    this.caption?.let { RichTextList().apply { items.addAll(this@toRichTextList.caption.map { it.toModel() }) } }
