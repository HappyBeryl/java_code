package com.singleton;

/*
 饿汉模式
 */
public class Singleton1 {
    //一开始就初始化
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return instance;
    }

    static class MyThraed extends Thread {
        @Override
        public void run() {
            Singleton1 ins1 = Singleton1.getInstance();
            System.out.println(ins1);
        }
    }

    public static void main(String[] args) {
     /*   Singleton1 ins1 = Singleton1.getInstance();
        Singleton1 ins2 = Singleton1.getInstance();
        Singleton1 ins3 = Singleton1.getInstance();
        System.out.println(ins1 == ins2);
        System.out.println(ins2 == ins3);
        运行结果为true
     */

     MyThraed[] threads = new MyThraed[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new MyThraed();
        }

        for (int i = 0; i < 20; i++) {
            threads[i].start();
        }
    }

}
