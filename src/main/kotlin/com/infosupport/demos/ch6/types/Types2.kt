package com.infosupport.demos.ch6.types

// Nullability:
// - safe cast,
// - unsafe not-null assertion,
// - let scope function,
// - nullability and
//      - extension functions
//      - generic type parameters

fun main() {
    castToPersonUnsafe(Person("Mark")) // OK
    // castToPersonUnsafe("OnTheEdge") // Exception

    castToPersonSafe(Person("Bram"))   // OK
    castToPersonSafe("Bram")           // OK

    printPersonNameUnsafe(person)      // OK
    // printPersonNameUnsafe(null)     // Exception

    // id 1 exists, id 2 not:
    printPersonName(1)
    printPersonName(2)

    letPrintPersonName(id = 1)
    letPrintPersonName(id = 2) // does nothing

    findPerson(1).printPersonNameSafeExtFn()
    findPerson(2).printPersonNameSafeExtFn() // no safe call needed, even though getPerson is of type Person?

    whatsTheHashcodeOfGenericTypeParam(person)
}

fun castToPersonUnsafe(o: Any) {
    val p = o as Person  // if o !is Person: ClassCastException
    // now p is a `Person`
    println(p.name)
}

fun castToPersonSafe(o: Any) {
    val p = o as? Person // if o !is Person, p = null, else p is cast to Person
    // now p is smart cast to a `Person?`
    println(p?.name ?: "Unknown")
}

fun printPersonNameUnsafe(p: Person?) {
    // We tell the compiler we're sure that p is not null
    println(p!!.name) // !! is the not null assertion
}

fun printPersonNameNonNull(p: Person) {
    println(p.name)
}

fun findPerson(id: Int): Person? = if (id == 1) person else null // person or null, so Person?

fun printPersonName(id: Int) {
    val findPerson = findPerson(id)
    if (findPerson != null) {
        println("Printing person name...")
        println(findPerson.name)
    }
}

fun letPrintPersonName(id: Int) {
    // when you want to execute a block of code if an object != null, use let:
    findPerson(id)?.let {
        println("Let printing person name...")
        println(it.name)
    }
}

fun Person?.printPersonNameSafeExtFn() {
    println(this?.name ?: "Unknown")
}

fun <T> whatsTheHashcodeOfGenericTypeParam(t: T) {
    // T is nullable, since it can be anything
    println(t?.hashCode() ?: "Unknown") // safe call needed
}

// Lab 1abcd
