package com.infosupport.demos.h4.classes

// Inheritance:
// - Interfaces

fun main() {
    val button = Button()
    button.showOff()        // from..?
    button.setFocus(true)   // from..?
    button.click()          // from..?
}

interface Clickable {
    abstract open fun click() // abstract open by default, final not allowed

    // default implementation
    open fun showOff() = println("I'm clickable!") // open by default, final not allowed

    // In interfaces, you don’t use final, open, or abstract.
}

interface Focusable {
    // default implementation
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")

    // default implementation
    fun showOff() = println("I'm focusable!")
}

class Button : Clickable, Focusable {
    // click has no default implementation, so you must implement it
    // use the keyword override to explicitly indicate that you're overriding.
    override fun click() = println("I was clicked.")

    // setFocus has default implementation: no need to override it

    // You MUST override default implementations here, since there are more than one.
    override fun showOff() {
        // e.g.:
        super<Clickable>.showOff() // You MUST indicate which super method you want to call
        super<Focusable>.showOff()
        println("I'm ready!")
    }
}

