package com.velkonost.knotion.model.pagination

/**
 * Used to specify a specific page to retrieve when doing a query.
 */
data class Pagination(
    /**
     * Cursor pointing to the first element of the page to retrieve.
     *
     * Use [FIRST_CURSOR] to retrieve the first page.
     */
    val startCursor: String? = FIRST_CURSOR,
) {
    companion object {
        val FIRST_CURSOR: String? = null
    }
}
