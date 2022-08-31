package com.infosupport.demos.ch6.types

// Collections and arrays: nullability and collections

fun main() {
    nullabilityAndCollections()
}

fun nullabilityAndCollections() {
    // type argument can also be nullable
    val numbers: List<Int?> = listOf(1, null, 42)
    sumOfNonNullNumbers(numbers)
}

fun sumOfNonNullNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull() // convenience method
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid number count: ${numbers.size - validNumbers.size}")
}


