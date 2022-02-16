package com.infosupport.demos.h5.lambdas

// Functional APIs for collections

fun main() {
    // These operations are different from Java streams: not lazy, no terminal operation.
    // Kotlin's sequence is like Java's stream.
    // See https://drek4537l1klr.cloudfront.net/jemerov/HighResolutionFigures/figure_5-8.png

    // As a rule, use a sequence whenever you have a chain of operations on a *large* collection.

    // filter, map
    println(people.filter { it.age == 27 }.map { it.name })

    // all, any, count, find
    println(people.all { it.age == 27 })
    println(people.any { it.age == 27 })
    println(people.count { it.age == 27 })
    println(people.find { it.age == 27 })

    // groupBy
    println(people.groupBy { it.age == 27 })
    println(people.groupBy { it.age })

    // map/flatten, flatMap
    // processing nested collections
    println(people.filter { it.age == 27 }.map { it.instruments }) // array of arrays: [[guitar, vocal], [keyboard, vocal], [vocal], [vocal]]
    println(people.filter { it.age == 27 }.map { p -> p.instruments }.flatten()) // array: [guitar, vocal, keyboard, vocal, vocal, vocal]
    println(people.filter { it.age == 27 }.flatMap { p -> p.instruments }) // flatMap = map + flatten!

    // Other highlights:
    val numbers = listOf("one", "two", "three", "four", "five", "six")

    println("partition")
    val (match, rest) = numbers.partition { it.length > 3 }
    println("$match $rest")

    println("slice")
    println(numbers.drop(1).take(3))
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
