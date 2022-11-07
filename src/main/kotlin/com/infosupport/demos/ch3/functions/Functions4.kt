// Extension functions
// No overriding for extension functions

package com.infosupport.demos.ch3.functions

//  Terminology, see https://drek4537l1klr.cloudfront.net/jemerov/Figures/03fig01_alt.jpg
//  vvvvvv = "receiver type"  vvvv = "receiver object"
fun String.lastChar(): Char = this.get(this.length - 1) // you can omit 'this'

// How to use lastChar: see Functions4b.kt

fun main() {
    val letters = listOf("A", "B", "C", "D")
    val lettersJoined = letters.myJoin(separator = "|") // call my extension function
    println(lettersJoined)

    // No overriding for extension functions!
    //  Member function always takes precedence over extension function
    //  Extensions aren't part of a class. They're declared externally as static methods, not as members.
    //  See https://drek4537l1klr.cloudfront.net/jemerov/Figures/03fig02.jpg:
    //    - Button.click   overrides  View.click
    //    - Button.showOff !overrides View.showOff

    val button: Button = Button()
    val buttonAsView: View = Button()

    button.click()          // on ??? (answer ----> ................................................................................................ Button, as expected
    button.off()            // on ??? (answer ----> ................................................................................................ Button, as expected

    buttonAsView.click()    // on ??? (answer ----> ................................................................................................ Button, as expected
    buttonAsView.off()      // on ??? (answer ----> ................................................................................................ View! Extension function does not override `super` extension function.
}

// myJoin as extension function:
fun List<String>.myJoin(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String = joinToStringClassic(this, separator, prefix, postfix)

// No overriding for extension functions
abstract class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

fun View.off() = println("View off from ext. function")
fun Button.off() = println("Button off from ext. function")
fun Button.click() = println("Button clicked from ext. function")
