package com.infosupport.demos.ch6.types

// If ⏲ permits
// Nullability and Java: platform types

fun main() {
    // What happens when you combine Kotlin and Java types?
    // Do you lose safety, do you have to check for null? Let's find out.

    // A Java type can be used as nullable or not nullable in Kotlin. You choose.
    var p: JavaPerson?
    p = JavaPerson("Bram nullable")
    p = null // ok

    val p2: JavaPerson
    p2 = JavaPerson("Bram non-nullable")
    // p2 = null // not allowed


    // Kotlin doesn't have nullability information of types in Java.
    // These Java types are called "platform types" when used in Kotlin.
    // Example: java.lang.String is a platform type and denoted by the compiler as "String!".
    val p3 = JavaPerson.of("")

    // You can treat the parameter and its property as nonnull, but that's not safe.
    yellAtUnsafe(JavaPerson("null"))    // ok
    // yellAtUnsafe(JavaPerson(null))   // allowed but will throw an exception (which one?)
    // yellAtUnsafe(null)               // not allowed

    yellAtSafe(null)                    // ok
    yellAtSafe(JavaPerson("null"))      // ok
    yellAtSafe(JavaPerson(null))        // ok

    // When you implement a Java interface, you can also choose between nullable or non-nullable method params
}

fun yellAtUnsafe(person: JavaPerson) {
    // Because person can be nullable or non-nullable, you can treat "person.name: String!" also as nullable or non-nullable:
    val name = person.name
    println(name?.uppercase() + "!!!") // as nullable: safe
    println(name.uppercase() + "!!!")  // as non-nullable: unsafe; use only when you're sure the name is nonnull in java (e.g. @NonNull)
}

// parameter can be null
fun yellAtSafe(person: JavaPerson?) {
    // Because person is only nullable now, "person.name: String" is also only nullable:
    val name = person?.name
    // println(name.uppercase() + "!!!") // not allowed anymore
    println(name?.uppercase() + "!!!")   // safe call required
}

