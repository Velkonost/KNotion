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

package com.velkonost.knotion.internal.api.model.emojiOrFile

import com.velkonost.knotion.internal.model.emojiOrFile.EmojiImpl
import com.velkonost.knotion.internal.model.emojiOrFile.FileImpl
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiEmojiOrFile(
    val type: String,
    val emoji: String? = null,
    val file: ApiFile? = null,
    val external: ApiFile? = null,
)

internal fun ApiEmojiOrFile.toModel(): EmojiOrFile? {
    return when (type) {
        "emoji" -> EmojiImpl(value = this.emoji!!)
        "file" -> FileImpl(name = null, url = this.file!!.url)
        "external" -> FileImpl(name = null, url = this.external!!.url)
        else -> null
    }
}