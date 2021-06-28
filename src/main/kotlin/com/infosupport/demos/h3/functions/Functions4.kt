// Extension functions

package com.infosupport.demos.h3.functions

// TODO tell:
//  - receiver type   = String
//  - receiver object = this
//  See https://livebook.manning.com/book/kotlin-in-action/chapter-3/98
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

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

// TODO tell: the member function always takes precedence over extension function
fun Button.click() = println("Button EF clicked")

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")




