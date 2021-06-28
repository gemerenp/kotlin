package com.infosupport.demos.h2.basics

import java.io.BufferedReader
import java.io.StringReader
import java.util.*

fun main() {
    val treeMap = TreeMap<String, Person>()

    // TODO show loops, ranges and map
    for (c in 'A'..'Z') // range of Char
        for (i in 6 downTo 1 step 2) { // range of Int
            // use in for range check
            if (c in 'A'..'D') {
                val s = c.toString() + i
                treeMap[s] = Person(name = s, isMarried = i % 3 == 0) // like put(c, p) in java
            }

            // use in for range check
            val letters: CharRange = 'A'..'Z'
            val digits = '0'..'9'
            when (c) {
                in letters -> println("It's a letter.")
                in digits -> println("It's a digit.")
                else -> println("It's something else.")
            }
        }

    // TODO show destructuring
    for (entry in treeMap) {
        val (c, person) = entry
        println("$c = $person")
    }

    // ... or shorter:
    for ((c, person) in treeMap) {
        println("$c = $person")
    }

    // or in a loop using .withIndex on collection:
    for ((index, i) in listOf(42, 43, 44).withIndex()) {
        println("""list[$index] = $i.""")
    }

    // TODO show and tell exceptions, try/catch
    // try as a statement, similar to Java:
    try {
        val n1 = readNumber(null)
        println(n1)
    } catch (e: IllegalArgumentException) {
        println("""Exception occurred: ${e.message}.""")
    } finally {
        println("Done")
    }

    // TODO nullable types
    val nullableNumber = readNumber(BufferedReader(StringReader("not a number"))) // param is a nullable BufferedReader
    val dec = nullableNumber?.dec() // safe de-referencing
    println(dec ?: "no number found...") // elvis operator

}

// Basically similar to Java
fun readNumber(reader: BufferedReader?): Int? { // optional Int, i.e. nullable
    if (reader == null) {
        // how to throw an exception:
        throw IllegalArgumentException("reader cannot be null")
    }

    // try as an expression:
    return try {
        val readLine = reader.readLine() // throws IOException, but all exceptions are unchecked in kotlin
        Integer.parseInt(readLine)
    } catch (e: NumberFormatException) {
        null
    }
}
