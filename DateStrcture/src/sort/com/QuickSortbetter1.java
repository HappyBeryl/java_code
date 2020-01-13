package sort.com;

import java.util.Arrays;

public class QuickSortbetter1 {
    public static int partion(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while ((start < end) && array[end] >= tmp) {  //9 3 2 9 10
                end--;
            }
            if (start >= end) {
                array[start] = tmp;
                break;
            } else {
                array[start] = array[end];
            }

            while ((start < end) && array[start] <= tmp) {  //9 3 2 9 10
                start++;
            }
            if (start >= end) {
                array[start] = tmp; //
                break;
            } else {
                array[end] = array[start];
            }

        }
        return start;
    }

    public static void insertSort2(int[] array, int low, int high) {
        int j = 0;
        for (int i = low+1; i <= high; i++) {
            int tmp = array[i];
            for (j = i-1; j >= low; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void quick(int[] array, int low, int high) {
        //递归的终止条件
        if (low >= high) {
            return;
        }

        if (high-low+1 < 100) {
            insertSort2(array, low, high);
            return;
        }
        //1.写一个函数把待排序序列分为两部分
        int pivot = partion(array, low, high); //low和high是局部变量
        //开始递归 左右
        quick(array, low, pivot-1);
        quick(array, pivot+1, high);
    }

    public static void quickSortBetter1(int[] array) {
        quick(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        quickSortBetter1(array);
        System.out.println(Arrays.toString(array));
    }

}
