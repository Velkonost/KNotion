package com.velkonost.knotion.internal.api.model.page.block

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiSyncedBlock(
    @SerialName("synced_from")
    val syncedFrom: ApiSyncedFrom
)
