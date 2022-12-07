package com.infosupport.labs.ch4

open class Transport

data class Train(
    val line: String
) : Transport()

data class Bus(
    val number: String,
    val capacity: Int
) : Transport()

fun travel(transport: Transport) =
    when (transport) {
        is Train -> "Train ${transport.line} "
        is Bus -> "Bus ${transport.number} " +
                "has size ${transport.capacity} "

        else -> "$transport is in limbo!"
    }

fun main() {
    println(
        listOf(Train("S1"), Bus("11", 90)).map { travel(it) }
    )
}
