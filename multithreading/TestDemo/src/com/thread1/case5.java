package com.thread1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class case5 {
    private static void A () {
        System.out.println("a");
    }

    public static void main(String[] args) {
        String s = "fmn";
        s.toUpperCase();
        String y = s.replace('f','F');
        y = y+"wxy";
        System.out.println(y);
    }
}
