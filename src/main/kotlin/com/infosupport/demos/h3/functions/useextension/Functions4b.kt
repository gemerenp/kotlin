// Using an extension function

package com.infosupport.demos.h3.functions.useextension

import com.infosupport.demos.h3.functions.i
import com.infosupport.demos.h3.functions.lastChar

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
