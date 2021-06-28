package com.infosupport.demos.h6.types

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MyServiceTest {
    // TODO uncomment all comments and make this compile using:
    // 1. MyService? = null and non null assertions
    // 2. lateinit (and show what happens if you forget to initialize it)

    // private var myService: MyService

    // lateinit is useful when using frameworks, like DI, Android's onCreate and JUnit's @BeforeEach.

    @BeforeEach
    fun setUp() {
        // myService = MyService()
    }

    @Test
    fun testPerformAction() {
        // val performAction = myService.performAction()
        // Assertions.assertEquals("foo", performAction)
    }
}


