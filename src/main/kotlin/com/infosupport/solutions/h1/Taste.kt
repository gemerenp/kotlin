package com.infosupport.solutions.h1

import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class Article(
    val id: Long,
    val description: String,
    val price: BigDecimal? = ZERO
)

fun main() {
    val set = setOf(
        Article(1, "TV"),
        Article(1, "TV"),
        Article(2, "Book", price = BigDecimal("15.95")),
        Article(3, description = "CD", price = BigDecimal("5.95"))
    )

    println(set)

    val minBy = set.minByOrNull { it.price ?: ZERO }
    println(minBy)

    val find: Article? = set.find { it.description == "CD" }
    println(find?.id ?: "not found")
}
