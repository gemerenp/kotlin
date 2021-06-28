package com.infosupport.demos.h5.lambdas

// Functional APIs for collections

// TODO show and tell
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
    println(people.filter { it.age == 27 }.map { it.instruments }.flatten()) // array: [guitar, vocal, keyboard, vocal, vocal, vocal]
    println(people.filter { it.age == 27 }.flatMap { it.instruments }) // flatMap = map + flatten!
}
