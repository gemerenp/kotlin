package com.infosupport.solutions.h5

import com.infosupport.labs.h5.rewriteUsingWith

// 1.
// See Atomic Kotlin

// 2. Rewrite the following piece of code using a with {...} block.
fun rewriteUsingWith() {
    val numbers = mutableListOf("one", "two", "three")
    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    }
    println(firstAndLast)
}

// 3. Rewrite the following using an apply {...} block.
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
}
