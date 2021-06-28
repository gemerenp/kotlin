package com.infosupport.demos.h5.lambdas

class Button {
    private lateinit var doClick: () -> Unit

    fun onClick(function: () -> Unit) {
        this.doClick = function
    }

    fun click() {
        doClick()
    }
}
