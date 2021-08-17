// Extension functions

package com.infosupport.demos.h3.functions

// TODO tell:
//  - receiver type   = String
//  - receiver object = this
//  See https://drek4537l1klr.cloudfront.net/jemerov/Figures/03fig01_alt.jpg
fun String.lastChar(): Char = this.get(this.length - 1) // you can omit 'this'

// TODO show: see Functions4b.kt

// TODO show
fun main() {
    val letters = listOf("A", "B", "C", "D")
    val lettersJoined = letters.myJoin(separator = "|") // call my extension function
    println(lettersJoined)

    // TODO tell: no overriding for extension functions
    val view: View = Button()
    view.click()   // on button
    view.showOff() // on view

    val button: Button = Button()
    button.click()   // on button
    button.showOff() // on button
}

// TODO tell: join as extension function
fun List<String>.myJoin(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String = joinToStringClassic(this, separator, prefix, postfix)

// TODO tell: the member function always takes precedence over extension function
// See https://drek4537l1klr.cloudfront.net/jemerov/Figures/03fig02.jpg
// Extensions aren't part of a class. They're declared externally as static methods.

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

// fun Button.click() = println("Button ext. fun clicked")

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")



