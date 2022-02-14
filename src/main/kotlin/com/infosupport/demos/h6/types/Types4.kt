package com.infosupport.demos.h6.types

// If ⏲ permits
// Nullability and Java: platform types

fun main() {
    // What happens when you combine Kotlin and Java types?
    // Do you lose safety, do you have to check for null? Let's find out.

    // A Java type can be used as nullable or not nullable in Kotlin. You choose.
    var p: JavaPerson?
    p = JavaPerson("Bram")
    p = null // ok

    val p2: JavaPerson
    p2 = JavaPerson("Bram")
    // p2 = null // not allowed

    // Kotlin doesn't have nullability information of types in Java.
    // These Java types are called "platform types" when used in Kotlin.
    // Example: java.lang.String is a platform type and denoted by the compiler as "String!".
    val s = java.lang.String.valueOf("ABC"); // press Ctrl+Q on s

    // You can treat the parameter and its property as nonnull, but that's not safe.
    yellAtUnsafe(JavaPerson("null"))    // ok
    // yellAtUnsafe(JavaPerson(null))   // allowed but will throw an exception (which one?)

    yellAtSafe(JavaPerson("null"))      // ok
    yellAtSafe(JavaPerson(null))        // ok

    // When you implement a Java interface, you can also choose between nullable or non nullable method params
}

fun yellAtUnsafe(person: JavaPerson) {
    // You can treat "person.name: String!" as nullable or non nullable:
    println(person.name?.uppercase() + "!!!") // safe
    println(person.name.uppercase() + "!!!")  // unsafe, use only when you're sure the name is nonnull in java (e.g. @NonNull)
}

// parameter can be null
fun yellAtSafe(person: JavaPerson?) {
    // println(person?.name.toUpperCase() + "!!!") // not allowed anymore
    println(person?.name?.uppercase() + "!!!")              // safe call required
    println((person?.name ?: "Anyone").uppercase() + "!!!") // .. with Elvis
}

