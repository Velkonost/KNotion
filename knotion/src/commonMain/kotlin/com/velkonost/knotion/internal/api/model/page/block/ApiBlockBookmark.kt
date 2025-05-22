package com.velkonost.knotion.internal.api.model.page.block

import com.velkonost.knotion.internal.api.model.richText.ApiRichText
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiBlockBookmark(
    val url: String,
    val caption: List<ApiRichText>,
)
