package com.velkonost.knotion.model.pagination

import kotlin.jvm.JvmField

/**
 * A page of results.
 */
data class ResultPage<T : Any>(
    /**
     * The actual items of that page.
     */
    @JvmField
    val results: List<T>,

    /**
     * Next [Pagination] (if any), that can be used to retrieve the next page.
     * This will be `null` if this page is the last page.
     */
    @JvmField
    val nextPagination: Pagination?,
)
