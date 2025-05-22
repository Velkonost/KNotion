package com.velkonost.knotion.model.property

import com.velkonost.knotion.model.Color

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

class SelectOptionList {
    internal val selectOptionList = mutableListOf<SelectOption>()

    private fun add(selectOption: SelectOption): SelectOptionList {
        selectOptionList.add(selectOption)
        return this
    }

    fun option(name: String, color: Color) = add(SelectOptionImpl(name = name, id = name, color = color))
}
