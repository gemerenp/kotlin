// vararg

package com.infosupport.demos.h3.functions

// TODO show and tell
fun main() {
    val args = arrayOf(1, 2, 3)

    // use vararg
    print(args, "A", "B", "C", "D")
    print(args)
    print(args, "A", "B")
}

fun print(args: Array<Int>, vararg letters: String) { // declare vararg parameter; in Java: String...letters

    // You can pass the array, like in Java, but that leads to other results than in Java:
    println(listOf("args: ", args))
    println(listOf("letters: ", letters))

    // Instead, use the spread operator to convert array to vararg argument
    println(listOf("args spread: ", *args)) // spread unpacks the array contents
    println(listOf("letters spread: ", *letters))
}

