package com.infosupport.demos.ch4.classes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import com.infosupport.demos.ch4.classes.ExprSealed.Num as NumSealed
import com.infosupport.demos.ch4.classes.ExprSealed.Sum as SumSealed

internal class Classes7KtTest {

    @Test
    fun eval() {
        val result = eval(
            Sum(
                Sum(Num(1), Num(2)),     // 1 + 2
                Num(4)
            )                            //   + 4
        )

        assertThat(result).isEqualTo(7); //           = 7
    }

    @Test
    fun eval2() {
        val result = evalSealed(
            SumSealed(
                SumSealed(NumSealed(1), NumSealed(2)), // 1 + 2
                NumSealed(4) //                             + 4
            ) //                                                 = 7
        )
        assertThat(result).isEqualTo(7)
    }
}
