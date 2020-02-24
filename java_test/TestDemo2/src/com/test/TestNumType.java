package com.test;

public class TestNumType {
    public static void main1(String[] args) {
        int a; //无法编译
        int b = 1;
        System.out.println(b);

        long c = 100;
        System.out.println(c);

        double num = 1.1;
        System.out.println(num * num);
    }

    public static int sum(int a, int b) {
        return a+b;
    }

    public static int sum(int a, int b, int c) {
        return a+b+c;
    }

    public static void main(String[] args) {
        int ret = sum(3,4);
        System.out.println(ret);
    }
}
