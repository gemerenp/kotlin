//  Your package hierarchy doesn’t need to follow the directory hierarchy
package com.infosupport.demos.ch2.basics

// main function (first class citizen)
fun main(args: Array<String>) {
    // if expressions

    // - oneliner
    val s = if (args.isNotEmpty()) args[0] else "world"

    // - with body
    val s2 = if (args.isNotEmpty()) {
        println("Nederlands")
        args[0]
    } else {
        "wereld"
    }

    // string template
    println("Hello, $s!")
    println("Hello, ${s2}!")
    // string template with expression and unescaped quotes
    println("Hello, ${if (args.isNotEmpty()) args[0] else "world"}!")

    // val: immutable reference, must be initialized
    val max1 = max(1)        // b has default value; type inference
    val max2 = max(1, b = 2) // named arguments
    val max3 = maxExpressionBody(b = 3, a = 4)

    // var: mutable reference
    var y: Double // no init value, type cannot be inferred
    y = 5.67e6 // with exp
    y += 1
}

// functions
fun max(a: Int, b: Int = 500, c: Int = 0): Int { // b has default value
    return if (a > b) a else b
}

// expression body
fun maxExpressionBody(a: Int, b: Int) = if (a > b) a else b // return type is inferred

// Lab 1
