package com.infosupport.demos.ch4.classes

// Inheritance:
// - Interfaces

fun main() {
    val button = Button()
    button.info()           // from..?
    button.setFocus(true)   // from..?
    button.click()          // from..?
}

interface Clickable {
    abstract open fun click() // abstract open by default, final not allowed

    // default implementation
    open fun info() = println("I'm clickable!") // open by default, final not allowed

    // In interfaces, you don’t use final, open, or abstract.
}

interface Focusable {
    // default implementation
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")

    // default implementation
    fun info() = println("I'm focusable!")
}

class Button : Clickable, Focusable {
    // click has no default implementation, so you must implement it
    // use the keyword override to explicitly indicate that you're overriding.
    override fun click() = println("Button was clicked.")

    // setFocus has default implementation: no need to override it

    // You MUST override default implementations here, since there are more than one.
    override fun info() {
        // e.g.:
        super<Clickable>.info() // You MUST indicate which super method you want to call
        super<Focusable>.info()
        println("I'm ready!")
    }
}

