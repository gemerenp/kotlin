package com.infosupport.demos.h2.basics

import com.infosupport.demos.h2.basics.Color.*
import java.time.LocalDate

// TODO show and tell

fun main() { // main without args

    val a = A() // default ctor call
    val b = B("x")
    val c = C("x")
    val d1 = D("x")
    val d2 = D("x", "Y")

    // class w/ properties
    val person = Person("Bob", true) // ctor call

    println(person.name)        // default "getter" of val property
    println(person.isMarried)   // default "getter" of var property
    println(person.age)         // explicit default getter
    println(person.startsWithA)     // explicit custom getter
    println(person.eyesColor)
    println(person.firstLetter) // extension property

    person.age = 90 // setter call

    // see PersonTest for tests

    // standalone val with/without accessor
    println("foo:")
    println("$foo1 $foo1") // run executed once
    println("$foo2 $foo2") // get executed each time
}

// CLASS --------------------------------------------------------------------
// - constructor
// - fields
// - properties
//      - im-/mutable

// very simple class
class A

// simple class
class B constructor(val x: String) // primary ctor with one property

// simple class like B but less concise
class C(anX: String) { // primary ctor with one param (If the primary constructor does not have any annotations or visibility modifiers, the constructor keyword can be omitted)

    val x: String // field

    init { // primary ctor implementation
        this.x = anX
    }
}

// class with two properties, primary and secondary ctor
class D(val x: String) {

    var anY: String = ""

    constructor(anX: String, anY: String) : this(anX) {
        this.anY = anY
    }
}

/* Java */
/*
public class Person {
    private final String name;
    private boolean isMarried;
    // ...

    public Person(String name) { this.name = name; }
    public String getName() { return name; }
    public void setIsMarried(boolean m) { this.isMarried = m; }
    // ...
}*/

// class with more properties
class Person( // implicitly public final
    val name: String, // immutable prop (field + getter)
    var isMarried: Boolean, // mutable prop (field + getter + setter) without default value (so mandatory parameter)
    val eyesColor: Color = BLUE // with default value (so optional parameter)
) {
    var age: Int = 0 // mutable prop with explicit getter/setter; must be initialized
        get() {
            return field // field is a keyword! backing field.
        }
        set(value) {
            field = value
        }

    var birthDate: LocalDate = LocalDate.MIN
        private set // hide setter for outside; only accessible inside class

    val startsWithA  // immutable prop with custom getter; type is inferred
        get() = name.startsWith("A") // with expression body
        // no setter: val

    // when expression
    fun getWarmth() =
        when (this.eyesColor) { // implicitly public final
            RED, ORANGE, YELLOW -> "warm"
            GREEN -> "neutral"
            BLUE, INDIGO, VIOLET -> "cold"
        }

    // when on other objects
    fun mix(c: Color) =
        when (setOf(this.eyesColor, c)) {
            setOf(RED, YELLOW) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            setOf(BLUE, VIOLET) -> INDIGO
            else -> throw Exception("Dirty color")
        }

    // smart casts
    fun smartIf(a: Any) = // Any is java.lang.Object
        if (a is Color) {
            a.name // Java: Color c = (Color) a; return c.name;
        } else if (a is RGBColor) {
            a.rgb().toString()
        } else {
            "unknown"
        }

    fun smartWhen(a: Any) =
        when (a) {
            is Color -> a.name // single line
            is RGBColor -> { // block
                val rgb = a.rgb()
                rgb.toString()
            }
            else -> "unknown"
        }
}

// Extension property --------------------------------------------------------------------
val Person.firstLetter: Char
    get() = this.name[0]

// Extension function --------------------------------------------------------------------
fun Person.lastLetter(): Char {
    return this.name.last()
}

// ENUMS --------------------------------------------------------------------

// simple
enum class Color { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }

// with props and fun
enum class RGBColor(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238); // semi colon!!

    fun rgb() = (r * 256 + g) * 256 + b
}

// Top level properties (standalone val with/without accessor) ---------------------------

val foo1 = run {
    println("Calculating run ...")
    42
}

val foo2: Int
    get() {
        println("Calculating get...")
        return 42
    }

// See Basics3 for more...
