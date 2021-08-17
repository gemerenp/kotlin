package com.infosupport.demos.h5.lambdas

import java.awt.Button
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.ActionEvent.ACTION_PERFORMED as ap

// Using Java Functional Interfaces from Kotlin
// Q: How to call a Java API with functional interfaces from Kotlin?
// A: Kotlin lambda's are fully compatible with Java functional interfaces.

// TODO show and tell
fun main() {
    val javaAwtButton = Button("OK") // note the imports

    // Can we assign a java.awt.ActionListener to the java.awt.Button from Kotlin?

    // 1. Java 7 style, using anonymous inner class with Kotlin's 'object'
    javaAwtButton.addActionListener(object : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            println(action(1, e))
        }
    })

    // 2. Kotlin lambda style
    // ActionListener is a Functional Interface a.k.a. SAM Interface (Single Abstract Method), so we can use a lambda
    javaAwtButton.addActionListener(ActionListener({ e -> println(action(2, e)) }))

    // Lambda automatically gets converted to SAM like in Java
    javaAwtButton.addActionListener { e -> println(action(3, e)) }

    // More concise
    javaAwtButton.addActionListener { println(action(4, it)) }

    //
    // .. and fire an event
    javaAwtButton.dispatchEvent(ActionEvent(javaAwtButton, ap, "click!"))
}

private fun action(i: Int, e: ActionEvent) = "Action $i says: ${e.actionCommand}"
