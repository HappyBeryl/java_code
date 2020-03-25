package com.sort;

import java.util.Arrays;

public class TestDemo {

    public static void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] tmpArray = new int[high - low + 1];
        int n = 0;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                tmpArray[n++] = array[i++];
            } else {
                tmpArray[n++] = array[j++];
            }
        }

        while (i <= mid) {
            tmpArray[n++] = array[i++];
        }

        while (j <= high) {
            tmpArray[n++] = array[j++];
        }

        for (int k = 0; k < tmpArray.length; k++) {
            array[low + k] = tmpArray[k];
        }
    }

    public static void mergeSortIntenal(int[] array, int low, int high) {
        //递出去
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSortIntenal(array, low, mid);
        mergeSortIntenal(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public static void mergeSort(int[] array) {
        mergeSortIntenal(array, 0 , array.length-1);
    }


    public static void mergeSort1(int[] array) {

        //进行分组归并
        for (int i = 1; i < array.length; i *= 2) {
            merge(array,i);
        }
    }
    //gap代表每个归并段的数据
    public static void merge(int[] array,int gap) {
        int[] tmpArray = new int[array.length];
        int k = 0;

        int s1 = 0;
        int e1 = s1 + gap -1;
        int s2 = e1 + 1;
        int e2 = s2 + gap -1 < array.length ? s2 + gap -1 : array.length-1;

        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] < array[s2]) {
                    tmpArray[k++] = array[s1++];
                } else {
                    tmpArray[k++] = array[s2++];
                }
            }

            while (s1 <= e1) {
                tmpArray[k++] = array[s1++];
            }

            while (s2 <= e2) {
                tmpArray[k++] = array[s2++];
            }

            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2 + gap -1 < array.length ? s2 + gap -1 : array.length-1;
        }

        while (s1 < array.length) {
            tmpArray[k++] = array[s1++];
        }

        for (int i = 0; i < tmpArray.length; i++) {
            array[i] = tmpArray[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 6, 7, 1, 3, 9, 4, 2};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
  /*  public static void main(String[] args) {
        String foo1 = args[1];
        String foo2 = args[2];
        String foo3 = args[3];
    }*/

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public static void bubbleSort1(int[] array) {
        boolean flg = false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if (!flg) {
                break;
            }
        }
    }
}
