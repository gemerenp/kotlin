package com.infosupport.demos.ch4;

public class ConstructorChaining {
    // In Java a call to this(..) is optional:

    ConstructorChaining() {

    }

    ConstructorChaining(int i) {
        if(i % 2 == 0) System.out.println("...");
    }

    ConstructorChaining(int i, String s) {
        this(i);
    }
}
