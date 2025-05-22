package com.velkonost.knotion.internal.client.pages

import com.velkonost.knotion.client.KNotionPages
import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.internal.api.model.page.request.CreatePageRequest
import com.velkonost.knotion.internal.api.model.page.request.UpdatePageRequest
import com.velkonost.knotion.internal.api.model.page.request.toStringValue
import com.velkonost.knotion.internal.api.model.page.toModel
import com.velkonost.knotion.internal.api.model.toApi
import com.velkonost.knotion.model.DatabaseReference
import com.velkonost.knotion.model.PageReference
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.page.Page
import com.velkonost.knotion.model.page.block.BlockListProducer
import com.velkonost.knotion.model.page.block.MutableBlockList
import com.velkonost.knotion.model.page.block.invoke
import com.velkonost.knotion.model.property.value.PropertyValueList
import com.velkonost.knotion.model.richText.RichTextList

internal class KNotionPagesImpl(
    private val service: PagesService
) : KNotionPages {
    override suspend fun getPage(id: UuidString): Page {
        return service.getPage(id).toModel()
    }

    override suspend fun createPage(
        parentDatabase: DatabaseReference,
        icon: EmojiOrFile?,
        cover: File?,
        properties: PropertyValueList,
        content: MutableBlockList?
    ): Page {
        return service.createPage(
            CreatePageRequest(
                parent = parentDatabase.toApi(),
                properties = properties.propertyValueList.map { it.toStringValue() },
                children = content,
                icon = icon,
                cover = cover,
            )
        ).toModel()
    }

    override suspend fun createPage(
        parentDatabase: DatabaseReference,
        icon: EmojiOrFile?,
        cover: File?,
        properties: PropertyValueList,
        content: BlockListProducer
    ): Page = createPage(
        parentDatabase = parentDatabase,
        properties = properties,
        icon = icon,
        cover = cover,
        content = content.invoke(),
    )

    override suspend fun createPage(
        parentPage: PageReference,
        title: RichTextList,
        icon: EmojiOrFile?,
        cover: File?,
        content: MutableBlockList?
    ): Page {
        return service.createPage(
            CreatePageRequest(
                parent = parentPage.toApi(),
                properties = PropertyValueList()
                    .title("title", title)
                    .propertyValueList.map { it.toStringValue() },
                children = content,
                icon = icon,
                cover = cover
            )
        ).toModel()
    }

    override suspend fun createPage(
        parentPage: PageReference,
        title: RichTextList,
        icon: EmojiOrFile?,
        cover: File?,
        content: BlockListProducer
    ): Page = createPage(
        parentPage = parentPage,
        title = title,
        icon = icon,
        cover = cover,
        content = content.invoke(),
    )

    override suspend fun updatePage(
        id: UuidString,
        icon: EmojiOrFile?,
        cover: File?,
        properties: PropertyValueList
    ): Page {
        return service.updatePage(
            id = id,
            request = UpdatePageRequest(
                properties = properties.propertyValueList.map { it.toStringValue() },
                icon = icon,
                cover = cover,
            )
        ).toModel()
    }

    override suspend fun setPageArchived(id: UuidString, archived: Boolean): Page {
        return service.archivePage(id, archived).toModel()
    }
}