package com.infosupport.demos.h4.classes

// Open, final, and abstract modifiers: final by default
// Visibility modifiers: public by default

// TODO tell
fun main(args: Array<String>) {
    val richButton = RichButton()
    richButton.disable() // from...?
    richButton.animate() // from...?
    richButton.click()   // from...?
    richButton.showOff() // from...?
}

// TODO tell
open class RichButton : Clickable {     // open: can be overridden
    public final fun disable() {}       // public final by default: can’t be overridden
    open fun animate() {}               // open: can be overridden
    /*final?*/ override fun click() {}  // overrides a member in a superclass or interface; open by default, if not marked final
}

// TODO tell
abstract class Animated {
    abstract fun animate()      // open by default, final not allowed
    open fun stopAnimating() {}
    fun animateTwice() {}
}

// TODO tell
// internal: visible in a module, not outside it
internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")             // private
    protected fun whisper() = println("Let's talk!") // protected
    /*
       PROTECTED:
       In Kotlin, visibility rules are simple, and a protected member
       is only visible in the class and its subclasses.
       Also note that extension functions (like below) of a class don’t get
       access to its private or protected members.
    */
}

// Not allowed: reference the less-visible type TalkativeButton from the public function giveSpeech:

// public fun TalkativeButton.giveSpeech() {
//      not allowed:
//      yell()
//      whisper()
// }


