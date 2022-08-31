// Top-level functions and properties

@file:JvmName("Util") //  See JvmNameDemo.java

package com.infosupport.demos.ch3.functions

// Top level properties:
var opCount = 0       // Java: private with getter/setter; decompile Util.class with external Java decompiler e.g. jd-gui.exe
val i = 4             // Java: private static final with getter
    get() = field * 3 // field is a keyword and represents the backing field

const val UNIX_LINE_SEPARATOR = "\n" // Java: *public* static final
//                                            Why? To make its use from Java more natural than with val i above.
//                                            See JvmNameDemo.java

// Top level functions:
fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    print("Operation performed $opCount times $UNIX_LINE_SEPARATOR")
}

fun main() {
    reportOperationCount()
    performOperation()
    performOperation()
    performOperation()
    reportOperationCount()
}

// Lab 2abc
