package com.stack;

public class Calculator {
    public static void main(String[] args) {

    }
}

//定义一个ArrayStack表示栈
class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈慢
    public boolean isFull() {
        return top == maxSize-1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈-push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，无法添加");
        }
        top++;
        stack[top] = value;
    }

    //出栈-pop
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈空，无法出栈");
        }
        int value = stack[top];
        top--;
        return value;  //value是出栈的数据
    }

    //显示,遍历时需要从栈顶开始显示
    public void disPlay() {
        if (isEmpty()) {
            System.out.println("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

}
