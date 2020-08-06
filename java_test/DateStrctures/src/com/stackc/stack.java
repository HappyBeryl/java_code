package com.stackc;
//顺序栈
public class stack {
        private int maxSize;
        private int[] arr;
        private int top = 0;

        public stack(int maxSize)  {
            this.maxSize = maxSize;
            arr = new int[maxSize];
        }

        //是否为空
       public boolean isEmpty() {
            if (top == 0) {
                return true;
            } else {
                return false;
            }
       }

       //是否为满
    public boolean isFull() {
            if (top == maxSize-1) {
                return true;
            } else {
                return false;
            }
    }

    //压入元素
    public void Push(int num) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        arr[top] = num;
        top++;
    }

    //弹出元素
    public int  Pop() {
       if (isEmpty()) {
           System.out.println("栈空");
            return -1;
       }
       int cur = arr[top];
       top--;
       return cur;
    }

    //显示,遍历时需要从栈顶开始显示
    public void disPlay() {
        if (isEmpty()) {
            System.out.println("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,arr[i]);
        }
    }

}
