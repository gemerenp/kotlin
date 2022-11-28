package com.infosupport.labs.ch5

fun main() {
    rewriteUsingApply()
    rewriteUsingWith()
    rewriteUsingNestedWith()
}

// 1a. Rewrite the following using an apply {...} block.
fun rewriteUsingApply() {
    val numbers = mutableListOf<String>()
    numbers.add("one")
    numbers.add("two")
    numbers.add("three")

    println(numbers)
}

// 1b. Rewrite the following using a with {...} block.
fun rewriteUsingWith() {
    val numbers = mutableListOf<String>()
    numbers.add("one")
    numbers.add("two")
    numbers.add("three")

    println(numbers)
}

// 2. Rewrite the following using nested with {...} blocks.
fun rewriteUsingNestedWith() {
    val numbers = mutableListOf("one", "two", "three")
    val firstAndLast = StringBuilder()
    firstAndLast.append("The first element is ${numbers.first()},")
    firstAndLast.append(" the last element is ${numbers.last()}")
    println(firstAndLast)
}

// 3. Create and show an array of fibonacci numbers, but when the number is even, put null in the array.
//    Example: [null, 1, 1, null, 3, 5, null, 13, 21, null, 55, 89] for all numbers <= 100.
//    To find the n-th fibonacci number, you can use the previously given sequence
//    com.infosupport.demos.h5.lambdas.fibonacci() or use the recursive function below.
//    Please think about the efficiency of your algorithm!

fun fibo(n: Int): Int = if (n <= 2) n else fibo(n - 1) + fibo(n - 2)

// 4. Create a sequence for the following series of numbers: [0, 1, 4, 9, 16, 25, ..., n^2].

// 5. Select some (or all) of the following exercises from Atomic Kotlin (start with one of each subject):
//    Functional Programming             Exercise
//      a) Lambdas                       1, 2, 3
//      b) The Importance of Lambdas     1, 2, 3
//      c) Operations on Collections     1, 2, 3
//      d) Member References             1, 2
//      e) Sequences                     1, 2, 7
