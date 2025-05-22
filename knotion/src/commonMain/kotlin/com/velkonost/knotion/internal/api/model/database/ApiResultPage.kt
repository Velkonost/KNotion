package com.velkonost.knotion.internal.api.model.database

import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/pagination).
 */
@Serializable
internal data class ApiResultPage<T : Any>(
    val results: List<T>,
    @SerialName("next_cursor")
    val nextCursor: String?,
)

internal fun <T: Any> ApiResultPage<T>.toModel(): ResultPage<T> {
    return ResultPage(
        results = results,
        nextPagination = nextCursor?.toPaginationModel()
    )
}

internal fun String.toPaginationModel(): Pagination = Pagination(
    startCursor = this
)