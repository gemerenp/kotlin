package com.infosupport.demos.h4.classes

// Inheritance:
// Visibility modifiers: public by default
// not allowed: animateTwice is not open but final by default
// override fun animateTwice() {}

// TODO show
fun main() {
    val richButton = RichButton(1)
    richButton.disable() // from...?
    richButton.animate() // from...?
    richButton.click()   // from...?
    richButton.showOff() // from...?

    val gif = Gif(2)
    gif.animate()
    gif.animateTwice()
    gif.stopAnimating()

    val talkativeButton = TalkativeButton()
    talkativeButton.speech()
    talkativeButton.giveSpeech()
}

// - Open, final, and abstract

//   See https://drek4537l1klr.cloudfront.net/jemerov/HighResolutionFigures/table_4-2.png

// TODO tell
open class RichButton(val x: Int) : Clickable {     // open: can be overridden
    public final fun disable() {}       // public final by default: can’t be overridden
    open fun animate() {}               // open: can be overridden
    /*final?*/ override fun click() {}  // overrides a member in a superclass or interface; open by default, if not marked final
}

class MyRichButton(myX: Int) : RichButton(myX) {
    // override fun disable() {}        // not allowed
    override fun showOff() {
        TODO("Not yet implemented")
    }
}

// TODO tell
abstract class Animated(val a: Int) {
    abstract fun animate()      // open by default, final not allowed
    open fun stopAnimating() {}
    fun animateTwice() {}
}

class Gif(anA: Int) : Animated(anA) {

    override fun animate() {  // you have to implement abstract method, just as in Java
        println("Animating...")
    }

    // allowed: stopAnimating is open
    override fun stopAnimating() {
        println("Stopped")
    }
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
    fun speech() {
        // allowed:
        yell()
        whisper()
    }
}

// must be internal too (or less visible): it's not allowed to reference internal TalkativeButton from a public function giveSpeech:
internal fun TalkativeButton.giveSpeech() {
    // Not allowed: reference private or protected members from an internal function
    // yell()
    // whisper()
    this.speech()
}
