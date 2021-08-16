package com.infosupport.demos.h4.classes

// Inner and nested classes: nested by default

// TODO show and tell
fun main() {
    // See figure 4.1. Nested classes don’t reference their outer class, whereas inner classes do.
    // See https://livebook.manning.com/book/kotlin-in-action/chapter-4/87

    // Inner:
    // val inner = Outer.Inner()        // Java:   inner is static
    val outer = Outer()                 // Kotlin: inner is bound to instance of outer
    val inner = outer.Inner()

    println(outer.message)
    inner.accessOuterReference()
    println(outer.message)

    // Nested:
    // val nested = Outer().Nested()    // Java:   nested is bound to instance of outer
    val nested = Outer.Nested()         // Kotlin: nested is static
}

class Outer(var message: String = "Hello") {

    // Inner class (stores a reference to outer class via this@Outer)
    inner class Inner {
        fun accessOuterReference(): Outer {
            val outer = this@Outer // access Outer class instance from Inner
            outer.message += "World"

            return outer
        }
    }

    // Nested class: no reference to outer class
    class Nested(var name: String = "") {

    }
}

