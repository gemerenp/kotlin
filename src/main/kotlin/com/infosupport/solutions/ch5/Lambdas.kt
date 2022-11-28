package com.infosupport.solutions.ch5

import com.infosupport.demos.ch5.lambdas.fibonacci

fun main() {
    rewriteUsingApply()
    rewriteUsingWith()
    rewriteUsingNestedWith()

    println(createFiboSlow(11).joinToString())
    println(createFiboFaster(100).joinToString())

    println(squares().takeWhile { it <= 100 }.toList())
}

// 1a. Rewrite the following using an apply {...} block.
fun rewriteUsingApply() {
    mutableListOf<String>().apply {
        add("one")
        add("two")
        add("three")
        println(this)
    }
}

// 1b. Rewrite the following using a with {...} block.
fun rewriteUsingWith() {
    with(mutableListOf<String>()) {
        add("one")
        add("two")
        add("three")
        println(this)
    }
}

// 2. Rewrite the following piece of code using nested with {...} blocks.
fun rewriteUsingNestedWith() {
    // Option 1: sb -> list
    with(StringBuilder()) sb@{
        with(mutableListOf("one", "two", "three")) {
            append("The first element is ${first()},") // the closest `this`, so the list
            append(" the last element is ${last()}")
            println(this@sb)
        }
    }

    // Option 2: list -> sb
    with(mutableListOf("one", "two", "three")) list@{
        with(StringBuilder()) {
            append("The first element is ${this@list.first()},") // without label, it takes .first() from the inner with, i.e. StringBuilder.first()
            append(" the last element is ${this@list.last()}")
            println(this) // the closest `this`, so the StringBuilder
        }
    }

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
