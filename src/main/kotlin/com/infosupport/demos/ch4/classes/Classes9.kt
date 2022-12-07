package com.infosupport.demos.ch4.classes

import com.infosupport.demos.ch3.functions.lastChar

// The object keyword, companion objects -------------------------------------------------
// See also Classes9KtTest

// 1. Object declaration is a way to define a singleton. -------------------
// Declare an 'object'
object Payroll {
    init {
        println("Payroll instantiated")
    }

    val allEmployees = arrayListOf<Employee>()

    fun calculateSalary() = allEmployees.sumOf { it.salary }
}

//  Implementing Comparator with an 'object'
object SalaryComparator : Comparator<Employee> {
    override fun compare(o1: Employee, o2: Employee) = o1.salary - o2.salary
}

//  Implementing Comparator with a nested 'object'
open class Employee(name: String, val salary: Int) : Person(name) {
    object LastCharOfNameComparator : Comparator<Employee> {
        override fun compare(o1: Employee, o2: Employee) = o1.name.lastChar().compareTo(o2.name.lastChar())
    }
}

// 2. Companion objects: a place for factory methods and static members -------------------

// Companion object for a factory method
open class CompanionUser constructor(val nickname: String) {
    companion object { // this is Kotlin's 'static'
        const val STATICFIELD = 42

        // instead of using inheritance, put creation logic here
        fun of(email: String) =
            if (email.contains('@'))
                CompanionUser(email.substringBefore('@')) // we can access the private constructor here
            else
                throw IllegalArgumentException("E-mail $email doesn't contain an '@'!")

        fun of(accountId: Int) =
            CompanionUser(getFacebookNameFromWeb(accountId))
    }
}

// Companion objects behave like a regular object: can have name, implement interface, have extension
class TempEmployee(name: String, salary: Int, val level: Int) : Employee(name, salary) {
    companion object Loader : JSONFactory<TempEmployee> { // note the name and the implementation
        override fun toJSON(e: TempEmployee) =
            """{ salary: ${e.salary}, level: ${e.level} }"""
    }

    fun toJSON() = Loader.toJSON(this)
}

fun <T> saveToJSON(t: T, factory: JSONFactory<T>): String = factory.toJSON(t)

interface JSONFactory<T> {
    fun toJSON(e: T): String
}

class PermEmployee(name: String, salary: Int, val scale: Int) : Employee(name, salary) {
    // companion object must be explicitly defined to
    // be able to define extension function(s) on it
    // and it is implicitly called 'Companion'
    companion object {}

}

// Add extension function to companion
fun PermEmployee.Companion.staticExtFunction() = "Nice...!"

// 3. Object expression is used instead of Java’s anonymous inner class -------------------
val iterator = object : Iterator<PermEmployee> {
    override fun hasNext() = TODO()
    override fun next() = TODO()
}

fun main() {
    println("main")
    Payroll.calculateSalary() // instantiate Payroll once
    Payroll.calculateSalary() // already instantiated

    println(CompanionUser.STATICFIELD)
    println(CompanionUser.of("1234"))

    PermEmployee.staticExtFunction()
}

// Lab 3d
