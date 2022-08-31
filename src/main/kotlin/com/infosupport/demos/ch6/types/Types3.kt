package com.infosupport.demos.ch6.types

import com.infosupport.demos.ch1.intro.Person

// Nullability: lateinit

// See LateinitTest

class Lateinit {
    fun performAction(): String = "foo"
}

// To lazy init a property, do:

val lazyPerson get() = lazyPersonVal
lateinit var lazyPersonVal: Person

fun init() {
    lazyPersonVal = Person("Bram")
}

fun main() {
    // println(lazyPerson) // will crash
    init()
    println(lazyPerson)
}

// Lab 6.1e
