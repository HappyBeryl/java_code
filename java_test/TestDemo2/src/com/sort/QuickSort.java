package com.sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] array) {
        quick(array, 0, array.length-1);
    }

    private static void quick(int[] array, int low, int high) {
        //递归终止条件
        if (low >= high) {
            return;
        }
        //1.写一个函数将待排序序列分为两部分
        int pivot = partion(array, low, high);
        //2.开始递归 左右
        quick(array, low, pivot-1);
        quick(array, pivot+1, high);
    }

    private static int partion(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while ((start < end) && array[end] >= tmp) {
                //9 3 2 9 10  取等于号
                //减的时候要有边界 1 2 3 4 5 6 7 8 9
                end--;
            }
            if (start >= end) {
                //start和end相遇了
              //  array[start] = tmp;
                break;
            } else {
                array[start] = array[end];
            }
            while ((start < end) && array[start] <= tmp) {
                start++;
            }
            if (start >= end) {
                //array[start] = tmp;
                break;
            } else {
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }

    public static void main(String[] args) {
        int[] array = new int[]{12,5,9,34,6,8,33,56,89,0,7,4};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

}
