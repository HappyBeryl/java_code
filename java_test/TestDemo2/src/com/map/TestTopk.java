package com.map;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestTopk {
    public static Integer[] findKNum(int[] array,int k) {
        //建立大小为k的小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //12  ,  4     ,6 ,17, 9, 51 ,21, 10, 45 ,31
                // j-1   j   [j-1] > [j]  调整
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


    public static void main(String[] args) {
        int[] array = {12, 4, 6, 17, 9, 51, 21, 10, 45, 31};
        Integer[] ret = findKNum(array, 4);
        System.out.println(Arrays.toString(ret));
    }
}
