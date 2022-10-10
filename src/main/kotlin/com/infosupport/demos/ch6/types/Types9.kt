package com.infosupport.demos.ch6.types

// Collections and arrays:
// - read-only and mutable collections
// - Kotlin collections and Java

fun main() {
    mutabilityAndJava()
}

fun mutabilityAndJava() {
    // kotlin collections are immutable by default
    val immutableList = listOf("a", "b", "c")
    val mutableList = mutableListOf("x", "y", "z")

    // ⚡⚡⚡ Danger when interop-ing with Java ⚡⚡⚡
    printInUpperCase(immutableList)

    // So under the hood, a Kotlin immutable list is a Java mutable list.
    // No conversion is needed from/to Java.
    // Kotlin's List interface just doesn't have mutation methods.
    // But every Java collection interface has two _representations_ in Kotlin:
    // https://drek4537l1klr.cloudfront.net/jemerov/Figures/06fig13_alt.jpg

    // Code above is risky. Safer is to explicitly specify mutability type:
    // printInUpperCaseSafer(immutableList) // does not compile
    printInUpperCaseSafer(mutableList)

}

private fun printInUpperCase(list: List<String>) {
    // Immutable Kotlin list is mutated anyway in Java...!
    // So read-only isn't always thread safe!
    JavaCollectionUtils.uppercaseAll(list) // note: JavaCollectionUtils.java can be found in src/main/java/...
    println(list)
}

private fun printInUpperCaseSafer(mutableList: MutableList<String>) { // note MutableList here
    // MutableList is thread safe.
    JavaCollectionUtils.uppercaseAll(mutableList)
    println(mutableList)
}

