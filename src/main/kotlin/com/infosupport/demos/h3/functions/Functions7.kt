// Working with pairs: infix calls and destructuring declarations

package com.infosupport.demos.h3.functions

// TODO show
fun main() {
    // Creating pairs
    val zero = Pair(0, "zero")               // regular ctor call
    val one: Pair<Int, String> = 1.to("one") // regular method call
    val seven = 7 to "seven"                 // infix notation
    val twoByFour = 2 by "four"              // infix notation created myself

    // Unpack a pair
    val (num, name) = one                    // destructuring declaration

    // Creating a map of pairs
    val map = mapOf(zero, one, seven, 53 to "fifty-three", twoByFour, num to name)

    // Destructuring with map in a loop
    for ((key, value) in map.entries) {
        // what are index and element here?
        print("[$key, $value] ")
    }

    println()

    for ((index, element) in map.entries.withIndex()) {
        // what are index and element here?
        // print("[$index, $element] ")

        // no nested destructuring available, do it in a separate statement:
        val (k, v) = element
        print("[$index, ($k, $v)] ")
    }
}

// TODO tell
infix fun Any.by(other: Any) = Pair(this, other)
