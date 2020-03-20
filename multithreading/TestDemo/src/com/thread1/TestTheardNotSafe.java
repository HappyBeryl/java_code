package com.thread1;


public class TestTheardNotSafe {
    static long n = 0;
    static final long COUNT = 1_0000_0000L;

    static class Add extends Thread {
        @Override
        public void run() {
            for (long i = 0; i < COUNT; i++) {
                n++;
            }
        }
    }

    static class Sub extends Thread {
        @Override
        public void run() {
            for (long i = 0; i < COUNT; i++) {
                n--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Add add = new Add();
        Sub sub = new Sub();
        add.start();
        sub.start();

        add.join();
        sub.join();

        System.out.println(n);
    }

    //修饰普通方法
    synchronized void func() {
    }

    //修饰静态方法
    synchronized static void func1() {
    }

    void func2() {
        Object o = new Object();
        synchronized (o) {
        }
    }



}