package com.velkonost.knotion.internal.client.databases

import com.velkonost.knotion.client.KNotionDatabases
import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.internal.api.model.database.query.ApiDatabaseQuerySort
import com.velkonost.knotion.internal.api.model.database.request.*
import com.velkonost.knotion.internal.api.model.database.toModel
import com.velkonost.knotion.internal.api.model.database.toPaginationModel
import com.velkonost.knotion.internal.api.model.page.toModel
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
        return service.getDatabase(id).toModel()
    }

    override suspend fun getDatabaseList(pagination: Pagination): ResultPage<Database> {
        val response = service.getDatabaseList(pagination.startCursor).toModel()
        val results = response.results.map { it.toModel() }
        return ResultPage(
            results = results,
            nextPagination = response.nextPagination
        )
    }

    override suspend fun queryDatabase(
        id: UuidString,
        query: DatabaseQuery?,
        sort: PropertySort?,
        pagination: Pagination,
    ): ResultPage<Page> {
        val response = service.queryDatabase(
            id = id,
            request = QueryDatabaseRequest(
                filter = query?.let {
                    DatabaseQueryRequestFilters(
                        or = query.anyFilters.toList().map { it.toApi() }
                            .ifEmpty { null },
                        and = query.allFilters.toList().map { it.toApi() }
                            .ifEmpty { null },
                    )
                }?.let { if (it.or == null && it.and == null) null else it },
                sorts = sort?.let { sortElem ->
                    sortElem.sorting.map { (propertyName, direction) ->
                        ApiDatabaseQuerySort(
                            property = propertyName,
                            direction = when (direction) {
                                PropertySort.Direction.ASCENDING -> "ascending"
                                PropertySort.Direction.DESCENDING -> "descending"
                            }
                        )
                    }
                },
                startCursor = pagination.startCursor,
            )
        )
        return ResultPage(
            results = response.results.map { it.toModel() },
            nextPagination = response.nextCursor?.toPaginationModel()
        )
    }

    override suspend fun createDatabase(
        parentPageId: UuidString,
        title: RichTextList,
        icon: EmojiOrFile?,
        cover: File?,
        properties: PropertySpecList,
    ): Database {
        return service.createDatabase(
            CreateDatabaseRequest(
                parentPageId = parentPageId,
                title = title,
                icon = icon,
                cover = cover,
                properties = properties
            )
        ).toModel()
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
            UpdateDatabaseRequest(
                title = title,
                icon = icon,
                cover = cover,
                properties = properties,
            )
        ).toModel()
    }
}