package com.infosupport.demos.ch4.classes

// Inheritance: open, override
//  - See resources/img/buttons.png
// Visibility modifiers: public by default

fun main() {
    val richButton = MyRichButton(1)
    richButton.disable()         // from...?
    richButton.animate()         // from...?
    richButton.click()           // from...?
    richButton.info()            // from...?
    richButton.moduleInternals() // from...?

    val gif = Gif(2)
    gif.animate()
    gif.animateTwice()
    gif.stopAnimating()

    val talkativeButton = TalkativeButton()
    talkativeButton.speech()            // public
    talkativeButton.moduleInternals()   // internal
    talkativeButton.giveSpeech()        // internal
}

// - Open, final, and abstract
//   See https://drek4537l1klr.cloudfront.net/jemerov/HighResolutionFigures/table_4-2.png
open class RichButton(val x: Int) : Clickable { // open: can be overridden
    public final fun disable() {}       // public final by default: can’t be overridden
    open fun animate() {}               // open: can be overridden
    open override fun click() {}        // overrides a member in a superclass or interface; open by default, if not marked final
}

class MyRichButton(myX: Int) : RichButton(myX) {
    // override fun disable() {}        // not allowed
    override fun info() {}
    internal fun moduleInternals() {}
}

abstract class Animated(val a: Int) {
    abstract fun animate()      // open by default, final not allowed
    open fun stopAnimating() {}
    fun animateTwice() = repeat(2) { animate() }
}

class Gif(anA: Int) : Animated(anA) {
    // you have to implement abstract method, just as in Java
    override fun animate() = println("Animating...")

    // allowed: stopAnimating is open
    override fun stopAnimating() = println("Stopped")
}

// Internal: visible in a module, not outside it, see CallInternals.kt
// A module is a set of Kotlin files compiled together, for example:
//  - an IntelliJ IDEA module
//  - a Maven project
//  - a Gradle source set
//  - a set of files compiled with one invocation of the <kotlinc> Ant task.
// See https://kotlinlang.org/docs/visibility-modifiers.html#modules,
internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")             // private
    internal fun moduleInternals() = println("???")  // internal
    protected fun whisper() = println("Let's talk!") // protected: only visible in the class and its subclasses, _not_ in package
    fun speech() {                                   // public
        // allowed here, but not allowed in extension function giveSpeech() below
        yell();whisper()
    }

}

// must be internal too (or less visible)
internal fun TalkativeButton.giveSpeech() {
    // Not allowed: reference private or protected members from an internal function
    // yell(); whisper()

    // Allowed: call internal or public
    moduleInternals()
    speech()
}
// Lab 3b
