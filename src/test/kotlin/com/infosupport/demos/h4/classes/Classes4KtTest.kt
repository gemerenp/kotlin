package com.infosupport.demos.h4.classes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import com.infosupport.demos.h4.classes.ExprSealed.Num as Num2
import com.infosupport.demos.h4.classes.ExprSealed.Sum as Sum2

internal class Classes4KtTest {

    @Test
    fun eval() {
        val result = eval(
            Sum(
                Sum(Num(1), Num(2)),     // 1 + 2
                Num(4)
            )
        )                 //       + 4

        assertThat(result).isEqualTo(7); //           = 7
    }

    @Test
    fun eval2() {
        val result = eval2(
            Sum2(
                Sum2(Num2(1), Num2(2)), // 1 + 2
                Num2(4)
            )
        )               //       + 4

        assertThat(result).isEqualTo(7); //           = 7
    }
}
