package com.infosupport.labs.h5

// 1. Select some (or all) of the following exercises from Atomic Kotlin (start with one of each subject):
//    Functional Programming            Exercise
//      - Lambdas                       1, 2, 3
//      - The Importance of Lambdas     1, 2, 3
//      - Operations on Collections     1, 2, 3
//      - Member References             1, 2
//      - Sequences                     1, 2, 7

// 2. Rewrite the following piece of code using a with {...} block.
fun rewriteUsingWith() {
    val numbers = mutableListOf("one", "two", "three")
    var firstAndLast = ""
    firstAndLast += "The first element is ${numbers.first()},"
    firstAndLast += " the last element is ${numbers.last()}"
    println(firstAndLast)
}

// 3. Rewrite the following using an apply {...} block.
fun rewriteUsingApply() {
    val numbers = mutableListOf<String>()
    numbers.add("one")
    numbers.add("two")
    numbers.add("three")

    println(numbers)
}

fun main() {
    rewriteUsingWith()
    rewriteUsingApply()
}
