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

}
