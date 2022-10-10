package com.infosupport.demos.ch1.intro

data class Person(
    val name: String,
    val age: Int? = null
)

fun main() {
    val persons = listOf(
        Person("Alice"),
        Person("Bob", age = 29)
    )

    val oldest = persons.maxOf { it.age ?: 0 }

    println("""The "oldest" is: $oldest.""")
}

// Compiling manually:
// - download the kotlinc and put in on the PATH
// - open a terminal
// - cd into a dir where a source resides:  $ cd src\main\kotlin\com\infosupport\demos\ch1\intro
//   - compilation to one class:            $ kotlinc Taste.kt
//   - compilation to one runnable jar:     $ kotlinc Taste.kt -include-runtime -d taste.jar
// - run the jar:                           $ java -jar taste.jar
