package com.infosupport.demos.ch3.functions

import com.infosupport.demos.ch4.classes.Payroll.calculateSalary
import kotlin.jvm.JvmStatic

object ObjectDemo {
    @JvmStatic
    fun main(args: Array<String>) {
        calculateSalary()
    }
}
