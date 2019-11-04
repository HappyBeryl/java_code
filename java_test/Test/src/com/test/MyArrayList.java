package com.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

 class MyArrayList1 {
    private int[] elem;
    private int usedSize; //有效数据的个数
    private final int CAPACITY = 5;

    public MyArrayList1() {
        this.elem = new int[CAPACITY];
        this.usedSize = 0;
    }

    private boolean isFull() {
        return this.usedSize == elem.length;
    }

    //打印数据表
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
    }

    //插入数据到顺序表
    //1、必须有前驱  2、当前对象(同一对象)加this
    public void add(int pos, int data) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }

        if (pos < 0 || pos > this.usedSize) {
            System.out.println("非法");
            return;
        } else {
            for (int i = this.usedSize - 1; i >= pos; i--) {
                this.elem[i + 1] = this.elem[i];
            }
            this.elem[pos] = data;
            this.usedSize++;
        }
    }

    //查找某个元素对应位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        this.elem[pos] = value;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if (pos < 0 && pos >= this.usedSize) {
            return -1; //pos不合法
        }
        return this.elem[pos];
    }


    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        //找到元素
        int index = search(toRemove);
        if (index == -1) {
            System.out.println("找不到");
            return;
        }
        //覆盖
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        //useSize--
        this.usedSize--;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}

public class MyArrayList {
     private int[] elem;
     private int useSize;
     private final int CAPACITY = 5;
     public MyArrayList() {
         this.elem = new int[CAPACITY];
         this.useSize = 0;
     }

     public boolean isFull() {
        return this.useSize == this.elem.length;
     }

    // 打印顺序表
     public void display() {
         for (int i = 0; i < this.useSize; i++) {
             System.out.print(elem[i] + " ");
         }
         System.out.println();
     }

     // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、判断是否为满
        if (isFull()) {
            //二倍扩容
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        //2、判断位置是否合法
        if (pos < 0 || pos > this.useSize) {
            System.out.println("非法");
            return;
        }
        //挪数据
        for (int i = this.useSize-1; i >= pos  ; i--) {
            this.elem[i+1] = this.elem[i];
        }
            this.elem[pos] = data;
            this.useSize++;
        }

         // 判定是否包含某个元素
        public boolean contains(int toFind) {
            for (int i = 0; i < this.useSize; i++) {
                if (toFind == elem[i]) {
                    return true;
                }
            }
         return false;
     }

     // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.useSize; i++) {
            if (toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
     }

     // 获取 pos 位置的元素
      public int getPos(int pos) {
        if (pos < 0 || pos > useSize-1)  {
            System.out.println("非法");
            return -1; //不存在
        }
        return this.elem[pos];
     }

     // 给 pos 位置的元素设为 value
     public void setPos(int pos, int value) {
            this.elem[pos] = value;
     }

     //删除第一次出现的关键字key
     public void remove(int toRemove) {
         //找到元素下标
         int index = search(toRemove);
         if (index == -1) {
             System.out.println("找不到");
             return;
         }
         //移动元素
         for (int i = index; i < this.useSize-1 ; i++) {
            elem[i] = elem[i+1];
         }
         this.useSize--;
     }

     // 获取顺序表长度
     public int size() {
         return this.useSize;
     }

    // 清空顺序表
    public void clear() {
         useSize = 0;
     }


}






