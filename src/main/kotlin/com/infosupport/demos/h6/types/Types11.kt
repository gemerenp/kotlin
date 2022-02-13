package com.infosupport.demos.h6.types

import kotlin.math.pow

// Collections and arrays: arrays

// TODO show and tell
fun main(args: Array<String>) {
    // An array is a class with a type parameter.
    // Working with them is as simple as working with collections.

    processArray(args)

    createAndPrintArray()
}

fun processArray(args: Array<String>) {
    if (args.isNotEmpty()) {
        println(args[0])
        println(args.get(0))
        println(args.sortedArray())
        // etc. etc.
    }

    for (arg in args) {
        println(arg)
    }

    for (i in args.indices) {
        println(i)
    }

    for ((i, e) in args.withIndex()) {
        println("$i, $e")
    }

    args.forEachIndexed { i, e -> println("$i, $e") }
}

fun createAndPrintArray() {
    // 1. arrayOf
    val arrayOf = arrayOf(1, 2, 3)
    arrayOf.forEachIndexed { index, element -> println("Argument $index is: $element") }

    // 2. arrayOfNulls
    val arrayOfNulls = arrayOfNulls<Int?>(3)
    for (i in arrayOfNulls.indices) {
        arrayOfNulls[i] = if (i % 2 != 0) i else null
    }
    println(arrayOfNulls.contentToString())

    // 3. Array(size) { init: (Int) -> T }
    val letters = Array(26) { ('a' + it).toString() }
    println(letters.joinToString(", "))

    // 4. list.toTypedArray() and spread
    val strings = listOf("a", "b", "c").toTypedArray()
    printVarargString(*strings) // spread strings to pass as vararg

    // 5. Array of primitives
    // Array<T> always becomes an array of a reference type.
    // If you want array of primitive, use specializes functions:
    val fiveZeros = IntArray(5) // ..or ByteArray, LongArray, ... etc.
    val fiveZerosToo = intArrayOf(0, 0, 0, 0, 0)
    val squares = IntArray(5) { (it + 1f).pow(2).toInt() }
}

private fun printVarargString(vararg strings: String) {
    println(strings.joinToString(" * "))
}

