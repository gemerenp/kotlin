package com.infosupport.demos.h6.types

class Address(
    val streetAddress: String, val zipCode: Int,
    val city: String, val country: String
)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company? = null)

val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
val jetbrains = Company("JetBrains", address)
val person = Person("Dmitry", jetbrains)

interface Processor<T> {
    fun process(): T
}

class NoResultProcessor : Processor<Unit> {
    override fun process(): Unit {
        println("42")
    }
}

class StringProcessor : Processor<String> {
    override fun process(): String {
        return "42"
    }
}
