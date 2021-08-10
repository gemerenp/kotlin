package com.infosupport.labs.h6

// 1. Create and show an array of fibonaccinumbers, but when the number is even, put null.
//    To find the n-th fibonacci number, you can use the previously given sequence
//    com.infosupport.demos.h5.lambdas.fibonacci() or use the recursive function below.
//    Please think about the efficiency of your algorithm!

fun fibo(n: Int): Int = if (n <= 2) n else fibo(n - 1) + fibo(n - 2)

// 2. Select some (or all) of the following exercises from Atomic Kotlin (start with one of each subject):
//    Usability                             Exercise
//      - Nullable types                    1, 3
//      - Safe Calls & the Elvis Operator   1, 2, 3
//      - Non-Null Assertions               1
//      - Extensions for Nullable Types     1, 2
//    Power Tools
//      - Late Initialization               3
//    Introduction to Objects
//      - Objects Everywhere                4
