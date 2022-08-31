package com.infosupport.demos.ch2.basics

import com.infosupport.demos.ch2.something.max
import com.infosupport.demos.ch2.something.maxExpressionBody
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Basics1KtTest : WithAssertions {

    @Test
    fun testMax() {
        assertThat(max(1, 2)).isEqualTo(2)
        assertEquals(max(1), 1)
        assertEquals(max(-1), 0)
    }

    @Test
    fun testMaxExpressionBody() {
        assertEquals(maxExpressionBody(1, 2), 2)
    }
}
