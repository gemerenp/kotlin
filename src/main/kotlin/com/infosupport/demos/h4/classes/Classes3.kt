package com.infosupport.demos.h4.classes

// Inner and nested classes: nested by default

import java.io.Serializable

// TODO show and tell
fun main() {
    // See figure 4.1. Nested classes don’t reference their outer class, whereas inner classes do.
    // See https://livebook.manning.com/book/kotlin-in-action/chapter-4/87

    // Nested:
    // val nestedBs = ViewButton().ButtonState(); // Java:   nested is bound to instance of outer
    // val nestedBs = ViewButton.ButtonState()    // Kotlin: nested is static

    // Inner:
    // val outer = Outer()                        // Java:   inner is static
    val outer = Outer()                           // Kotlin: inner is bound to instance of outer
    val inner = outer.Inner()

    println(outer.message)
    inner.accessOuterReference()
    println(outer.message)
}

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class ViewButton : View {
    private var message = "Hello"

    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {}

    // Nested class (default); in Java: static
    class ButtonState : State {
        // ButtonState.this.message += "World" // In Java, not in Kotlin
    }
}

class Outer(var message: String = "Hello") {

    // Inner class (stores a reference to an outer class)
    inner class Inner {
        fun accessOuterReference(): Outer {
            //                                In Kotlin, not in Java
            val outer = this@Outer // access Outer class instance from Inner
            outer.message += "World"

            return outer
        }
    }
}

