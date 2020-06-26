package com.test;

import java.util.Comparator;
import java.util.PriorityQueue;

abstract class AbstractClass {
    int a = 10;
    abstract void eat();
}

class Cat extends AbstractClass {

    @Override
    void eat() {
        System.out.println("cat is eating");
    }
}
public class TestAbstractClass {
    //抽象类不能被实例化
    //AbstractClass abstractClass = new AbstractClass();

    public static Integer[] findKNum(int[] array,int k) {
        //建立大小为k的小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //12  ,  4     ,6 ,17, 9, 51 ,21, 10, 45 ,31
                // j-1   j   [j-1] > [j]  调整的时候用到比较
                return o1.compareTo(o2); //建立一个小堆 （升序）[默认]
                // return o2.compareTo(01); //建立一个大堆（降序）
            }
        });
        for (int i = 0; i < array.length; i++) {
            if(priorityQueue.size() < k) {
                priorityQueue.add(array[i]);
            } else {
                int tmp = priorityQueue.peek();
                if (array[i] > tmp) {
                    priorityQueue.poll();
                    priorityQueue.add(array[i]);
                }
            }
        }

        Integer[] integers = new Integer[k];
        for (int i = 0; i < k; i++) {
            integers[i] = priorityQueue.poll();
        }
        return integers;
    }
}

