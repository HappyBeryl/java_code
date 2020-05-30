package com.test;

public class MyBlockingArrayQueue {
    int[] array = new int[1];
    int front = 0;
    int rear = 0;
    int size = 0;

    synchronized void put(int value) throws InterruptedException {
        while (size == array.length) {
            wait();
        }
        array[rear] = value;
        rear++;
        rear = (rear+1) % array.length;
        size++;
        notifyAll();
    }

    synchronized int take() throws InterruptedException {
        while (size == 0) {
            wait();
        }

        int value = array[front];
        front++;
        front = (front+1) % array.length;
        size--;
        notifyAll();

        return value;
    }


}
