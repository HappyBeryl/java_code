package com.test;

public class Singleton {
    // 一开始初始化
    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            Singleton ins1 = Singleton.getInstance();
            System.out.println(ins1);
        }
    }

    // 理论上，多线程环境下也是正确的
    public static void main(String[] args) {
        MyThread[] threads = new MyThread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new MyThread();
        }
        for (int i = 0; i < 20; i++) {
            threads[i].start();
        }
    }
}
