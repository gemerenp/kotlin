package com.infosupport.demos.h3.functions;

public class JvmNameDemo {
    public static void main(String[] args) {
        // Because we used @JvmName, we can use Util here instead of Functions3Kt

        Util.reportOperationCount();
        Util.performOperation();
        Util.performOperation();
        Util.performOperation();
        Util.reportOperationCount();

        // top level properties will get a getter and/or setter
        Util.getOpCount();
        Util.setOpCount(6);
        Util.getI();

        // top level const will not get a getter
        var unixLineSeparator = Util.UNIX_LINE_SEPARATOR;
    }
}
