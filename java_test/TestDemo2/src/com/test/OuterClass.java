package com.test;


public class OuterClass {
    private int a = 10;
    private int b = 20;

    class InnerClass {
        int c = 11;
    }

    static class InnerClass2 {
        int d = 22;
    }


    public static void main(String[] args) {
        //实例
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        //静态
        OuterClass.InnerClass2 innerClass2 = new OuterClass.InnerClass2();

    }


}
