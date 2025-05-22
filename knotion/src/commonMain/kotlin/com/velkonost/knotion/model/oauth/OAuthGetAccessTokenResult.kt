package com.velkonost.knotion.model.oauth

import com.velkonost.knotion.extension.UuidString

/**
 * See [Reference](https://developers.notion.com/docs/authorization#exchanging-the-grant-for-an-access-token).
 */
interface OAuthGetAccessTokenResult {
    /**
     * An access token used to authorize requests to the Notion API.
     */
    val accessToken: String

    /**
     * The ID of the workspace where this authorization took place.
     */
    val workspaceId: UuidString

    /**
     * A human-readable name which can be used to display this authorization in UI.
     */
    val workspaceName: String

    /**
     * A URL to an image which can be used to display this authorization in UI.
     */
    val workspaceIcon: String?

    /**
     * An identifier for this authorization.
     */
    val botId: String
}
