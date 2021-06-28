package com.infosupport.demos.h4.classes

// Sealed classes: defining restricted class hierarchies and smart casts

// TODO show: demo unit test

// Assignment: implement expressions to sum a few numbers.

// Solution 1: as interface implementations -------------------
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown expression") // default branch required

        /*  TODO tell
            Always having to add a default branch isn’t convenient.
            What’s more, if you add a new subclass, the compiler won’t detect
            that something has changed. If you forget to add a new branch,
            the default one will be chosen, which can lead to subtle bugs.
        */
    }

// Solution 2: as sealed classes -------------------------------
// See Figure 4.2. Sealed classes can’t have inheritors defined outside of the class: https://livebook.manning.com/book/kotlin-in-action/chapter-4/98
sealed class ExprSealed {
    class Num(val value: Int) : ExprSealed()
    class Sum(val left: ExprSealed, val right: ExprSealed) : ExprSealed()
}

fun eval2(e: ExprSealed): Int =
    when (e) {
        is ExprSealed.Num -> e.value
        is ExprSealed.Sum -> eval2(e.right) + eval2(e.left)
        // Expr2 is sealed: you don’t need to provide the default branch
    }



