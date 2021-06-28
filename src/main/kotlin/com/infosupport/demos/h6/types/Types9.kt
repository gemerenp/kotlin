package com.infosupport.demos.h6.types

// Collections and arrays:
// - read-only and mutable collections
// - Kotlin collections and Java

fun main() {
    mutabilityAndJava()
}

fun mutabilityAndJava() {
    // kotlin collections are immutable
    val immutableList: List<String> = listOf("a", "b", "c")

    // Danger when interop-ing with Java!
    printInUpperCase(immutableList)
    // java.util.List is mutable
    // immutable Kotlin list is mutated anyway in Java...!
    // Read-only isn't always thread safe!

    // So under the hood, a Kotlin immutable list is a Java mutable list.
    // No conversion is needed from/to Java.
    // Kotlin's List interface just doesn't have mutation methods.
    // But every Java collection interface has two _representations_ in Kotlin:
    // https://drek4537l1klr.cloudfront.net/jemerov/Figures/06fig13_alt.jpg

    // Code above is risky. Better is to explicitly specify mutability type:
    // toUpperCaseAndPrint(immutableList) // does not compile
    val mutableList = mutableListOf("x", "y", "z")
    toUpperCaseAndPrint(mutableList)
    println(mutableList)
}

private fun printInUpperCase(list: List<String>) {
    CollectionUtils.uppercaseAll(list) // note: CollectionUtils.java can be found in src/main/java/...
    println(list)
}

private fun toUpperCaseAndPrint(mutableList: MutableList<String>) { // note MutableList here
    CollectionUtils.uppercaseAll(mutableList)
    println(mutableList)
}

