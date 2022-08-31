package com.infosupport.demos.ch3.functions;

public class JvmNameDemo {
    public static void main(String[] args) {
        // Because we used @JvmName, we can use Util here instead of Functions3Kt

        Util.reportOperationCount();
        Util.performOperation();
        Util.performOperation();
        Util.performOperation();
        Util.reportOperationCount();

        // top level properties will get a getter and/or setter
        int opCount1 = Util.getOpCount();
        Util.setOpCount(6);
        int opCount2 = Util.getOpCount();

        int i = Util.getI();

        // top level const does not have a getter
        var unixLineSeparator = Util.UNIX_LINE_SEPARATOR;
    }
}
