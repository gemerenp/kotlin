// vararg and spread operator

package com.infosupport.demos.ch3.functions

fun main() {
    val array = arrayOf(1, 2, 3)
    val list = listOf(1, 2, 3)

    // use vararg
    print(array)
    print(array, "", "A", "BB")
    print(array, "", "A", "BB", "CCC", "DDDD")

    // You can spread the contents of a vararg with *, see fun print below.
    // But, you cannot spread the contents of a _list_ like this:
    //   println(listOf("list spread", *list))
    // Instead you do it like this:
    println(listOf("list spread", *list.toTypedArray()))
}

fun print(array: Array<Int>, vararg varargString: String) { // declare vararg parameter; in Java: String... varargString

    // vararg behaves like an array:
    array.size
    array[0]
    array.binarySearch("A")

    varargString.size
    varargString[0]
    varargString.binarySearch("A")
    // etc.


    // You can pass the array, like in Java, but that leads to other results than in Java:
    println(listOf("array", array))
    println(listOf("varargString", varargString))

    // Instead, use the spread operator to convert array to vararg argument:
    println(listOf("*array", *array)) // spread unpacks the array contents
    println(listOf("*varargString", *varargString))

    println("Processing the varargString:")
    // imperative style
    for (s in varargString) {
        if (s.isNotBlank()) {
            val len = s.length * 2
            println(len)
        }
    }

    // functional style
    varargString
        .filter { s -> s.isNotBlank() }
        .map { s -> s.length * 2 }
        .forEach { println(it) }
}

// Lab 2d
