package com.infosupport.solutions.h6

import com.infosupport.demos.h5.lambdas.fibonacci

// 1.
// See Atomic Kotlin

// 2.
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

fun main() {
    println(createFibo(11).joinToString())
    println(createFibo2(100).joinToString())
}
