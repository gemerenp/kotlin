// Top-level functions and properties

// TODO tell: changes the name of the generated class that contains Kotlin top-level functions.
@file:JvmName("Util") //  See JvmNameDemo.java

package com.infosupport.demos.h3.functions

// TODO tell: top level properties.
var opCount = 0                      // Java: private with getter/setter; decompile Util.class with external Java decompiler e.g. jd-gui.exe
val i = 0                            // Java: private static final with getter
    get() = field * 3

const val UNIX_LINE_SEPARATOR = "\n" // Java: public static final
//                                            Why? To make its use from Java more natural than with val.
//                                            See JvmNameDemo.java

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


