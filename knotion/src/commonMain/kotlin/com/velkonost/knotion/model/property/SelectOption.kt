package com.velkonost.knotion.model.property

import com.velkonost.knotion.internal.model.property.SelectOptionImpl
import com.velkonost.knotion.model.Color

/**
 * Represents a selectable option for a Notion select or multi-select property.
 *
 * Each option has a name, a unique (but not always UUID) ID, and a color.
 * Used for defining and working with select/multi-select property values and schemas.
 */
interface SelectOption {
    /**
     * Name of the option as it appears in Notion.
     */
    val name: String

    /**
     * ID of the option, which does not change if the name is changed. These are sometimes, but not always, UUIDs.
     */
    val id: String

    /**
     * Color of the option.
     */
    val color: Color
}

/**
 * Builder-style class for constructing a list of [SelectOption]s.
 *
 * Example usage:
 * ```
 * val options = SelectOptionList()
 *     .option("To Do", Color.DEFAULT)
 *     .option("In Progress", Color.YELLOW)
 *     .option("Done", Color.GREEN)
 * ```
 */
class SelectOptionList {
    internal val selectOptionList = mutableListOf<SelectOption>()

    private fun add(selectOption: SelectOption): SelectOptionList {
        selectOptionList.add(selectOption)
        return this
    }

    /**
     * Adds a new [SelectOption] to the list with the given name and color.
     * The option's ID will be set to the name by default.
     */
    fun option(name: String, color: Color) = add(SelectOptionImpl(name = name, id = name, color = color))
}
