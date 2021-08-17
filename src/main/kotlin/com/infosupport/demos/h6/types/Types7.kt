package com.infosupport.demos.h6.types

// Primitives and other basic types: any, unit, nothing

fun main() {
    any()
    unit()
    nothing()
}

private fun any() {
    // Any is like java's object
    val i: Any = 42
    val toString = i.toString()
    val equals = i.equals(43)
    val hashCode = i.hashCode()

    // Other methods from java.lang.Object are not available on i, so:
    // val o = i as java.lang.Object
    // o.notify()
    // o.wait()
    // etc.

    // Any can be nullable
    var j: Any? = null
    j = 43
    val equals1 = j?.equals(42)
}

private fun unit() {
    // Unit is Java's void
    // Unit means: only one instance
    fun returnUnit(): Unit {
        return Unit // Unit is the only value of type Unit;
    }

    // shorter:
    fun f() {

    }

    // We can use Unit as type argument, since Unit has a value (i.e. Unit):
    // See class NoResultProcessor : Processor<Unit> { ..
    // This can't be done with void in Java.
    NoResultProcessor().process()
    StringProcessor().process()

    // The name Unit is chosen instead of Void to better distinguish it from Nothing.
    // - Void and Nothing: meanings are too close.
    // - Unit and Nothing: means only one value vs. no value.
}

private fun nothing() {
    // Useful usage of Nothing:
    val addrNullable = person.company?.address
    val addrNonNullable = person.company?.address ?: fail("No address found")
    // The second val is nonnullable because either it is an Address, or Nothing.
}

// used in testing libraries
fun fail(message: String): Nothing { // this function never returns anything
    throw IllegalStateException(message)
}
