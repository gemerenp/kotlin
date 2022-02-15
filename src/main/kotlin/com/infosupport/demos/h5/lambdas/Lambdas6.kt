package com.infosupport.demos.h5.lambdas

// Lambdas with receivers: with and apply

// TODO show and tell
fun main() {
    println(alphabetVerboseStyle())

    println(alphabetUsingTheWithScopeFunctionVerboseStyle())
    println(alphabetUsingTheWithScopeFunction())

    println(alphabetUsingTheApplyScopeFunction())

    println(buildPerson("Bram"))
}

fun alphabetVerboseStyle(): String {
    val result = StringBuilder() // the 'receiver'
    (('A'..'Z').minus('O').plus("omikron")).forEach { result.append(it) }    // repeat 'result' every time...
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabetUsingTheWithScopeFunctionVerboseStyle(): String {
    val sb = StringBuilder()

    // the 'receiver' is passed to with(...){...}
    return with(sb) {
        // 'this' is the receiver, i.e. sb
        ('A'..'Z').forEach { append(it) }
        append("\nNow I know the alphabet!")
        toString() // last line is return value
    }
}

// more concise
fun alphabetUsingTheWithScopeFunction() = with(StringBuilder()) {
    // 'this' is the receiver here, i.e. StringBuilder()
    ('A'..'Z').forEach { append(it) }
    append("\nNow I know the alphabet!")

    // return whatever you want
    toString()
}

// alternative to 'with' is 'apply'
// the only difference is that apply returns 'this' by default
fun alphabetUsingTheApplyScopeFunction() = StringBuilder().apply {
    // 'this' is the receiver, i.e. StringBuilder()
    ('A'..'Z').forEach { append(it) }
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
