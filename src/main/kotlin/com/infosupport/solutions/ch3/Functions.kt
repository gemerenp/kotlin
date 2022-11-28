package com.infosupport.solutions.ch3

// 1.
// a)
fun <T> List<T>.appendAndSort(other: List<T>) where T : Comparable<T> =
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
infix fun List<String>.headTail(other: List<String>): Pair<String, String> {
    if (size >= 2) return first() to last()
    else throw IllegalAccessException("Size must be >= 2.")
}

infix fun <T> List<T>.ans(list: List<T>): List<T> where T : Comparable<T> {
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
    println(listOf("z", "y", "x") ans listOf("c", "b", "a"))
    println(listOf(4, 3) ans listOf(2, 1))

    // 2d
    println(listOf("p", "q", "r") headTail listOf("f", "e", "d"))
}

// 2.
// See Atomic Kotlin
