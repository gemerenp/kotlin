package com.infosupport.demos.h2.basics

import com.infosupport.demos.h2.basics.Color.*
import org.assertj.core.api.WithAssertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class PersonTest : WithAssertions { // internal: visible everywhere in the same module

    @Test
    fun isFirst() {
        val bob = Person("Bob", true)
        assertFalse(bob.startsWithA)

        val alice = Person("Alice", true)
        assertTrue(alice.startsWithA)
    }

    @Test
    fun whenTest() {
        val blue = BLUE
        val yellow = YELLOW
        val green = GREEN
        val rgbColor = RGBColor.BLUE

        val madonna = Person("Madonna", true, blue)

        assertThat(madonna.getWarmth()).isEqualTo("cold")

        assertThat(madonna.mix(yellow)).isEqualTo(green)

        assertThat(madonna.smartIf(yellow)).isEqualTo(yellow.name)
        assertThat(madonna.smartIf(rgbColor)).isEqualTo(rgbColor.rgb().toString())
        assertThat(madonna.smartIf("pink")).isEqualTo("unknown")

        assertThat(madonna.smartWhen(yellow)).isEqualTo(yellow.name)
        assertThat(madonna.smartWhen(rgbColor)).isEqualTo(rgbColor.rgb().toString())
        assertThat(madonna.smartWhen("pink")).isEqualTo("unknown")
    }
}
