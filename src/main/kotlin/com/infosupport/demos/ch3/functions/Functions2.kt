// Making functions easier to call.
// - Named arguments
// - Default param values
// - @JvmOverloads

package com.infosupport.demos.ch3.functions

fun main() {

    val list = listOf(1, 2, 3)

    // Pretty prints the list:
    println(list)

    // How to print this list differently?
    // There is a standard function in Kotlin, but first, we make one ourselves:

    // Call classic style.
    println(joinToStringClassic(list, "; ", "(", ")"))

    // Call with named arguments.
    println(joinToStringClassic(list, separator = "; ", prefix = "(", postfix = ")"))

    // Call with default parameter values.
    println(joinToStringDefaultParamValues(list))
    println(joinToStringDefaultParamValues(list, postfix = ";", prefix = "# "))

    // Call the standard function in Kotlin:
    println(list.joinToString())
    println(list.joinToString(separator = " | "))
}

fun <T> joinToStringClassic(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {
    val result = StringBuilder(prefix)

    // Also note: withIndex() combined with destructuring
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

//  @JvmOverloads is optional.
//  It generates Java overloaded methods instead of only one.
//  Makes it easier to call this function from Java; see JvmOverloadsDemo.java.
@JvmOverloads
fun <T> joinToStringDefaultParamValues(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String = joinToStringClassic(collection, separator, prefix, postfix)

// @JvmOverloads
fun <T> joinToStringDefaultParamValuesNoOverloads(
    collection: Collection<T>,
    separator: String? = ", ",
    prefix: String? = "",
    postfix: String? = ""
): String = joinToStringClassic(collection, separator ?: "", prefix ?: "", postfix ?: "")


