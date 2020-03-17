package com.thread1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.Scanner;

public class case5 {
    private static void A () {
        System.out.println("a");
    }

    public static void main1(String[] args) {
        String s = "fmn";
        s.toUpperCase();
        String y = s.replace('f','F');
        y = y+"wxy";
        System.out.println(y);
    }

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                dianping();
            }
        };
        System.out.println("dazhong");
    }
    static void dianping() {
        System.out.println("dianping");

    }

}
