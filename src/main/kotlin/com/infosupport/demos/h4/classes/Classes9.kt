package com.infosupport.demos.h4.classes

import com.infosupport.demos.h3.functions.lastChar

// The object keyword, companion objects -------------------------------------------------

// 1. Object declaration is a way to define a singleton. -------------------
// TODO show (unit tests) and tell

// Declare an 'object'
object Payroll {
    val allEmployees = arrayListOf<Employee>()

    fun calculateSalary() = allEmployees.sumBy { it.salary }
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
class User2 private constructor(val nickname: String) {
    companion object { // this is Kotlin's 'static'
        // instead of using inheritance, put creation logic here
        fun of(email: String) =
            if (email.contains('@'))
                User2(email.substringBefore('@')) // we can access the private constructor here
            else
                throw IllegalArgumentException("E-mail $email doesn't contain an '@'!")

        fun of(accountId: Int) =
            User2(getFacebookNameFromWeb(accountId))
    }
}

// Companion objects behave like a regular object: can have name, implement interface, have extension
class TempEmployee(name: String, salary: Int, val level: Int) : Employee(name, salary) {
    companion object Loader : JSONFactory<TempEmployee> { // note the name and the implementation
        override fun toJSON(e: TempEmployee) =
            """{ salary: ${e.salary}, level: ${e.level} }"""
    }
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
fun PermEmployee.Companion.someExtFunction() = "Nice...!"

// 3. Object expression is used instead of Java’s anonymous inner class -------------------
val comp = object : Comparator<PermEmployee> {
    override fun compare(p1: PermEmployee?, p2: PermEmployee?): Int {
        return p1?.salary?.minus(p2?.salary ?: 0) ?: 1
    }
}
