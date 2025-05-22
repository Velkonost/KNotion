package com.velkonost.knotion.internal.client.base


internal interface BaseService {
    val path: String
    companion object {
        const val START_CURSOR = "start_cursor"
    }
}