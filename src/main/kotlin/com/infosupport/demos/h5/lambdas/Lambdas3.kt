package com.infosupport.demos.h5.lambdas

import java.util.*
import java.util.concurrent.atomic.AtomicInteger

// Sequences

fun main() {
    // Sequences are like Java streams: lazy, terminal operation needed.

    // Example of a sequence
    people.asSequence()                 // 1. create, like java stream: lazy
        .filter { it.age == 27 }        // 2. perform intermediate operations
        .map { it.instruments }
        .flatten()
        .filter { it.name.length <= 6 } //      stateless
        .take(5)                     //      a bit stateful
        .sortedBy { it.name }           //      stateful
        .forEachIndexed { i, inst ->    // 3. perform ONE terminal operation
            println("Instrument $i = ${inst.name}")
        }

    // For a list of operations, see https://kotlinlang.org/docs/reference/collection-operations.html

    // Some useful stuff:
    val instrumentNamesSeq = people.asSequence().flatMap { it.instruments }.map { it.name }
    val instrumentNamesLst = instrumentNamesSeq.toList()

    println(instrumentNamesSeq.reduce { concat, name -> concat + name })
    println(instrumentNamesSeq.joinToString(" | ") { it })
    println(instrumentNamesSeq.fold(StringJoiner(" | ")) { sj, name -> sj.add(name) })
    println(instrumentNamesLst.foldRight(StringJoiner(" | ")) { name, sj -> sj.add(name) })
    println(instrumentNamesSeq.fold(AtomicInteger(0)) { lengthCount, name -> lengthCount + name.length })
}

operator fun AtomicInteger.plus(other: Int): AtomicInteger {
    addAndGet(other)
    return this
}
