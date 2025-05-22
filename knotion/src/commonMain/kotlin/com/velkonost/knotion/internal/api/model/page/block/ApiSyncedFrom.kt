package com.velkonost.knotion.internal.api.model.page.block

import com.velkonost.knotion.extension.UuidString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiSyncedFrom(
    @SerialName("block_id")
    val blockId: UuidString,
)
