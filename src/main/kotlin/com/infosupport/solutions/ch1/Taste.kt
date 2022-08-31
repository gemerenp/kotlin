package com.infosupport.solutions.ch1

import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class Article(
    val id: Long,
    val description: String,
    val price: BigDecimal? = ZERO,
)

fun main() {
    val tv = Article(1, "TV")
    val book = Article(2, "Book", price = BigDecimal("15.95"))
    val set = setOf(
        tv, tv,
        book,
        Article(3, description = "CD", price = BigDecimal("5.95"))
    )

    println(set)

    val cheapestArticle = set.minByOrNull { it.price ?: ZERO }
    println(cheapestArticle)

    val cds: Article? = set.find { it.description == "CD" }
    println(cds?.id ?: "not found")
}
