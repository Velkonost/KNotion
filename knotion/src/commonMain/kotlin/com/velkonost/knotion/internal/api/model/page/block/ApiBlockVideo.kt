package com.velkonost.knotion.internal.api.model.page.block

import com.velkonost.knotion.internal.api.model.emojiOrFile.ApiFile
import com.velkonost.knotion.internal.api.model.richtext.ApiRichText
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiBlockVideo(
    val type: String,
    val file: ApiFile? = null,
    val external: ApiFile? = null,
    val caption: List<ApiRichText>? = null,
)
