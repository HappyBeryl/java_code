package com.thread1;

public class case3 {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 100; i < 110; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread a = new MyThread();
        a.start();
        a.join();  // 主线程会阻塞在这里，直到 a 线程执行结束，才接着往下执行

        System.out.println("a 一定结束了");

        Thread b = new Thread(new MyRunnable());
        b.start();
        b.join();
        System.out.println("b 一定结束了");

        Thread c = new Thread(new MyThread());
        c.start();
        c.join();
        System.out.println("c 一定结束了");
    }

}
