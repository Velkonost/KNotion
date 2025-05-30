package com.velkonost.knotion.internal.api.model.page.block

import kotlinx.serialization.Serializable

/**
 * Internal API model representing an equation block in a Notion page.
 * Equation blocks are used to display mathematical expressions using KaTeX syntax.
 * 
 * This class is used internally for serialization/deserialization of equation blocks
 * when communicating with the Notion API. For public usage, see [EquationBlock].
 * 
 * @see EquationBlock
 * @see <a href="https://developers.notion.com/reference/block#equation-blocks">Equation blocks</a>
 */
@Serializable
internal data class ApiBlockEquation(
    /**
     * The mathematical expression in KaTeX syntax.
     * This can include various mathematical symbols, functions, and operators
     * supported by the KaTeX library.
     * 
     * Example: "E = mc^2" or "\\frac{-b \\pm \\sqrt{b^2-4ac}}{2a}"
     */
    val expression: String,
)
