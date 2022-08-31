package com.infosupport.demos.ch5.lambdas

// Lambdas with receivers: with and apply

fun main() {
    println(abcVerboseStyle())

    println(abcUsingWith())
    println(abcUsingWithConcise())

    println(abcUsingApply())

    println(buildPerson("Bram"))
}

fun abcVerboseStyle(): String {
    val sb = StringBuilder() // the 'receiver'

    sb.append('A')           // we have to repeat 'sb' every time...
    sb.append('B')
    sb.append('C')

    return sb.toString()
}

fun abcUsingWith(): String {
    val sb = StringBuilder()

    // the 'receiver' is passed to with(...) {...}
    return with(sb) {
        // 'this' is the receiver, i.e. sb
        append('A')          // repeating 'sb' is gone
        append('B')
        append('C')

        // return whatever you want
        toString() // last line is return value
    }
}

fun abcUsingWithConcise() =
    with(StringBuilder()) {
        // 'this' is the receiver, i.e. StringBuilder()
        append('A') // 'sb' is gone
        append('B')
        append('C')

        // return whatever you want
        toString()
    }

// alternative to 'with' is 'apply'
// the only difference is that apply returns 'this' by default
fun abcUsingApply() =
    StringBuilder().apply {
        // 'this' is the receiver, i.e. StringBuilder()
        append('A') // 'sb' is gone
        append('B')
        append('C')
    }.toString()

// 'apply' acts as a builder: initialize an object during creation
fun buildPerson(name: String) =
    Person(name).apply {
        // 'this' is the receiver, i.e. Person(name)
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
