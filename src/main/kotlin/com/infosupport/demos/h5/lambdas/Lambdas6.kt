package com.infosupport.demos.h5.lambdas

// Lambdas with receivers: with and apply

fun main() {
    println(alphabetVerboseStyle())

    println(alphabetVerboseStyleUsingTheWithScopeFunction())
    println(alphabetUsingTheWithScopeFunctionConcise())

    println(alphabetUsingTheApplyScopeFunction())

    println(buildPerson("Bram"))
}

val alpha = ('A'..'Z').minus('O').plus("omikron")

fun alphabetVerboseStyle(): String {
    val sb = StringBuilder() // the 'receiver'
    alpha.forEach { sb.append(it) }    // repeat 'result' every time...
    sb.append("\nNow I know the alphabet!")
    return sb.toString()
}

fun alphabetVerboseStyleUsingTheWithScopeFunction(): String {
    val sb = StringBuilder()

    // the 'receiver' is passed to with(...){...}
    return with(sb) {
        // 'this' is the receiver, i.e. sb
        alpha.forEach { this.append(it) }
        append("\nNow I know the alphabet!")

        // return whatever you want
        toString() // last line is return value
    }
}

// more concise
fun alphabetUsingTheWithScopeFunctionConcise() = with(StringBuilder()) {
    // 'this' is the receiver, i.e. StringBuilder()
    alpha.forEach { this.append(it) }
    append("\nNow I know the alphabet!")

    // return whatever you want
    toString()
}

// alternative to 'with' is 'apply'
// the only difference is that apply returns 'this' by default
fun alphabetUsingTheApplyScopeFunction() = StringBuilder().apply {
    // 'this' is the receiver, i.e. StringBuilder()
    alpha.forEach { this.append(it) }
    append("\nNow I know the alphabet!")
}.toString()

// 'apply' acts as a builder: initialize an object during creation
fun buildPerson(name: String) = Person(name).apply {
    // 'this' is the receiver object, i.e. Person(name)
    age = 42 // (`this.` is omitted)
    instruments = List(name.length) { index -> Instrument(index) } // for each index create an Instrument with name = index

    // returns 'this', i.e. the built person
}

// There's also a convenience function to build strings, which is even more concise:
fun alphabet() = buildString {
    ('A'..'Z').forEach { append(it) }
    append("\nNow I know the alphabet!")
}

// Lab 5.1
// Lab 5.2
