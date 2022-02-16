package com.infosupport.demos.h6.types

// lateinit is useful when using frameworks like JUnit's @BeforeEach, DI, Android's onCreate

internal class LateinitTest {

    // Uncomment all and make it compile using either:
    //   - private var target: Lateinit? = null
    //   - private lateinit var target: Lateinit

    // private var target: Lateinit
    //
    // @BeforeEach
    // fun setUp() {
    //      target = Lateinit()
    // }
    //
    // @Test
    // fun testPerformAction() {
    //     val performAction = target.performAction()
    //     Assertions.assertEquals("foo", performAction)
    // }
}


