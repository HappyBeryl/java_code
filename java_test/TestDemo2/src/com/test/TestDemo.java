package com.test;

import java.util.Arrays;
import java.util.Scanner;

import static com.sun.xml.internal.ws.util.VersionUtil.compare;

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
    public static void main1(String[] args) {
        a = 10;
     //   b = 10; //error
        System.out.println(a);
    }

    public void func() {
        a = 10;
    }

    private String removeFrontZero(String num) {
        int start = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                start++;
            } else {
                break;
            }
        }
        return num.substring(start);
    }

    public int compares(String str1, String str2) {
        removeFrontZero(str1);
        removeFrontZero(str2);
        //先根据长度进行判断
        if (str1.length() > str2.length()) {
            return 1;
        } else if (str1.length() < str2.length()) {
            return -1;
        } else {
            //长度相等的时候
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) - str2.charAt(i) > 0) {
                    return 1;
                } else if (str1.charAt(i) - str2.charAt(i) < 0) {
                    return -1;
                }
            }
            return 0;
        }
    }
    public int compareVersion(String version1, String version2) {
        //以.进行分割 返回数组
        String s1[] = version1.split("\\.");
        String s2[] = version2.split("\\.");
        //判断是否相等
        int i = 0;
        int j = 0;
        while (i < s1.length || j < s2.length) {
            String str1 = i < s1.length ? s1[i] : "0";
            String str2 = j < s2.length ? s2[i] : "0";
            int ret = compares(str1, str2);
            if (ret == 0) {
                i++;
                j++;
            } else {
                return ret;
            }
        }
        return 0;
    }

        static int[] weight;
        static int N;
        static int count=0;
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            while (input.hasNext()) {
                N = input.nextInt();
                weight = new int[N+1];
                for (int i = 1; i <= N; i++) {
                    weight[i] = input.nextInt();
                }
                count(40,N);
                System.out.println(count);
            }
        }
        public static void count(int s,int n) {
            //如果正好装满
            if (s == 0) {
                ++count;
                return;

            }
            //是s<0或n<1则不能完成
            if (s < 0 || (s > 0 && n < 1))
                return;
            count(s - weight[n], n - 1);
            count(s, n - 1);
        }






            }
