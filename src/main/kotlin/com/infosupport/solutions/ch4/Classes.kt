package com.infosupport.solutions.ch4

// 1.
open class C(var prop: Int, private val privProp1: Int, param: String) {
    private var privProp2: String = ""
        get() = "$field + $privProp1!"
        set(value) {
            if (value.length > 5) {
                field = value
            }
        }

    init {
        privProp2 = param
    }

    constructor(param2: Int) : this(42, 42, "42") {
        prop = param2
    }

    open fun m(): String {
        privProp2 = "Something else"
        return privProp2
    }

}

class S : C(1337) {
    override fun m(): String {
        return super.m() + super.m()
    }
}

fun main() {
    println(C(40, 41, "42").m())
    println(S().m())
}

// 2.
// See Atomic Kotlin

// 3.
// See Sealed.kt
