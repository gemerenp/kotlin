package com.infosupport.demos.ch2.basics

// loops, ranges and map
// destructuring
// tryCatch
// nullableTypes

import java.io.BufferedReader
import java.io.FileWriter
import java.io.IOException
import java.io.StringReader
import java.util.*

fun main() {
    loopsAndRanges()
    val treeMap = loopsRangesAndMap()
    destructuring(treeMap)
    tryCatch()
    nullableTypes()
}

private fun loopsAndRanges() {
    // a..b is called a "range": something with a start and an end value.
    val intRange = 0..42 // from 0 to (and including) 42
    println(intRange.first)
    println(intRange.last)

    val charRange = 'a'..'z'
    println(charRange.first)
    println(charRange.last)

    // We can use a range to iterate over, or to check something:
    // - Check:
    val x = Random().nextInt(0, 100)
    if (x in intRange) {
        println("$x is between 0 and 42!")
    }

    // - Iterate:
    //   In kotlin we have only one type of for loop, and it goes like this:
    for (i in 1..9) {
        print(i)
    }

    // We iterate over a `progression`, which is a "range" with a "step" (default step is 1)
    for (i in 1..9 step 2) {
        print(i)
    }

    // other progressions:
    show(1 until 9) // excluding 9
    show(9 downTo 1)
    show(9 downTo 1 step 2)
}

private fun show(ip: IntProgression) {
    for (i in ip) {
        println(i)
    }
}

private fun loopsRangesAndMap(): TreeMap<String, Person> {
    // Example combining loops, ranges, `in`, and map creation:

    val treeMap = TreeMap<String, Person>()
    for (c in 'A'..'Z') // range of Char
        for (i in 6 downTo 1 step 2) { // range of Int
            // use `in` for range check with `if`
            if (c in 'A'..'D') {
                val name = c.toString() + i // some random string
                val p = Person(name, isMarried = i % 3 == 0) // some random person
                treeMap[name] = p // like treeMap.put(name, p) in java
            }

            // use `in` for range check with `when`
            when (c) {
                in 'A'..'Z' -> println("It's a letter.")
                in '0'..'9' -> println("It's a digit.")
                else -> println("It's something else.")
            }
        }

    return treeMap
}

data class Course(val id: Int, val name: String)

private fun destructuring(map: TreeMap<String, Person>) {
    // In Kotlin, we can do the inverse of constructing.
    val k = Course(10, "Kotlin") // constructing: put values into object
    val (id, cName) = k          // destructuring: extract values from object

    // We can do the same with map entries:
    for (entry in map) {
        val (name, person) = entry
        println("$name = $person")
    }

    // ... or shorter:
    for ((name, person) in map) {
        println("$name = $person")
    }

    // ... or in a loop using .withIndex on a collection:
    for ((index, i) in listOf(42, 43, 44).withIndex()) {
        println("list[$index] = $i.")
    }
}

private fun tryCatch() {
    tryAsAStatement()
    tryAsAnExpression()
    tryWithResources()
}

private fun tryAsAStatement(): Int? {
    // similar to Java, can become cumbersome...
    var result: Int?
    try {
        val n1 = readNumber(null)
        println(n1)
        result = n1
    } catch (e: IllegalArgumentException) {
        println("""Exception occurred: ${e.message}.""")
        result = null
    } finally {
        println("Done")
    }
    return result
}

private fun tryAsAnExpression(): Int? {
    // more concise:
    return try {
        val n1 = readNumber(null)
        println(n1)
        n1   // return value of try
    } catch (e: IllegalArgumentException) {
        println("""Exception occurred: ${e.message}.""")
        null // return value of catch
    } finally {
        println("Done")
    }
}

@Throws(IOException::class) // for other JVM-languages using "checked" exceptions, like Java
fun tryWithResources() {
    val writer = FileWriter("test.txt")
    writer.use {
        it.write("something")
    }
    // writer automatically closed
}

private fun nullableTypes() {
    val nullableNumber = readNumber(BufferedReader(StringReader("not a number"))) // param is a nullable BufferedReader
    val dec = nullableNumber?.dec() // safe de-referencing
    println(dec ?: "no number found...") // elvis operator
}

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
        e.printStackTrace()
        null
    }
}

// Lab 2 (select some)
