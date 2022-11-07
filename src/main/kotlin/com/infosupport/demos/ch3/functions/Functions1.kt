// Creating collections

package com.infosupport.demos.ch3.functions

val set = setOf(1, 7, 53)
val hashSet = hashSetOf(1, 7, 53)
val list = listOf(1, 7, 53)
val arrayList = arrayListOf(1, 7, 53)
val mutList = mutableListOf(1, 7, 53)
val hashMap = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")  // Note: 'to' is a normal function!

fun main() {
    println("------- TYPES --------") // .javaClass == getClass() from Java
    println(set.javaClass)            // class java.util.LinkedHashSet
    println(hashSet.javaClass)        // class java.util.HashSet
    println(list.javaClass)           // class java.util.Arrays$ArrayList, immutable
    println(arrayList.javaClass)      // class java.util.ArrayList
    println(mutList.javaClass)        // class java.util.ArrayList
    println(hashMap.javaClass)        // class java.util.HashMap

    // Interoperability:
    // - Kotlin doesn’t have its own set of collection classes.
    // - All of your existing knowledge about Java collections still applies here.
    // - But, you can do a lot more with kotlin collections than java collections:

    println("------- METHODS --------")
    println(set.minus(1))
    println(hashSet.minus(arrayOf(1, 53)))
    println(hashSet.maxByOrNull { it })
    println(list.asReversed())
    println(arrayList.last())
    println(hashMap.any())
    // ... and much more
}

