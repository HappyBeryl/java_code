package com.singleton;

/*
 懒汉模式
 */
public class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2() {}

    public static Singleton2 getInstance() {
            if (instance == null) {
                synchronized (Singleton2.class) {
                    if (instance == null) {
                        instance = new Singleton2();
                    }
            }
        }
        return instance;

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            Singleton2 ins1 = Singleton2.getInstance();
            System.out.println(ins1);
        }
    }

    public static void main(String[] args) {
        //多线程会出现原子性的问题
        MyThread[] threads = new MyThread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new MyThread();
        }
        for (int i = 0; i < 20; i++) {
            threads[i].start();
        }
  /*      Singleton2 ins1 = Singleton2.getInstance();
        Singleton2 ins2 = Singleton2.getInstance();
        Singleton2 ins3 = Singleton2.getInstance();

        System.out.println(ins1 == ins2);
        System.out.println(ins2 == ins3);
        输出结果为true
        */
    }


}

