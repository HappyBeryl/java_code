package com.thread1;

import java.util.Scanner;


public class MyBlockingArrayQueue {
    int[] array = new int[10];
    int front = 0;
    int rear = 0;
    int size = 0;
    synchronized void put(int value) throws InterruptedException {
        // 考虑满的情况
        while (size == array.length) {
            // 队列已满
            //throw new RuntimeException("队列已满");
            wait();
        }
        array[rear] = value;
        rear++;
        if (rear == array.length) {
            rear = 0;
        }

        size++;
        System.out.println(size); // 1 - 10
        notifyAll();
    }


    synchronized int take() throws InterruptedException {
        // 考虑空的情况
        while (size == 0) {
            // 空的
            wait();
        }

        int value = array[front];
        front++;
        if (front == array.length) {
            front = 0;
        }
        //front = (front + 1) % array.length;
        size--;
        System.out.println(size); // 0 - 9
        notifyAll();

        return value;
    }
}
