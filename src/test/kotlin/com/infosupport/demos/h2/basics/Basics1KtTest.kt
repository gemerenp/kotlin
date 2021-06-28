package com.infosupport.demos.h2.basics

import com.infosupport.demos.h2.something.max // import single function
import com.infosupport.demos.h2.something.maxExpressionBody
import org.junit.jupiter.api.Assertions.assertEquals // import static function
import org.junit.jupiter.api.Test

internal class Basics1KtTest {

    @Test
    fun testMax() {
        assertEquals(max(1, 2), 2)
        assertEquals(max(1), 1)
        assertEquals(max(-1), 0)
    }

    @Test
    fun testMaxExpressionBody() {
        assertEquals(maxExpressionBody(1, 2), 2)
    }
}
