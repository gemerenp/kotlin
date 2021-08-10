package com.infosupport.demos.h5.lambdas

// Lambdas with receivers: with and apply

// TODO show and tell
fun main(args: Array<String>) {
    println(alphabetVerboseStyle())

    println(alphabetUsingTheWithScopeFunctionVerboseStyle())
    println(alphabetUsingTheWithScopeFunction())

    println(alphabetUsingTheApplyScopeFunction())

    println(buildPerson("Bram"))
}

fun alphabetVerboseStyle(): String {
    val result = StringBuilder() // the 'receiver'
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabetUsingTheWithScopeFunctionVerboseStyle(): String {
    val sb = StringBuilder()

    // the 'receiver' is passed to with(...){...}
    return with(sb) {
        // 'this' is the receiver, i.e. sb
        for (letter in 'A'..'Z') {
            this.append(letter) // 'this' can be omitted of course
        }
        append("\nNow I know the alphabet!")
        this.toString()
    }
}

// more concise
fun alphabetUsingTheWithScopeFunction() = with(StringBuilder()) {
    // 'this' is the receiver here, i.e. StringBuilder()
    ('A'..'Z').forEach { append(it) }

    // ... is equal to:
    // for (letter in 'A'..'Z') {
    //     append(letter)
    // }

    append("\nNow I know the alphabet!")

    // return whatever you want
    toString()
}

// alternative to 'with' is 'apply'
fun alphabetUsingTheApplyScopeFunction() = StringBuilder().apply {
    // 'this' is the receiver, i.e. StringBuilder()
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    // 'apply' returns 'this' by default
}.toString()

// 'apply' acts as a builder: initialize an object during creation
fun buildPerson(name: String) = Person(name).apply {
    // 'this' is the receiver object, i.e. Person(name)

    this.age = 42
    this.instruments = List(name.length) { Instrument(it.toString()) }

    // returns 'this', i.e. the built person
}
