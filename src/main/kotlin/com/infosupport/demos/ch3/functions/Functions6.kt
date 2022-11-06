// vararg and spread operator

package com.infosupport.demos.ch3.functions

fun main() {
    val array = arrayOf(1, 2, 3)
    val list = listOf(1, 2, 3)

    // use vararg
    print(array)
    print(array, "A", "B")
    print(array, "A", "B", "C", "D")

    // You can spread the contents of a vararg with *, see fun print below.
    // But, you cannot spread the contents of a _list_ like this:
    //   println(listOf("list spread: ", *list))
    // Instead you do it like this:
    println(listOf("list spread: ", *list.toTypedArray()))

    // More idiomatic is:
    println(listOf("list spread: ") + list)
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

// Lab 2d
