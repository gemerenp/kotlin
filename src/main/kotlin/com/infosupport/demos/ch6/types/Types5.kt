package com.infosupport.demos.ch6.types

// Primitives and other basic types: primitives

fun main() {
    // In Java you have primitive and reference types.
    // Primitives can be passed around more efficiently, but you can't
    // call methods on them or use them as generic type argument.

    // In Kotlin there's no distinction between primitive and reference, for example:
    val i: Int = 1
    val list: List<Int> = listOf(1, 2, 3) // use Int as type argument

    // You can always call methods on Ints:
    var h = i.dec()
    println("h=${h}")
    println("i=${i}")

    // You can pass an Int to a method:
    inc(i) // passed by value???
    println("i=${i}")

    repeat(42) { h = h.inc() }
    showProgress(h)

    repeat(1337) { h = h.inc() }
    showProgress(h)

    // If primitive and reference types are the same, does that mean Kotlin
    // represents all numbers as objects? Wouldn’t that be terribly inefficient?
    // Indeed it would, so Kotlin doesn’t do that.

    // At runtime, the (non nullable) number types are represented in the most efficient way
    // possible:
    // - most cases:            Int -> int
    // - generic type argument: Int -> Integer

    // These are the types corresponding to Java primitives:
    // Integer types                Byte, Short, Int, Long
    // Floating-point number types  Float, Double
    // Character type               Char
    // Boolean type                 Boolean

    // They all can be nullable as well, for example:
    val fuzzy: Boolean? = // true, false or null
        if (person.company != null) person.company.name.length > 10 else null

    // Nullable types are converted to java's wrapper under the hood, since primitives can't hold null.
}

fun inc(i: Int) {
    i.inc()
}

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}

