package com.velkonost.knotion.model.property.value

import com.velkonost.knotion.model.emojiOrFile.File

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
interface FilesPropertyValue : PropertyValue<List<File>>
