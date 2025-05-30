package com.velkonost.knotion.model.property.spec

/**
 * Represents a files property specification in a Notion database.
 * This property allows users to attach and manage files within database pages.
 * 
 * Files properties support:
 * - Multiple file attachments per property
 * - Various file types (images, documents, PDFs, etc.)
 * - File previews in the database view
 * - File uploads from local storage or external URLs
 * - File management (rename, delete, replace)
 * 
 * Files can be uploaded directly to Notion or linked from external sources.
 * The property can be used for filtering and sorting in database views.
 * 
 * @see PropertySpec
 * @see <a href="https://developers.notion.com/reference/property-object#files">Files property</a>
 */
interface FilesPropertySpec : PropertySpec
