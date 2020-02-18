package com.innerclass;

public class TestOuterClass {
    public static void main1(String[] args) {
        //获取内部类对象
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

        //获取内部类对象写法2：
        //     OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.test();
    }

    public static void main2(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        //获取静态内部类对象
        OuterClass2.InnerClass2 innerClass2 = new OuterClass2.InnerClass2(outerClass2);
        innerClass2.test();
    }



}
