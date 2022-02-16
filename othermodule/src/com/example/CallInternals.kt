package com.example

import com.infosupport.demos.h4.classes.MyRichButton

fun main() {
    // OK: public
    val r = MyRichButton(3)

    // NOK: internal
    // r.internals()
    // val t = TalkativeButton()
}
