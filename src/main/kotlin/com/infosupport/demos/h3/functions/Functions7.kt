// Working with pairs: infix calls and destructuring declarations

package com.infosupport.demos.h3.functions

// TODO show
fun main() {
    // Creating pairs
    val one: Pair<Int, String> = 1.to("one") // regular method call
    val seven = 7 to "seven"                 // infix notation
    val twoByFour = 2 by "four"              // infix notation created myself

    // Unpack a pair
    val (num, name) = one                    // destructuring declaration

    // Creating a map of pairs
    val map = mapOf(one, seven, 53 to "fifty-three", twoByFour, num to name)

    // Destructuring with map in a loop
    for ((index, element) in map.entries) {
        // what are index and element here?
        print("[$index, $element] ")
    }

    println()

    for ((index, element) in map.entries.withIndex()) {
        // what are index and element here?
        print("[$index, $element] ")
    }
}

// TODO tell
infix fun Any.by(other: Any) = Pair(this, other)
