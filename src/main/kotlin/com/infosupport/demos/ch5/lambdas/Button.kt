package com.infosupport.demos.ch5.lambdas

class Button {
    private lateinit var doClick: () -> Unit

    fun onClick(f: () -> Unit) {
        this.doClick = f
    }

    fun click() {
        doClick()
    }
}
