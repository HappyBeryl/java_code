package com.thread1;

import java.util.Scanner;
/*
   通知线程停止
    */
public class TellStop {
    static class work implements Runnable {
        @Override
        public void run() {
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()) {  //如果没睡通过这里知道停止
                try {
                    System.out.println("工作1");
                    Thread.sleep(3000);
                    System.out.println("工作2");
                    Thread.sleep(3000);
                    System.out.println("工作3");
                    Thread.sleep(3000);
                    System.out.println("工作4");
                    Thread.sleep(3000);
                    System.out.println("工作5");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
               //     e.printStackTrace();//如果睡了通过这里知道停止
                    break;
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new work());
        t.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("准备通知停止工作");
        t.interrupt();
        System.out.println("已经通知停止工作");
        t.join();
        System.out.println("已经通知停止写作业");

    }
}
