package com.velkonost.knotion.client

import com.velkonost.knotion.internal.client.KNotionClientImpl

object KNotion {
    fun setupClient(accessToken: String): KNotionClient {
        return KNotionClientImpl(accessToken)
    }
}