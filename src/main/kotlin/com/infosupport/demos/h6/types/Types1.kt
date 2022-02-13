package com.infosupport.demos.h6.types

// Nullability:
// - nullable types,
// - safe call,
// - elvis

// Avoid NullPointerExceptions at runtime: convert these problems from runtime errors into compile-time errors.

// TODO show and tell
fun main() {
    printStrLen()
    printAllCaps()
    printCountryName()
    usingThrowWithElvis()
}

fun printStrLen() {
    println(strLen("abc"))
    // println(strLen(null)) // compile time error (runtime error in Java)

    println(strLenSafe1("abc"))
    println(strLenSafe1(null))

    println(strLenSafe2("abc"))
    println(strLenSafe2(null))

    println(elvisDemo(null))
    println(elvisDemo("The King"))
}

/* Java */
// int strLen(String s) {
//     return s.length();
// }
// Not safe when s == null

/* Kotlin */
// String type is not nullable, s can't be null
fun strLen(s: String) = s.length
// Safe: s can't be null

fun strLenSafe1(s: String?) = if (s != null) s.length else 0 // not idiomatic
fun strLenSafe2(s: String?) = s?.length ?: 0 // Elvis and safe call combined

fun elvisDemo(s: String?) {
    val message: String = s ?: "Unknown"
    println(message)
}

fun printAllCaps() {
    println(allCapsOrEmpty("abc"))
    println(allCapsOrEmpty(null))

    println(allCapsOrNull("abc"))
    println(allCapsOrNull(null))
}

// safe call and elvis returns nonnullable type String:
fun allCapsOrEmpty(s: String?): String =
    s?.uppercase() ?: ""

// safe call returns nullable type String?:
fun allCapsOrNull(s: String?): String? =
    s?.uppercase()

// More extensive examples

fun printCountryName() {
    println(person.countryNameVerbose())
    println(person.countryName())
}

// verbose
fun Person.countryNameVerbose(): String {
    val country = this.company?.address?.country
    return if (country != null) country else "Unknown"
}

// more concise
fun Person.countryName() = company?.address?.country ?: "Unknown"

// another one:
fun usingThrowWithElvis() {
    printShippingLabel(Person("Dmitry", jetbrains))
    printShippingLabel(Person("Alexey", null))
}

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")

    // by throwing, address is guaranteed to be `String` (not nullable) at this point

    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}


