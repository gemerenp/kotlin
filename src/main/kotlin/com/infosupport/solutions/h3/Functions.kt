package com.infosupport.solutions.h3

// 1.
// See Atomic Kotlin

// 2.
// a)
fun List<String>.appendAndSort(other: List<String>) =
    this.plus(other).sorted() //  or one of these ways:
//  (this + other).sorted()
//  listOf(this, other).flatten().sorted()
//  listOf(*this.toTypedArray(), *other.toTypedArray()).sorted()

// b)
val List<String>.headTail: Pair<String, String>
    get() {
        if (size >= 2) return first() to last()
        else throw IllegalAccessException("Size must be >= 2.")
    }

// c)
infix fun List<String>.ans(list: List<String>): List<String> {
    return this.appendAndSort(list)
}

fun main() {
    // 2a
    println(listOf("z", "y", "x").appendAndSort(listOf("c", "b", "a")))

    // 2b
    println(listOf("z", "y", "x").headTail)
    println(listOf("z", "y").headTail)

    try {
        println(listOf("z").headTail)
    } catch (e: IllegalAccessException) {
        println(e.message)
    }

    // 2c
    println(listOf("p", "q", "r") ans listOf("f", "e", "d"))
}
