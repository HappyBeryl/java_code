package sort.com;

import java.util.Arrays;

public class QuickSortBetter2 {
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

    public static void swap(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }

    public static void ThreeNumOfMiddle(int[] array, int low, int high) {
        //array[mid] <= array[low] <= array[high];
        int mid = (low+high)/2;
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }
        if (array[mid] > array[low]) {
            swap(array, mid, low);
        }
        if (array[low] > array[high]) {
            swap(array, low, high);
        }
    }


    public static void quick(int[] array, int low, int high) {
        //递归的终止条件
        if (low >= high) {
            return;
        }

        ThreeNumOfMiddle(array, low, high);
        //1.写一个函数把待排序序列分为两部分
        int pivot = partion(array, low, high); //low和high是局部变量
        //开始递归 左右
        quick(array, low, pivot-1);
        quick(array, pivot+1, high);
    }

    public static void quickSort(int[] array) {
        quick(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
