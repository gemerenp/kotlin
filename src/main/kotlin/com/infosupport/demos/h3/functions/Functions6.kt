// vararg

package com.infosupport.demos.h3.functions

// TODO show and tell
fun main() {
    val array = arrayOf(1, 2, 3)
    val list = listOf(1, 2, 3)

    // use vararg
    print(array)
    print(array, "A", "B")
    print(array, "A", "B", "C", "D")

    // You cannot spread the contents of a list like this:
    // println(listOf("list spread: ", *numbers))
    // You do it like this:
    println(listOf("list spread") + list)
}

fun print(array: Array<Int>, vararg varargString: String) { // declare vararg parameter; in Java: String...letters

    // You can pass the array, like in Java, but that leads to other results than in Java:
    println(listOf("array", array))
    println(listOf("varargString", varargString))

    // Instead, use the spread operator to convert array to vararg argument:
    println(listOf("*array", *array)) // spread unpacks the array contents
    println(listOf("*varargString", *varargString))

    println()
}

