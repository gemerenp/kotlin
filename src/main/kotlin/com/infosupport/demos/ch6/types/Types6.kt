package com.infosupport.demos.ch6.types

// Primitives and other basic types: conversions, numeric literals

fun main() {
    val i = 1
    // No implicit conversions (not widening nor narrowing), to avoid unexpected behaviour:

    // val iToL: Long = i          // doesn't compile
    val iToLong: Long = i.toLong() // explicit conversion always needed

    // Why?
    val xInt = 1
    val list = listOf(1L, 2L, 3L)
    // println(xInt in list) // ... doesn't compile; if it would, it returns false, since Integer != Long, but that's unexpected.
    println(xInt.toLong() in list) // the way to go

    // Numeric literals
    val byte: Byte = 127 // 128 would fail of course: no overhead for overflow checks
    val char = '4'
    val short: Short = 4637
    val int = 435678
    val long = 54673890L
    val float = 0.42f
    val double1 = 0.42
    val double2 = 0.42e-100

    // not allowed:
    // val doubleWithPostfix = 0.42d
    // val longWithPostfix = 54673890l

    val hex = 0xCaFeBaBe
    val bits = 0b0111_0101_0101_1111
    // val oct = 0755 // Octal literals are not supported.

    // Numeric literals auto conversion
    val b: Byte = 1
    val lng = b + 42L

    // String conversion to primitives:
    val toInt = "42".toInt()
    val toDouble = "42.42".toDouble()
    val toBoolean = "true".toBoolean()
    // etc.
}

// Lab 1f
