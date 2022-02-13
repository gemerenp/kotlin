// Using an extension function

package com.infosupport.demos.h3.functions.useextension

// TODO tell: you have to import extension function and properties in order to use them
import com.infosupport.demos.h3.functions.i
import com.infosupport.demos.h3.functions.lastChar

// TODO show
fun main() {
    val s = "Kotlin"
    println(s.lastChar())
    println(i)

    // In Kotlin API:
    println(s.last())
    println(s.drop(2))
    println(s.dropLast(2))
    println(s.padStart(5 + s.length))
    // ... and a lot more!
}
