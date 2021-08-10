package com.infosupport.demos.h5.lambdas

class Button {
    private lateinit var doClick: () -> Unit

    fun onClick(f: () -> Unit) {
        this.doClick = f
    }

    fun click() {
        doClick()
    }
}
