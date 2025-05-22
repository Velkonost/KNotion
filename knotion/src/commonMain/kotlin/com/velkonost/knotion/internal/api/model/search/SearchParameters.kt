package com.velkonost.knotion.internal.api.model.search

import org.jraf.klibnotion.model.property.sort.PropertySort

internal data class SearchParameters(
    val query: String?,
    val sort: PropertySort?,
    val type: String,
    val startCursor: String?,
)
