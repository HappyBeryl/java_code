package com.thread1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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

    public static void main1(String[] args) throws InterruptedException {
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

    /*
    创建线程
     */
    //继承Thread类
    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            //让线程去执行的指令或 任务
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }
    }

    //实现Runnable接口
    private static class MyRunnable1 implements Runnable {
        @Override
        public void run() {
            for (int i = 100; i < 110; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread a = new MyThread1();
        a.start();
        a.join();  //主线程会阻塞在这里,知道A线程执行结束 才接着往下执行
        System.out.println("a执行完了");

        Runnable target = new MyRunnable();
        Thread b = new Thread(target);
        b.start();;
        b.join();
        System.out.println("b一定结束了");

        Thread target2 = new MyThread1();
        Thread c = new Thread(target2);
        c.start();
        c.join();
        System.out.println("c一定结束了");

        //使用匿名类创建线程对象
    }

    private  static void func() {
        Thread a = new Thread() {
            @Override
            public void run() {
                System.out.println("1");
            }
        };

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
            }
        });

        //2的变形 lambda表达式
        Thread c = new Thread(() -> System.out.println("2"));
    }
}
