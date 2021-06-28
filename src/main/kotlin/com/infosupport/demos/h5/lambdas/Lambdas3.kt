package com.infosupport.demos.h5.lambdas

// Sequences

// TODO show and tell
fun main() {
    // Sequences are like Java streams: lazy, terminal operation needed.

    // Example of a sequence
    people.asSequence()                 // 1. create, like java stream: lazy
        .filter { it.age == 27 }        // 2. perform intermediate operations
        .map { it.instruments }
        .flatten()
        .filter { it.name.length <= 6 }
        .forEachIndexed { i, inst ->    // 3. perform ONE terminal operation
            println("Instrument $i = ${inst.name}")
        }

    // For a list of operations, see https://kotlinlang.org/docs/reference/collection-operations.html

    // Highlights:
    val numbers = listOf("one", "two", "three", "four", "five", "six")

    println("partition")
    val (match, rest) = numbers.partition { it.length > 3 }
    println("$match $rest")

    println("slice")
    println(numbers.slice(1..3))
    println(numbers.slice(0..4 step 2))
    println(numbers.slice(setOf(3, 5, 0)))

    println("take and drop")
    println(numbers.take(3))
    println(numbers.takeLast(3))
    println(numbers.drop(1))
    println(numbers.dropLast(5))
    println(numbers.takeWhile { !it.startsWith('f') })
    println(numbers.takeLastWhile { it != "three" })
    println(numbers.dropWhile { it.length == 3 })
    println(numbers.dropLastWhile { it.contains('i') })

    println("chunked")
    println(numbers.chunked(3))

    println("windowed")
    println(numbers.windowed(3))

    println("zipWithNext")
    println(numbers.zipWithNext())

    println("ordering")
    println(numbers.sorted())
    println(numbers.shuffled())
    println(numbers.reversed())
}
