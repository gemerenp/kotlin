package com.infosupport.solutions.h4

sealed class Transport {
    abstract val capacity: Int
}

data class Train(
    val line: String, override val capacity: Int = 100
) : Transport()

data class Bus(
    val number: String, override val capacity: Int
) : Transport()

data class Tram(
    val route: String, override val capacity: Int
) : Transport()

data class Plane(
    val flightNumber: String, override val capacity: Int
) : Transport()


fun travel(transport: Transport) =
    when (transport) {
        is Train -> "Train ${transport.line} "
        is Bus -> "Bus ${transport.number} "
        is Tram -> "Tram ${transport.route} "
        is Plane -> "Plane ${transport.flightNumber} "
    } + "has size ${transport.capacity}"

fun main() {
    println(
        listOf(Train("S1"), Bus("11", 90), Tram("L8", 60), Plane("KX345", 300))
            .map(::travel).toString()
    )
}
