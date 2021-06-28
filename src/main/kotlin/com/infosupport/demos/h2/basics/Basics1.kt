// TODO show and tell

//  Your package hierarchy doesn’t need to follow the directory hierarchy
package com.infosupport.demos.h2.something

// main function (first class citizen)
fun main(args: Array<String>) {
    // if expression
    val s = if (args.size > 0) args[0] else "world"

    // string template
    println("Hello, $s!")
    println("Hello, ${if (args.isNotEmpty()) args[0] else "world"}!") // string template with expression and unescaped quotes

    // val: immutable reference, must be initialized
    val max1 = max(1)        // b has default value; type inference
    val max2 = max(1, b = 2) // named arguments
    val max3 = maxExpressionBody(a = 3, b = 4)

    // var
    // mutable reference
    var y: Double // no init value, type cannot be inferred
    y = 5.67e6 // with exp
    y += 1

    // See unit test for more
}

// functions
fun max(a: Int, b: Int = 0): Int { // b has default value
    return if (a > b) a else b
}

// expression body
fun maxExpressionBody(a: Int, b: Int) = if (a > b) a else b // return type is inferred
