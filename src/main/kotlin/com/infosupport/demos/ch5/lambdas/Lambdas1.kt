package com.infosupport.demos.ch5.lambdas

// Lambda expressions and member references

fun main() {
    firstTaste()

    secondTaste()

    // findOldestClassic(people)
    // findOldestLambda(people)

    // syntax()

    // captureLocalVariables()

    // functionReferences()

    // creatingCollectionsRevisited()
}

fun firstTaste() {
    val printNumber = { n: Int -> println(n) }
    val printHello = { -> println("Hello") }
    val printHelloToo = { println("Hello too") }

    printNumber(42)
    printHello()
    printHelloToo()

    val sum2a = { a: Int, b: Int -> a + b }
    val sum2b: (Int, Int) -> Int = { a, b -> a + b }
    val sum3: (Int, Int, Int) -> Int = { a, b, c -> a + b + c }

    println(sum2a(1, 2))
    println(sum2b(1, 2))
    println(sum3(1, 2, 3))
}

fun secondTaste() {
    val okButton = Button()

    // We can pass some behaviour to the onClick function
    okButton.onClick {
        println("Ok button clicked.")
        println("Navigating to home page...")
    }

    // We can let another function execute the lambda
    okButton.click()

    // We can pass some different behaviour to the onClick function
    okButton.onClick {
        println("Ignoring clicks...")
    }

    okButton.click()
}

fun findOldestClassic(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun findOldestLambda(people: List<Person>) {
    val theOldest = people.maxByOrNull { it.age }
    println(theOldest)

    val firstInAlphabet = people.minByOrNull(Person::name) // member reference
    println(firstInAlphabet)
}

fun syntax() {
    // Syntax: see https://drek4537l1klr.cloudfront.net/jemerov/Figures/05fig01.jpg
    val sum = { x: Int, y: Int -> x + y } // define

    val result = sum(1, 2) // call
    println(result)

    // Removing verbosity
    people.maxByOrNull({ p: Person -> p.age })    // lambda argument should be moved out of method parentheses
    people.maxByOrNull() { p: Person -> p.age }   // remove parentheses
    people.maxByOrNull { p: Person -> p.age }     // infer type
    people.maxByOrNull { p -> p.age }             // remove parameter
    people.maxByOrNull { it.age }

    people.joinToString(",", transform = { p: Person -> p.name })
    people.joinToString(",", transform = { it.name })
    people.joinToString(",") { it.name }

    // Multiline lambda body; last expression is return value; no {}-block needed
    val logAndSum = { x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }
    val result2 = logAndSum(3, 4) // call
    println(result2)
}

fun captureLocalVariables() {
    val errors = listOf("403 Forbidden", "500 Internal server error", "404 Not Found").sortedBy { it.substring(0..2) }

    printMessages(errors, "Error:")
    printProblemCounts(errors)

    captureAndWrap()

    tryToCountButtonClicks(Button()) // this doesn't work! why?
    countButtonClicks(Button())
}

fun printMessages(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it") // captures local vars is allowed
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    // captures AND MODIFIES local vars; not allowed in Java, but allowed in Kotlin
    // vars automatically get copied into a wrapper object to the heap, see captureAndWrap below
    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

fun captureAndWrap() {
    var counter = 0             // var, so not final
    val inc = { ++counter }
    println("${inc()}, $counter")

    // ... gets converted under the hood to:
    class Ref<T>(var value: T)

    val counterRef = Ref(0)
    val incRef = { ++(counterRef.value) } // immediately invoke lambda with run {}
    println("${incRef()}, ${counterRef.value}")
}

fun tryToCountButtonClicks(button: Button) {
    var count = trackClicks(button)
    repeat(10) { count++ }
    println(count) // 10?
}

private fun trackClicks(button: Button): Int {
    var clicks = 0
    button.onClick { clicks++ }
    return clicks // why doesn't this work?
    /* ANSWER
        onClick is called AFTER this functions returns;
        when this function returns, clicks is still 0
     */
}

var clicks = 0

fun countButtonClicks(button: Button) {
    button.onClick { clicks++ }
    repeat(10) { button.click() }
    println(clicks) // 10?
}
// Lab 5ab

fun functionReferences() {
    // member reference (i.e. getter)
    val getAge = { person: Person -> person.age }
    val getAgeRef = Person::age

    // top level function with one parameter
    val runSalute = { s: String -> salute(s) } // simply delegates input to salute
    val runSaluteRef = ::salute

    // top level function with two parameters
    val action = { person: Person, message: String -> sendEmail(person, message) } // simply delegates input to sendEmail
    val actionRef = ::sendEmail // concise

    // constructor
    val ctor1a = { n: String -> Person(name = n) }
    val ctor1b = { a: Int -> Person(age = a) }
    val ctor2a = { n: String, a: Int -> Person(n, a) }
    val ctorAll = ::Person

    val p1 = ctor1a("Alice")
    val p2 = ctor1b(29)
    val p3 = ctor2a("Alice", 29)
    val p4 = ctorAll("Alice", 29, emptyList())

    // one-param function: returns a Person's age
    val dmitry = Person("Dmitry", 34)
    val personsAgeFunction = Person::age
    println(personsAgeFunction(dmitry))

    //  zero-argument function: returns dmitry's age
    val dmitrysAgeFunction = dmitry::age // possible since kotlin 1.1
    println(dmitrysAgeFunction())
}

fun sendEmail(person: Person, message: String) {
    println("Sending email to $person with message $message ...")
}

fun salute(s: String) = println("Salute $s!")

// Lab 5d

fun creatingCollectionsRevisited() {
    // Use immutable collections if you can: thread safe.
    val listOf = listOf(Person(age = 2), Person(age = 4), Person(age = 6))

    // adding is not allowed
    // listOf.add(..)

    // with _mutable_ collections, adding is allowed:
    val mutableListOf = mutableListOf<Person>()
    mutableListOf.addAll(listOf)
    mutableListOf.add(Person(age = 8))
    mutableListOf[3] = Person(age = 10)

    // Creating collections dynamically; note: List(i) is a function, not a constructor
    val immutableList2 = List(10) { it } // it = [0..9]
    val immutableList3 = List(5) { Person(age = it * 2) } // it = [0..4]

    println(immutableList2)
    println(immutableList3)
}

