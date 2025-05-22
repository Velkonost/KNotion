package com.velkonost.knotion.model.property.sort

class PropertySort {
    internal val sorting: MutableList<Pair<String, Direction>> = mutableListOf()

    private fun add(propertyName: String, direction: Direction): PropertySort {
        sorting += propertyName to direction
        return this
    }

    fun ascending(propertyName: String) = add(propertyName, direction = Direction.ASCENDING)
    fun descending(propertyName: String) = add(propertyName, direction = Direction.DESCENDING)

    internal enum class Direction {
        ASCENDING,
        DESCENDING,
    }
}
