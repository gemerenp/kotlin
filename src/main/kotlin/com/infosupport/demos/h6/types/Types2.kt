package com.infosupport.demos.h6.types

// Nullability:
// - safe cast,
// - unsafe not-null assertion,
// - let scope function,
// - nullability and
//      - extension functions
//      - generic type parameters

// TODO show and tell
fun main() {
    printPersonNameSafe(Person("Bram"))
    printPersonNameSafe("Bram")
    printPersonNameSafe(Company("Info Support", null))

    printPersonNameUnsafe(person)
    // printPersonNameUnsafe(null) // allowed, but will crash

    // id 1 exists, id 2 not:
    letPrintPersonName(id = 1)
    letPrintPersonName(id = 2) // does nothing

    findPerson(id = 1).printPersonNameSafeExtFn()
    findPerson(id = 2).printPersonNameSafeExtFn() // no safe call need, even though getPerson is of type Person?

    printHashcodeGeneric(person)
}

fun printPersonNameSafe(o: Any?) {
    val p = o as? Person // if o is Person then p is cast to Person, else p = null
    // now p is smart cast to Person?
    println(p?.name ?: "Unknown")
}

fun printPersonNameUnsafe(p: Person?) {
    // We tell the compiler we're sure that p is not null
    println(p!!.name) // !! is the not null assertion
}

fun findPerson(id: Int): Person? = if (id == 1) person else null // person or null, so Person?

fun letPrintPersonName(id: Int) {
    val p = findPerson(id)
    // when you want to execute a block of code if object is not null, use let
    p?.let {
        println("Printing person name...")
        printPersonNameUnsafe(it)
    } // executes only if p is not null
}

fun Person?.printPersonNameSafeExtFn() {
    println(this?.name ?: "Unknown")
}

fun <T> printHashcodeGeneric(t: T) {
    // T is nullable, since it can be anything
    println(t?.hashCode() ?: "Unknown") // safe call needed
}

