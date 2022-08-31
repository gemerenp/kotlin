package com.infosupport.demos.ch4.classes

// Inner and nested classes: nested by default

fun main() {
    // See figure 4.1. Nested classes don’t reference their outer class, whereas inner classes do.
    // See https://drek4537l1klr.cloudfront.net/jemerov/HighResolutionFigures/figure_4-1.png

    // Inner:
    // val inner = Outer.Inner()        // Java:   inner is static
    val outer = Outer()                 // Kotlin: inner is bound to instance of outer
    val inner = outer.Inner()

    println(inner.message)
    println(outer.message)
    inner.thisInnerMessage()
    inner.thisOuterMessage()
    println(inner.message)
    println(outer.message)

    // Nested:
    // val nested = Outer().Nested()    // Java:   nested is bound to instance of outer
    val nested = Outer.Nested()         // Kotlin: nested is static
    // println(nested.message)          // does not compile
}

class Outer(var message: String = "Hello ") {

    // Inner class (stores a reference to outer class via this@Outer)
    inner class Inner {
        val message = "Hello "

        fun thisInnerMessage(): String {
            return this.message + "World"
        }

        fun thisOuterMessage(): String {
            return this@Outer.message + "World" // access Outer class instance from Inner
        }

    }

    // Nested class: no reference to outer class
    class Nested(var name: String = "") {

    }
}

