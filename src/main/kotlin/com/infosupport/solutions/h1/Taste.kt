package com.infosupport.solutions.h1

import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class Article(
    val id: Long,
    val description: String,
    val price: BigDecimal? = ZERO,
    private var pr2: Double = 0.0
){
    operator fun plus(book: Article): Any? {
        return pr2 + book.pr2
    }

}

fun main() {
    val tv = Article(1, "TV")
    val book = Article(2, "Book", price = BigDecimal("15.95"))
    val set = setOf(
        tv, tv,
        book,
        Article(3, description = "CD", price = BigDecimal("5.95"))
    )

    println(set)

    val minBy = set.minByOrNull { it.price ?: ZERO }
    println(minBy)

    val find: Article? = set.find { it.description == "CD" }
    println(find?.id ?: "not found")
}
