package com.innerclass;

/*
实例内部类
 */
public class OuterClass {
    public int data1 = 1;
    public int data2 = 2;
    public int data3 = 3;


    public OuterClass() {
        System.out.println("OuterClass()");
    }

    class InnerClass {
        public int data4 = 4;

        public int data1 = 11;
        public final static int size = 10;
        public InnerClass() {
            System.out.println("InnerClass()");
        }

        public void test() {
            System.out.println("data1:"+data1); //1
            System.out.println("data1:"+this.data1); //11
            System.out.println("out::data1:"+ OuterClass.this.data1); //1
            System.out.println("data1:"+data1);
        }
    }

}

/*
静态内部类
 */


class OuterClass2 {
    public int data1 = 1;
    private int data2 = 2;
    int data3 = 3;
    public static int data5 = 10;

    public OuterClass2() {
        System.out.println("OuterClass2()");
    }


    static class InnerClass2 {
        public int data1 = 4;
        public static  int data5 = 5;

        OuterClass2 outerClass;

        public InnerClass2() {
            System.out.println("static::InnerClass2()");
        }

        //传入外部类对象的引用
        public  InnerClass2(OuterClass2 o) {
            this.outerClass = o;
            System.out.println("static::InnerClass2(OuterClass o)");
        }

        public void test() {
            System.out.println("data1:" + this.outerClass.data1); //不能访问
            System.out.println(data1); //4
            System.out.println("data5:"+data5); //5
            System.out.println("data5:" + OuterClass2.data5); //10
            System.out.println("InnerClass2::test()");
        }
    }

}

