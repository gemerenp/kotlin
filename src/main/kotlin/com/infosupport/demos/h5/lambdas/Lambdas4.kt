package com.infosupport.demos.h5.lambdas

// Creating sequences

// TODO show and tell
fun main() {

    // use generateSequence
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    val sum = numbersTo100.sum()
    println(sum)

    // we can reuse a sequence:
    val sum1 = numbersTo100.sum()
    println(sum1)

    // use sequence {...}
    val fiboTo100 = fibonacci().takeWhile { it <= 100 }.toList()
    println(fiboTo100)

    // or use its iterator manually
    val iterator = fibonacci().iterator()
    repeat(7) { println(iterator.next()) }
}

fun fibonacci() = sequence {
    var terms = Pair(0, 1)

    // this sequence is infinite
    while (true) {
        yield(terms.first) // yield is not a keyword, but a suspendable function (more on that in Kotlin Advanced)
        terms = Pair(terms.second, terms.first + terms.second)
    }
}
