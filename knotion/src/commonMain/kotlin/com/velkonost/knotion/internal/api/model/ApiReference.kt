/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2021-present Benoit 'BoD' Lubek (BoD@JRAF.org)
 * and contributors (https://github.com/BoD/klibnotion/graphs/contributors)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.velkonost.knotion.internal.api.model

import com.velkonost.knotion.model.DatabaseReference
import com.velkonost.knotion.model.PageReference
import com.velkonost.knotion.model.Reference
import com.velkonost.knotion.model.UnknownTypeReference
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/page#page-parent).
 */
@Serializable
internal data class ApiReference(
    val type: String? = null,
    @SerialName("database_id")
    val databaseId: String? = null,
    @SerialName("page_id")
    val pageId: String? = null,
)

internal fun ApiReference.toDatabaseModel(): Reference = DatabaseReference(databaseId.orEmpty())
internal fun ApiReference.toPageModel(): Reference = PageReference(pageId.orEmpty())
internal fun ApiReference.toUnknownModel(): Reference = UnknownTypeReference(type.orEmpty())

internal fun DatabaseReference.toApi(): ApiReference = ApiReference(
    databaseId = this.id
)

internal fun PageReference.toApi(): ApiReference = ApiReference(
    pageId = this.id
)