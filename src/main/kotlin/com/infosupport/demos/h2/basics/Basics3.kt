package com.infosupport.demos.h2.basics

// loops, ranges and map
// destructuring
// tryCatch
// nullableTypes

import java.io.BufferedReader
import java.io.StringReader
import java.util.*

fun main() {
    // loops, ranges and map
    basics()
    val treeMap = combined()

    destructuring(treeMap)

    tryCatch()

    nullableTypes()
}

private fun basics() {
    show(1..9)
    println("---")
    show(1 until 9)
    println("---")
    show(9 downTo 1)
    println("---")
    show(1..9 step 2)
    println("---")

    println((1..9 step 3).first)
    println((1..9 step 5).last)
}

private fun show(p: IntProgression) = p.forEach(::println)

private fun combined(): TreeMap<String, Person> {
    val treeMap = TreeMap<String, Person>()
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
    return treeMap
}

private fun destructuring(treeMap: TreeMap<String, Person>) {
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
        println("list[$index] = $i.")
    }
}

private fun tryCatch(): Int? {
    // try as a statement, similar to Java:
    return try {
        val n1 = readNumber(null)
        println(n1)
        n1
    } catch (e: IllegalArgumentException) {
        println("""IllegalArgumentException occurred: ${e.message}.""")
        null
    } finally {
        println("Done")
    }
}

private fun nullableTypes() {
    val nullableNumber = readNumber(BufferedReader(StringReader("not a number"))) // param is a nullable BufferedReader
    val dec = nullableNumber?.dec() // safe de-referencing
    println(dec ?: "no number found...") // elvis operator
}

// Basically similar to Java
private fun readNumber(reader: BufferedReader?): Int? { // optional Int, i.e. nullable
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
