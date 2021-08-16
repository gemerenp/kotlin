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

    // you can't pass the array, like in Java
    println(listOf("args: ", args, "!"))
    println(listOf("letters: ", letters, "!"))

    // you have to use spread operator as vararg argument
    println(listOf("args spread: ", *args, "!")) // spread unpacks the array contents
    println(listOf("letters spread: ", *letters, "!"))
}

