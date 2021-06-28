// Top-level functions and properties

// TODO tell: changes the name of the generated class that contains Kotlin top-level functions. See JvmNameDemo.java
@file:JvmName("Util")

package com.infosupport.demos.h3.functions

// TODO tell: top level properties.
var opCount = 0                      // Java: private with getter/setter; decompile Util.class with external Java decompiler e.g. jd-gui.exe
val i = 0                            // Java: private final with getter
const val UNIX_LINE_SEPARATOR = "\n" // Java: public static final

// TODO tell: top level functions.
fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    print("Operation performed $opCount times $UNIX_LINE_SEPARATOR")
}

// TODO show
fun main() {
    reportOperationCount()
    performOperation()
    performOperation()
    performOperation()
    reportOperationCount()
}


