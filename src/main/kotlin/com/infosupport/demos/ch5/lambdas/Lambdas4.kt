package com.infosupport.demos.ch5.lambdas

// Creating sequences

fun main() {

    // use generateSequence
    val naturalNumbers = generateSequence(50) { it + 1 }        // 1
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }   // 2
    val sum = numbersTo100.sum()                                // 3
    println(sum)

    // we can reuse a sequence to do something else with it:
    numbersTo100.forEach { println(it) }

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

// Lab 3
// Lab 4
// Lab 5e
