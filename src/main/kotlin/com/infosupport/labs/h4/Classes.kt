package com.infosupport.labs.h4

// 0. Create a class C with:
//  - a private field `_f`
//  - a primary constructor declaring:
//      - one property `prop`
//      - one private field `priv`
//      - one separate param `p`
//  - an implementation of the primary constructor:
//      - save `param` in `_f`
//  - a method `m` that modifies and returns `_f`
//  - a custom getter and setter for `prop`
//  - a secondary constructor
//  - a subclass S with:
//      - a primary constructor which reuses the primary ctor of C
//      - an override for `m` which calls `C.m` twice

// 1. Study the file UnSealed.kt in this package.
//    Now, modify it:
//      - add a new subclass Tram with its own property route: String
//      - add a tram to the list in main and show that a tram isn't printed correctly yet
//      - make Transport sealed and add an abstract property capacity: Int to it
//      - fix the current subclasses to override capacity; you can choose defaults for capacity wherever you want
//      - remove the else branch from travel and replace with a specific branch for Tram
//      - fix and refactor fun travel; prevent code duplication
//      - add a new subclass Plane with its own property flightNumber: String and make everything work

// 2. Select some (or all) of the following exercises from Atomic Kotlin:
//    Object-Oriented Programming        Exercise
//      a) Complex Constructors          1
//      b) Secondary Constructors        2
//      c) Sealed Classes                2
//      d) Class Delegation              1
//      e) Objects                       3 (use the main function below: )

//          fun main() {
//              MonkeysVsSnakes.populate()
//              MonkeysVsSnakes.characters eq "[Monkey, Snake]"
//          }


