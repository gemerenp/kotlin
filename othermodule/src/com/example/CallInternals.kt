package com.example

import com.infosupport.demos.ch4.classes.MyRichButton

fun main() {
    // OK: public
    val r = MyRichButton(3)

    // NOK: internal
    // r.moduleInternals()
    // val t = TalkativeButton()
}
