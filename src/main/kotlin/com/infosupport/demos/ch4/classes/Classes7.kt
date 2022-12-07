package com.infosupport.demos.ch4.classes

// Sealed classes: defining restricted class hierarchies and smart casts

// Suppose you have to implement expressions to sum a few numbers.
// See demo unit test.

// Solution 1: as interface implementations -------------------
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression") // default branch required

        /*  TODO tell
            Always having to add a default branch isn’t convenient.
            What’s more, if you add a new subclass, the compiler won’t detect
            that something has changed. If you forget to add a new branch,
            the default one will be chosen, which can lead to subtle bugs.
        */
    }

// Solution 2: as sealed classes -------------------------------
// See Figure 4.2. Sealed classes can’t have inheritors defined outside of the class: https://drek4537l1klr.cloudfront.net/jemerov/Figures/04fig02_alt.jpg
sealed interface ExprSealed {
    class Num(val value: Int) : ExprSealed
    class Sum(val left: ExprSealed, val right: ExprSealed) : ExprSealed
}

fun evalSealed(e: ExprSealed): Int =
    when (e) {
        is ExprSealed.Num -> e.value // note the import alias
        is ExprSealed.Sum -> evalSealed(e.right) + evalSealed(e.left)
        // ExprSealed is sealed: you don’t need to provide the else branch
    }

// Lab 2
// Lab 3c
