package com.velkonost.knotion.internal.api.model.page.block

import com.velkonost.knotion.internal.api.model.richtext.ApiRichText
import kotlinx.serialization.Serializable
import org.jraf.klibnotion.internal.api.model.base.ApiEmojiOrFile
import org.jraf.klibnotion.internal.api.model.richtext.ApiRichText

@Serializable
internal data class ApiBlockCallout(
    val text: List<ApiRichText>,
    val icon: ApiEmojiOrFile
)
