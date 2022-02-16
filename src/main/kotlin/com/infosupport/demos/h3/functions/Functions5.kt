// Extension properties

package com.infosupport.demos.h3.functions

fun main() {
    val string = "Kotlin?"
    val sb = StringBuilder(string)

    println(string.lastChar)

    println(sb.lastChar)
    sb.lastChar = '!'
    println(sb)
}

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

