package com.datestructures;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建队列对象
    ArrayQueue arrayQueue = new ArrayQueue(3);
    char key = ' '; //接收用户输入
    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
    while(loop) {
        System.out.println("s显示队列");
        System.out.println("e退出程序");
        System.out.println("a添加数据");
        System.out.println("g取出数据");
        System.out.println("h查看头部");
        key = scanner.next().charAt(0);  // 接受一个字符
        switch (key) {
            case 's':
                arrayQueue.showQueue();
                break;
            case 'a':
                System.out.println("输入要添加的数据：");
                int input = scanner.nextInt();
                arrayQueue.addQueue(input);
                break;
            case'g':
                try {
                    System.out.println("取出的数据是");
                    int ret = arrayQueue.getQueue();
                    System.out.println(ret);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            case'h':
                try {
                   int ret = arrayQueue.headQueue();
                    System.out.println("队列头部是");
                    System.out.println(ret);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            case'e':
                scanner.close();
                loop = false;
                break;
        }
    }



    }
}

class ArrayQueue {
    private int maxSize; //表示数组的最大长度
    private int rear; // 数组指针尾
    private int front;  //数组指针头
    int[] arr; //存放数据模拟队列
    public ArrayQueue(int arrMaxSize) {  //创建队列构造器
        maxSize = arrMaxSize;
        rear = -1;
        front = -1;
        arr = new int[maxSize];
    }
    public boolean isFull() {  //判断队列是否为满
        return rear == maxSize-1;
    }

    public boolean isEmpty() {  // 判断队列是否为空
        return rear == front;
    }

    public void addQueue(int n) { //添加数据到队列
        if (isFull()) {
            System.out.println("队列已满，无法添加");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() { //获取队列的数据，出队列
        if (isEmpty()) {
            throw new RuntimeException("队列已空，无法删除");
        }
        front++;
        return arr[front];
    }

    public void showQueue() { //显示队列的所有数据
        if (isEmpty()) {
            System.out.println("队列为空，不能显示");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("a[%d] = %d\n",i,arr[i]);
        }
    }

    public int headQueue() { //显示队列头部
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }


}
