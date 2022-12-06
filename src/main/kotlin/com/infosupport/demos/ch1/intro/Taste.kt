package com.infosupport.demos.ch1.intro

class Person(val name: String, val age: Int? = null)

fun main() {
    val alice = Person("Alice")
    val bob = Person("Bob", age = 29)

    val persons = listOf(alice, bob)

    val highestAge = persons.maxOf { it.age ?: 0 }
    val oldest = persons.maxByOrNull { it.age ?: 0 }

    println(persons)
    println("""The "highest age" is: $highestAge.""")
    println("The oldest person is: ${oldest?.name}.")
}

// Compiling manually:
// - download the kotlinc and put it on the PATH
// - open a terminal
// - cd into a dir where a source resides:  $ cd src\main\kotlin\com\infosupport\demos\ch1\intro
//   - compilation to one class:            $ kotlinc Taste.kt
//   - compilation to one runnable jar:     $ kotlinc Taste.kt -include-runtime -d taste.jar
// - run the jar:                           $ java -jar taste.jar
