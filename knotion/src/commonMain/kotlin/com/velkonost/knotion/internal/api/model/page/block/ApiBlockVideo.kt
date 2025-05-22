package com.velkonost.knotion.internal.api.model.page.block

import com.velkonost.knotion.internal.api.model.emojiOrFile.ApiFile
import com.velkonost.knotion.internal.api.model.richText.ApiRichText
import com.velkonost.knotion.internal.model.emojiOrFile.FileImpl
import com.velkonost.knotion.model.emojiOrFile.File
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiBlockVideo(
    val type: String,
    val file: ApiFile? = null,
    val external: ApiFile? = null,
    val caption: List<ApiRichText>? = null,
)

internal fun ApiBlockVideo.toModel(): File {
    return when (type) {
        "file" -> FileImpl(name = null, url = file!!.url)
        "external" -> FileImpl(name = null, url = external!!.url)
        else -> throw RuntimeException()
    }
}