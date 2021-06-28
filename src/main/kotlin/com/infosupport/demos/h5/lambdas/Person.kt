package com.infosupport.demos.h5.lambdas

import com.infosupport.demos.h5.lambdas.Instrument.Companion.guitar
import com.infosupport.demos.h5.lambdas.Instrument.Companion.keyboard
import com.infosupport.demos.h5.lambdas.Instrument.Companion.vocal

data class Person(val name: String = "", var age: Int = 0, var instruments: List<Instrument> = emptyList())

data class Instrument(val name: String) {
    companion object {
        val keyboard = Instrument("Keyboard")
        val guitar = Instrument("Guitar")
        val vocal = Instrument("Vocal")
    }
}

val people = listOf(
    Person("Alice", 29),
    Person("Bob", 31),
    Person("Kurt", 27, listOf(guitar, vocal)),
    Person("Jim", 27, listOf(keyboard, vocal)),
    Person("Amy", 27, listOf(vocal)),
    Person("Janis", 27, listOf(vocal))
)

