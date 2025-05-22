package com.velkonost.knotion.internal.client.databases

import com.velkonost.knotion.client.KNotionDatabases
import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.database.Database
import com.velkonost.knotion.model.database.query.DatabaseQuery
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.page.Page
import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage
import com.velkonost.knotion.model.property.sort.PropertySort
import com.velkonost.knotion.model.property.spec.PropertySpecList
import com.velkonost.knotion.model.richText.RichTextList

internal class KNotionDatabasesImpl(
    private val service: DatabasesService
) : KNotionDatabases {
    override suspend fun getDatabase(id: UuidString): Database {
        return service.getDatabase(id)
            .apiToModel(ApiDatabaseConverter)
    }

    override suspend fun getDatabaseList(pagination: Pagination): ResultPage<Database> {
        return service.getDatabaseList(pagination.startCursor)
            .apiToModel(ApiPageResultDatabaseConverter)
    }

    override suspend fun queryDatabase(
        id: UuidString,
        query: DatabaseQuery?,
        sort: PropertySort?,
        pagination: Pagination,
    ): ResultPage<Page> {
        return service.queryDatabase(
            id,
            Triple(query, sort, pagination).modelToApi(ApiDatabaseQueryConverter),
        )
            .apiToModel(ApiPageResultPageConverter)
    }

    override suspend fun createDatabase(
        parentPageId: UuidString,
        title: RichTextList,
        icon: EmojiOrFile?,
        cover: File?,
        properties: PropertySpecList,
    ): Database {
        return service.createDatabase(
            DatabaseCreateParameters(
                parentPageId = parentPageId,
                title = title,
                icon = icon,
                cover = cover,
                properties = properties,
            ).modelToApi(ApiDatabaseCreateParametersConverter)
        )
            .apiToModel(ApiDatabaseConverter)
    }

    override suspend fun updateDatabase(
        id: UuidString,
        title: RichTextList?,
        icon: EmojiOrFile?,
        cover: File?,
        properties: PropertySpecList?,
    ): Database {
        return service.updateDatabase(
            id,
            DatabaseUpdateParameters(
                title = title,
                icon = icon,
                cover = cover,
                properties = properties,
            ).modelToApi(ApiDatabaseUpdateParametersConverter)
        )
            .apiToModel(ApiDatabaseConverter)
    }
}