package com.infosupport.solutions.h5

import com.infosupport.demos.h5.lambdas.fibonacci
import com.infosupport.labs.h5.rewriteUsingWith

// 1. Rewrite the following piece of code using a with {...} block.
fun rewriteUsingWith() {
    val numbers = mutableListOf("one", "two", "three")
    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    }
    println(firstAndLast)
}

// 2. Rewrite the following using an apply {...} block.
fun rewriteUsingApply() {
    val numbers = mutableListOf<String>().apply {
        add("one")
        add("two")
        add("three")
    }

    println(numbers)
}

fun main() {
    rewriteUsingWith()
    rewriteUsingApply()

    println(createFibo(11).joinToString())
    println(createFibo2(100).joinToString())

    println(squares().takeWhile { it <= 100 }.toList())
}

// 3.
fun fibo(n: Int): Int = if (n <= 2) n else fibo(n - 1) + fibo(n - 2)

// Option 1:
fun createFibo(n: Int): Array<Int?> =
    Array(n) {
        val fibo = fibo(it)
        if (fibo % 2 != 0) fibo else null
    }

// Option 2, much better performance:
fun createFibo2(max: Int): Array<Int?> {
    val fibos = fibonacci().takeWhile { it < max }.toList()

    return Array(fibos.size) { if (fibos.get(it) % 2 != 0) fibos.get(it) else null }
}

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
