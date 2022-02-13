package com.infosupport.demos.h1.intro

data class Person(
    val name: String,
    val age: Int? = null
)

fun main() {
    val persons = listOf(
        Person("Alice"),
        Person("Bob", age = 29)
    )

    val oldest = persons.maxByOrNull {
        it.age ?: 0
    }

    println("""The "oldest" is: $oldest.""")
}

// Compiling manually:
// - open a terminal
// - cd into a dir where a source resides:  $ cd src\main\kotlin\com\infosupport\demos\h1\intro
// - compilation to one class:              $ kotlinc Taste.kt
// - compilation to one runnable jar:       $ kotlinc Taste.kt -include-runtime -d taste.jar
// - run the jar:                           $ java -jar taste.jar
