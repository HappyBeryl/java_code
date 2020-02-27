package com.test;

import java.util.Arrays;

public class TestDemo {

    //阶乘
    public static int factor(int n) {
        if (n == 1) {
            return 1;
        }
        return n*factor(n-1);
    }

    public static int fibonacci(int n) {
        if(n==1 || n==2) {
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static int fibonacci2(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;
        for(int i=3; i<=n; i++) {
            f3 = f2+f1;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static int frogjump(int n) {
        if(n == 1 || n==2) {
            return n;
        }
//		int f1 = 1;
//		int f2 = 2;
//		int f3 = 0;
//		for(int i=3; i<=n; i++) {
//			f3 = f2+f1;
//			f1 = f2;
//			f2 = f3;
//		}
//		return f3;
        return  frogjump(n-1)+ frogjump(n-2);
    }

    static  int a = 100;
    int b = 20;
    public static void main(String[] args) {
        a = 10;
     //   b = 10; //error
        System.out.println(a);
    }

    public void func() {
        a = 10;
    }


}
