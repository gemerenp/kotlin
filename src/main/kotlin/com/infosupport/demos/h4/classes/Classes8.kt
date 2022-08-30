package com.infosupport.demos.h4.classes

// Class delegation: using the “by” keyword.

fun main() {
    // Suppose we want to implement a collection but only override the `contains` method. Rest is same as arraylist.
    // We can apply the decorator pattern here. We decorate the original ArrayList.contains with something else
    // and all the other methods are just delegated to the arraylist. So we wrap the arraylist in a new class.
    val list = listOf(4, 2)

    val hitchhikerCollectionClassicStyle = HitchhikerCollectionClassicStyle(list)
    println(hitchhikerCollectionClassicStyle.isEmpty())
    println(hitchhikerCollectionClassicStyle.contains(42))

    val hitchhikerCollection = HitchhikerCollection(list)
    println(hitchhikerCollection.isEmpty())
    println(hitchhikerCollection.contains(42))
}

// Delegation design pattern
class HitchhikerCollectionClassicStyle(
    private val inner: Collection<Int> = arrayListOf() // wrapped arraylist
) : Collection<Int> {

    // only this method is really overridden with additional behaviour
    override fun contains(element: Int): Boolean {
        println("Checking if ${this.javaClass.simpleName} contains $element ...")
        return if (element == 42) true else inner.contains(element)
    }

    // these methods have to be explicitly overridden, and they simply delegate to innerList; boilerplate code :-(
    override val size: Int get() = inner.size
    override fun isEmpty() = inner.isEmpty()
    override fun iterator() = inner.iterator()
    override fun containsAll(elements: Collection<Int>) = inner.containsAll(elements)
}

class HitchhikerCollection(
    private val inner: Collection<Int> = arrayListOf() // wrapped arraylist
) : Collection<Int> by inner { // note the `by` keyword

    override fun contains(element: Int): Boolean {
        println("Checking if ${this.javaClass.simpleName} contains $element ...")
        return if (element == 42) true else inner.contains(element)
    }

    // all others are automatically overridden and they delegate to innerList!

}

// Lab 3d
