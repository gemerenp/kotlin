package com.infosupport.demos.h4.classes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class Classes9KtTest {

    private val employees = listOf(Employee("Bram", 1000), Employee("Sjaak", 50))

    init {
        Payroll.allEmployees.clear()
        Payroll.allEmployees.addAll(employees)
    }

    @Test
    fun calculateSalaryOnObject() {
        assertThat(Payroll.calculateSalary()).isEqualTo(1050)
    }

    @Test
    fun sortWithComparatorAsAnonymousInnerClass() {
        // Java 7 style
        val allEmployeesSorted = Payroll.allEmployees.sortedWith(
            object : Comparator<Employee> { // note the keyword 'object'
                override fun compare(o1: Employee, o2: Employee) = o1.salary - o2.salary
            }
        )

        assertThat(Payroll.allEmployees[0].name).isEqualTo("Bram")
        assertThat(allEmployeesSorted[0].name).isEqualTo("Sjaak")
    }

    @Test
    fun sortWithComparatorAsStandAloneObject() {
        val allEmployeesSorted = Payroll.allEmployees.sortedWith(SalaryComparator)

        assertThat(Payroll.allEmployees[0].name).isEqualTo("Bram")
        assertThat(allEmployeesSorted[0].name).isEqualTo("Sjaak")
    }

    @Test
    fun sortWithComparatorAsNestedObject() {
        val allEmployeesSorted = Payroll.allEmployees.sortedWith(Employee.LastCharOfNameComparator)

        assertThat(Payroll.allEmployees[0].name).isEqualTo("Bram")
        assertThat(allEmployeesSorted[0].name).isEqualTo("Sjaak")
    }

    @Test
    fun createUsersWithCompanionObject() {
        val accountId = 473457654
        val name = "myname"

        val userOfAccountId = User2.of(accountId) // like call to static method in Java
        val userOfEmail = User2.of("${name}@email.com")

        assertThat(userOfAccountId.nickname).isEqualTo("fb:$accountId")
        assertThat(userOfEmail.nickname).isEqualTo(name)

        assertThrows<IllegalArgumentException> { User2.of("${name}_at_email.com") }
    }

    @Test
    fun toJSONWithCompanionObject() {
        val t = TempEmployee("Harry", 3000, 4)

        // call can be named or unnamed
        TempEmployee.Loader.toJSON(t)
        TempEmployee.toJSON(t)
    }

    @Test
    fun saveToJsonUsingCompanionObject() {
        val t = TempEmployee("Harry", 3000, 4)

        // pass companion object as jsonfactory
        val json = saveToJSON(t, TempEmployee.Loader)
        assertThat(json).contains("salary: 3000")
        assertThat(json).contains("level: 4")

        // ... or unnamed
        val json2 = saveToJSON(t, TempEmployee)
        assertThat(json2).contains("salary: 3000")
        assertThat(json2).contains("level: 4")
    }

    @Test
    fun callExtensionFunctionOfCompanionObject() {
        // call someExtFunction (named or unnamed) just like a static method in Java
        assertThat(PermEmployee.Companion.someExtFunction()).isEqualTo("Nice...!")
        assertThat(PermEmployee.someExtFunction()).isEqualTo("Nice...!")
    }
}
