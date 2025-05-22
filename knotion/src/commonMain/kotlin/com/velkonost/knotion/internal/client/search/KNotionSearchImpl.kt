package com.velkonost.knotion.internal.client.search

import com.velkonost.knotion.client.KNotionSearch
import com.velkonost.knotion.internal.api.model.database.toModel
import com.velkonost.knotion.internal.api.model.page.toModel
import com.velkonost.knotion.internal.api.model.search.ApiSearchFilter
import com.velkonost.knotion.internal.api.model.search.ApiSearchSort
import com.velkonost.knotion.internal.api.model.search.request.SearchRequest
import com.velkonost.knotion.model.database.Database
import com.velkonost.knotion.model.page.Page
import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage
import com.velkonost.knotion.model.property.sort.PropertySort

internal class KNotionSearchImpl(
    private val service: SearchService
) : KNotionSearch {
    override suspend fun searchPages(query: String?, sort: PropertySort?, pagination: Pagination): ResultPage<Page> {
        val response = service.searchPages(
            request = SearchRequest(
                query = query,
                sort = sort?.let {
                    ApiSearchSort(
                        direction = when (it.sorting.first().second) {
                            PropertySort.Direction.ASCENDING -> "ascending"
                            PropertySort.Direction.DESCENDING -> "descending"
                        },
                        timestamp = it.sorting.first().first
                    )
                },
                filter = ApiSearchFilter(
                    property = "object",
                    value = "page",
                ),
                startCursor = pagination.startCursor
            )
        ).toModel()
        return ResultPage(
            results = response.results.map { it.toModel() },
            nextPagination = response.nextPagination
        )
    }

    override suspend fun searchDatabases(
        query: String?,
        sort: PropertySort?,
        pagination: Pagination
    ): ResultPage<Database> {
        val response = service.searchDatabases(
            request = SearchRequest(
                query = query,
                sort = sort?.let {
                    ApiSearchSort(
                        direction = when (it.sorting.first().second) {
                            PropertySort.Direction.ASCENDING -> "ascending"
                            PropertySort.Direction.DESCENDING -> "descending"
                        },
                        timestamp = it.sorting.first().first
                    )
                },
                filter = ApiSearchFilter(
                    property = "object",
                    value = "database",
                ),
                startCursor = pagination.startCursor,
            )
        ).toModel()
        return ResultPage(
            results = response.results.map { it.toModel() },
            nextPagination = response.nextPagination
        )
    }
}