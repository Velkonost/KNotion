# Knotion

A Kotlin Multiplatform library for interacting with the Notion API. Knotion provides a type-safe, idiomatic Kotlin interface to Notion's powerful API, making it easy to integrate Notion into your Kotlin applications.

## Features

- **Kotlin Multiplatform Support**: Works on JVM, JS, and Native platforms
- **Type-Safe API**: Full Kotlin type system support for all Notion API types
- **Coroutines Support**: Asynchronous operations using Kotlin coroutines
- **Serialization**: Built-in support for JSON serialization/deserialization
- **Property System**: Rich type system for Notion's property types
- **Block System**: Support for all Notion block types
- **Database Operations**: Full CRUD operations for databases and pages
- **User Management**: Workspace user and bot management
- **Search**: Advanced search capabilities across workspaces

## Installation

### Gradle (Kotlin DSL)

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.velkonost:knotion:1.0.0")
}
```

### Gradle (Groovy)

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.velkonost:knotion:1.0.0'
}
```

## Quick Start

1. Create a Notion integration and get your API key:
   - Go to https://www.notion.so/my-integrations
   - Click "New integration"
   - Give it a name and select the workspace
   - Copy the "Internal Integration Token"

2. Initialize the client:

```kotlin
val notionClient = KNotion.setupClient(
    accessToken = "your_integration_token"
)
```

3. Start using the API:

```kotlin
// Create a new page
val page = notionClient.pages.createPage(
    parentDatabase = DatabaseReference("database_id"),
    properties = PropertyValueList().apply {
        title("Name", "My New Page")
        number("Price", 99.99)
        select("Status", "In Progress")
        multiSelect("Tags", "Important", "Urgent")
    }
)

// Query a database
val database = notionClient.databases.query(
    databaseId = "database_id",
    filter = Filter.and(
        Filter.property("Status", Filter.Select.equals("Done")),
        Filter.property("Price", Filter.Number.greaterThan(50))
    ),
    sorts = listOf(
        Sort.property("Last edited time", Sort.Direction.descending)
    )
)
```

## Core Concepts

### Property System

Knotion provides a rich type system for Notion's property types:

- **Basic Properties**: Title, Rich Text, Number, Select, Multi-select, Date, People, Files, Checkbox, URL, Email, Phone
- **Advanced Properties**: Formula, Relation, Rollup, Created time, Created by, Last edited time, Last edited by
- **Property Values**: Type-safe value objects for each property type
- **Property Specifications**: Define property types and their configurations

Example:
```kotlin
// Create a database with properties
val database = notionClient.databases.createDatabase(
    parent = PageParent("page_id"),
    title = "My Database",
    properties = mapOf(
        "Name" to TitlePropertySpec(),
        "Status" to SelectPropertySpec(
            options = listOf(
                SelectOption("Not Started", Color.DEFAULT),
                SelectOption("In Progress", Color.BLUE),
                SelectOption("Done", Color.GREEN)
            )
        ),
        "Price" to NumberPropertySpec(
            format = NumberFormat.DOLLAR
        )
    )
)
```

### Block System

Work with Notion's block-based content system:

- **Block Types**: Paragraph, Heading, Bulleted list, Numbered list, To-do, Toggle, Code, Image, etc.
- **Block Operations**: Create, update, delete, and append blocks
- **Block Children**: Navigate and manipulate block hierarchies

Example:
```kotlin
// Create a page with blocks
val page = notionClient.blocks.createBlock(
    parent = PageParent("page_id"),
    blocks = listOf(
        ParagraphBlock("Welcome to my page!"),
        Heading1Block("Main Section"),
        BulletedListItemBlock("First item"),
        BulletedListItemBlock("Second item"),
        CodeBlock("println('Hello, World!')", language = "kotlin")
    )
)
```

### Database Operations

Full support for database operations:

- **Create**: Create new databases with custom properties
- **Query**: Filter, sort, and paginate database contents
- **Update**: Modify database structure and properties
- **Retrieve**: Get database information and contents

Example:
```kotlin
// Query with complex filters
val results = notionClient.databases.query(
    databaseId = "database_id",
    filter = Filter.and(
        Filter.property("Status", Filter.Select.equals("In Progress")),
        Filter.or(
            Filter.property("Priority", Filter.Select.equals("High")),
            Filter.property("Due Date", Filter.Date.before("2024-12-31"))
        )
    ),
    sorts = listOf(
        Sort.property("Created time", Sort.Direction.ascending)
    ),
    pageSize = 100
)
```

### Search

Powerful search capabilities:

- **Full-Text Search**: Search across all content
- **Filtered Search**: Search within specific databases or pages
- **Sorted Results**: Sort search results by relevance or other criteria

Example:
```kotlin
// Search across workspace
val searchResults = notionClient.search(
    query = "important project",
    filter = SearchFilter(
        property = "object",
        value = "page"
    ),
    sort = SearchSort(
        direction = Sort.Direction.descending,
        timestamp = "last_edited_time"
    )
)
```

## Error Handling

Knotion provides comprehensive error handling:

```kotlin
try {
    val page = notionClient.pages.retrieve("page_id")
} catch (e: NotionClientException) {
    when (e) {
        is NotionClientRequestException -> {
            // Handle API request errors (400, 401, 403, etc.)
            println("Request failed: ${e.message}")
        }
        is NotionClientResponseException -> {
            // Handle API response errors
            println("Response error: ${e.message}")
        }
        else -> {
            // Handle other errors
            println("Unexpected error: ${e.message}")
        }
    }
}
```

## Best Practices

1. **API Key Security**:
   - Never commit API keys to version control
   - Use environment variables or secure configuration management
   - Rotate keys regularly

2. **Rate Limiting**:
   - Implement retry logic for rate-limited requests
   - Use appropriate timeouts
   - Cache frequently accessed data

3. **Error Handling**:
   - Always handle potential exceptions
   - Implement proper logging
   - Use appropriate fallback strategies

4. **Resource Management**:
   - Close clients when no longer needed
   - Use appropriate pagination
   - Implement proper cleanup

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Acknowledgments

- [Notion API Documentation](https://developers.notion.com)
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)
- [Ktor](https://ktor.io)
