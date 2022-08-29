package com.infosupport.demos.h4.classes

// Data classes

class ClientVerbose(val name: String, val postalCode: Int) {
    override fun toString() =
        "Client(name=$name, postalCode=$postalCode)"

    override fun equals(other: Any?) =
        other != null &&
                other is ClientVerbose && // smart casting Any -> Client
                name == other.name && postalCode == other.postalCode

    override fun hashCode(): Int =
        name.hashCode() * 31 + postalCode

    // getters / setters omitted...

}

// same but concise:
data class Client(val name: String, val postalCode: Int)

fun main() {
    val kelly = ClientVerbose("Kelly", 90210)
    val kellyToo = ClientVerbose("Kelly", 90210)
    val kellySet = hashSetOf(kelly)

    println(kelly) // calls toString
    println(kelly == kellyToo) // you must use == for equality
    println(kelly === kellyToo) // you must use === for comparing reference
    println(kellySet.contains(kellyToo)) // needs equals AND hashcode

    // same for data class

    val dylan = Client("Dylan", 90210)
    val dylanToo = Client("Dylan", 90210)
    val dylanSet = hashSetOf(dylan)

    println(dylan)
    println(dylan == dylanToo)
    println(dylan === dylanToo)
    println(dylanSet.contains(dylanToo))

    // data class also contains fun copy()
    val al = dylan.copy(name = "Al", postalCode = 60606)
    println(al)
    println(dylan == al)
    println(dylan === al)
    println(dylanSet.contains(al))

    // ... and componentN functions for destructuring
    val (name, postalCode) = dylan
    println(name)
    println(postalCode)
}

// Lab 3a
