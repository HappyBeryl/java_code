package com.thread1;

import java.util.concurrent.ThreadLocalRandom;

public class MyThread extends Thread {
    @Override
    public void run() {
        //线程执行的代码
    }

    public static void main1(String[] args) {
        Thread thread = new MyThread();
        thread.start();// 把 a 线程放入就绪队列

        // 创建一个目标对象,具体要做的实现，见 run 方法
        Runnable target = new MyRunnable();
        // 拿着目标对象，去创建线程对象，这个线程要干的活，就是目标对象中指定的
        Thread b = new Thread(target);

//        Thread t = new MyThread();
//        Runnable target = t;
//        Thread thread = new Thread(target);


    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        //线程执行的代码
    }
}
