package com.myDataStructures;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {

    }
}


class CircleArray {
    private int maxSize; //表示数组的最大长度
    private int rear; // 数组指针尾
    private int front;  //数组指针头
    int[] arr; //存放数据模拟队列

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断数列是否为满
        if (isFull()) {
            System.out.println("队列已满，无法添加");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，无法删除");
        }
        //front是指向队列的第一个元素
        //1、先把front对应的值先保存在一个临时变量
        //2、将front后移,考虑取模
        //3、将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，不能显示");
            return;
        }
        //从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("a[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列头部
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
    Scanner scanner = new Scanner(System.in);
    int ret = scanner.nextInt();

}

