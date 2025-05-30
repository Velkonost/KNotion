package com.velkonost.knotion.model.property.spec


/**
 * Represents a checkbox property specification in a Notion database.
 * This property allows users to toggle between checked and unchecked states,
 * useful for tracking boolean values like completion status or yes/no decisions.
 * 
 * Checkbox properties can be used for filtering and sorting database views,
 * and they support bulk editing of multiple pages at once.
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#checkbox">Checkbox property</a>
 */
interface CheckboxPropertySpec : PropertySpec
