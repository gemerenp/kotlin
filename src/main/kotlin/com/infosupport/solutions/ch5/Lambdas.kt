package com.infosupport.solutions.ch5

import com.infosupport.demos.ch5.lambdas.fibonacci

// 1. Rewrite the following piece of code using a with {...} block.
fun rewriteUsingWith() {
    val numbers = mutableListOf("one", "two", "three")
    with(numbers) {
        "The first element is ${first()}," +
                " the last element is ${last()}"
        println(this)
    }
}

// 2. Rewrite the following using an apply {...} block.
fun rewriteUsingApply() {
    mutableListOf<String>().apply {
        add("one")
        add("two")
        add("three")
        println(this)
    }
}

fun main() {
    rewriteUsingWith()
    rewriteUsingApply()

    println(createFiboSlow(11).joinToString())
    println(createFiboFaster(100).joinToString())

    println(squares().takeWhile { it <= 100 }.toList())
}

// 3.
fun fibo(n: Int): Int = if (n <= 2) n else fibo(n - 1) + fibo(n - 2)

// Option 1:
fun createFiboSlow(n: Int): Array<Int?> =
    Array(n) {
        val fibo = fibo(it)
        if (fibo % 2 != 0) fibo else null
    }

// Option 2, much better performance:
fun createFiboFaster(max: Int) =
    fibonacci()
        .takeWhile { it < max }
        .toList()
        .map { if (it % 2 != 0) it else null }

// 4.
fun squares() = sequence {
    var n = 0
    while (true) {
        yield(n * n)
        n++
    }
}

// 5.
// See Atomic Kotlin
