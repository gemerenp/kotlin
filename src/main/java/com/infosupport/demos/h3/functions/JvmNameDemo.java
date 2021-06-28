package com.infosupport.demos.h3.functions;

public class JvmNameDemo {
    public static void main(String[] args) {
        // Because we used @JvmName, we can use Util here instead of Functions3Kt

        Util.reportOperationCount();
        Util.performOperation();
        Util.performOperation();
        Util.performOperation();
        Util.reportOperationCount();
    }
}
