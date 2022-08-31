package com.infosupport.demos.ch4;

public class Outer {

    private int i;

    public void method() {}

    class Inner {

        private int i;

        public void methodInner(){
            int iInner = this.i;
            int outerI = Outer.this.i;
            method();
        }
    }

    public static void method2() {

    }

    static class StaticInner {
        // public void methodInner(){
        //     method();
        // }
    }

    public static void main(String[] args) {
        var si = new com.infosupport.demos.ch4.Outer.StaticInner();
        var s = new com.infosupport.demos.ch4.Static();

        Outer outer = new Outer();
        int i = outer.i;

        outer.new Inner();
    }

}
