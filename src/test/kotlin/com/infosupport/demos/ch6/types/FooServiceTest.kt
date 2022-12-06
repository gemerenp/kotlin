package com.infosupport.demos.ch6.types

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

// lateinit is useful when using frameworks like JUnit's @BeforeEach, DI, Android's onCreate

internal class FooServiceTest {

    // Uncomment all and make it compile using either:
    //   - private var target: FooService? = null
    //   - private lateinit var target: FooService

    // private var target: FooService
    //
    // @BeforeEach
    // fun setUp() {
    //      target = FooService()
    // }
    //
    // @Test
    // fun testPerformAction() {
    //     val performAction = target.performAction()
    //     assertEquals("foo", performAction)
    // }
}


