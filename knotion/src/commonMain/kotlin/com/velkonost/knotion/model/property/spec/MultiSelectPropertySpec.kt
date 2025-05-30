package com.velkonost.knotion.model.property.spec

import com.velkonost.knotion.model.property.SelectOption
import com.velkonost.knotion.model.property.spec.PropertySpec

/**
 * Represents a multi-select property specification in a Notion database.
 * This property allows users to select multiple predefined options from a list,
 * useful for categorizing or tagging pages with multiple attributes.
 * 
 * Multi-select properties support:
 * - Multiple selections per property
 * - Custom option colors
 * - Dynamic option creation
 * - Option reordering
 * - Filtering and sorting by selected options
 * 
 * Common use cases include:
 * - Tags and categories
 * - Multiple status tracking
 * - Feature flags
 * - Skill sets
 * - Project labels
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#multi-select">Multi-select property</a>
 */
interface MultiSelectPropertySpec : PropertySpec {
    /**
     * The list of available options that can be selected.
     * Each option has a name and can optionally have a color.
     * The order of options in this list determines their display order.
     */
    val options: List<SelectOption>
}
