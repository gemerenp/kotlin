package com.infosupport.solutions.ch2

// 1.
// a) min
// b) add

fun main() {
    println(min(5))
    println(min(20))
    println(min(100, 2))

    println(add(100))
    println(add(100, 2))
    println(add(1000, 2))
}

fun min(a: Int, b: Int = 10) = if (a < b) a else b

fun add(a: Int, b: Int = 0) =
    if (a + b < 1000)
        """
            ${pad(a)}
            ${pad(b)}
            ----- +
            ${pad(a + b)}
            
        """.trimIndent()
    else
        "Sum is greater than 1000."

private fun pad(i: Int) = i.toString().padStart(5)

// 2.
// See Atomic Kotlin
