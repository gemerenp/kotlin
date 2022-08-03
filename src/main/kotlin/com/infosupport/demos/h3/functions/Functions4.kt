// Extension functions

package com.infosupport.demos.h3.functions

//  Terminology, see https://drek4537l1klr.cloudfront.net/jemerov/Figures/03fig01_alt.jpg
//  String is "receiver type"|this is "receiver object"
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

    val button = Button()
    val buttonAsView: View = Button()

    button.click()          // on Button, as expected
    button.off()            // on Button, as expected

    buttonAsView.click()    // on Button, as expected
    buttonAsView.off()      // on View! Extension function does not override `super` extension function.
}

// myJoin as extension function:
fun List<String>.myJoin(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String = joinToStringClassic(this, separator, prefix, postfix)


abstract class View {
    open fun click() = println("View clicked")
}

fun View.off() = println("View off")

class Button : View() {
    override fun click() = println("Button clicked")
}

fun Button.off() = println("Button off")

// no overriding for extension functions
fun Button.click() = println("Button clicked from ext. function")
