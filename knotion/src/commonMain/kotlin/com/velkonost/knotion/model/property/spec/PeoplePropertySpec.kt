package com.velkonost.knotion.model.property.spec

/**
 * Represents a people property specification in a Notion database.
 * This property allows users to assign and track people (users) associated with pages,
 * such as owners, assignees, or team members.
 * 
 * People properties support:
 * - Multiple people assignments
 * - User mentions and references
 * - User avatars and information
 * - Filtering and sorting by assigned people
 * - Integration with workspace user management
 * 
 * Common use cases include:
 * - Task assignment
 * - Team member tracking
 * - Responsibility management
 * - User-based filtering
 * - Team collaboration
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#people">People property</a>
 */
interface PeoplePropertySpec : PropertySpec
