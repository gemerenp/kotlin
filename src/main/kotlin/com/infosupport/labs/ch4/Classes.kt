package com.infosupport.labs.ch4

// 1. Create a class C with:
//  - a primary constructor declaring:
//      - one Int property `prop`
//      - one private Int property `privProp1`
//      - one separate String parameter `param`
//  - a private String property `privProp2`
//  - an implementation of the primary constructor:
//      - store `param` in `privProp2`
//  - a method `m` that modifies and returns `privProp2`
//  - a custom getter and setter for `privProp2`
//  - a secondary constructor with
//      - an Int `param2` which is stored in `prop`
//      - default values for the primary constructor parameters
//  - a subclass S with:
//      - a primary constructor which reuses the secondary constructor of C
//      - an override for `m` which calls `C.m` twice

// 2. Study the file UnSealed.kt in this package.
//    a) Now, modify it:
//      - add a new subclass Tram with its own property route: String
//      - add a tram to the list in main and show that a tram isn't printed correctly yet
//      - make Transport sealed and add an abstract property capacity: Int to it
//      - fix the current subclasses to override capacity; you can choose defaults for capacity wherever you want
//      - remove the else branch from travel and replace with a specific branch for Tram
//      - fix and refactor fun travel; prevent code duplication
//      - add a new subclass Plane with its own property flightNumber: String and make everything work
//    b) Print the names of all the subclasses of the super class Transport. Use `Transport::class.sealedSubclasses` for that.

// 3. Select some (or all) of the following exercises from Atomic Kotlin:
//    Object-Oriented Programming        Exercise
//      a) Complex Constructors          1
//      b) Secondary Constructors        2
//      c) Class Delegation              1
//      d) Objects                       3 (use the main function below: )

//          fun main() {
//              MonkeysVsSnakes.populate()
//              MonkeysVsSnakes.characters eq "[Monkey, Snake]"
//          }


