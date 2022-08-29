package com.infosupport.demos.h4.classes

// Class delegation: using the “by” keyword.

fun main() {
    // Suppose we want to implement a collection but only override the contains method. Rest is same as arraylist.
    val list = listOf(4, 2, 42)

    val delegatingCollectionClassicStyle = DelegatingCollectionClassicStyle(list)
    println(delegatingCollectionClassicStyle.isEmpty())
    println(delegatingCollectionClassicStyle.contains(42))

    val delegatingCollection = DelegatingCollection(list)
    println(delegatingCollection.isEmpty())
    println(delegatingCollection.contains(42))
}

class DelegatingCollectionClassicStyle<T>(
    private val innerList: Collection<T> = arrayListOf()
) : Collection<T> {

    // only this method is really overridden with additional behaviour
    override fun contains(element: T): Boolean {
        println("Checking if ${this.javaClass.simpleName} contains $element ...")
        return innerList.contains(element)
    }

    // these methods have to be explicitly overridden and they simply delegate to innerList; boilerplate code.
    override val size: Int get() = innerList.size
    override fun isEmpty() = innerList.isEmpty()
    override fun iterator() = innerList.iterator()
    override fun containsAll(elements: Collection<T>) = innerList.containsAll(elements)
}

class DelegatingCollection<T>(
    private val innerList: Collection<T> = arrayListOf()
) : Collection<T> by innerList { // note the `by` keyword

    override fun contains(element: T): Boolean {
        println("Checking if ${this.javaClass.simpleName} contains $element ...")
        return innerList.contains(element)
    }

    // all others are automatically overridden and they delegate to innerList!

}

// Lab 3d
