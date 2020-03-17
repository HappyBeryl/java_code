package com.sort;

import java.util.Arrays;

public class TestDemo {

    public static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid + 1;
        int[] arrayTmp = new int[high - low + 1];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if (array[s1] <= array[s2]) {
                arrayTmp[i++] = array[s1++];
            } else {
                arrayTmp[i++] = array[s2++];
            }
        }
        while (s1 <= mid) {
            arrayTmp[i++] = array[s1++];
        }

        while (s2 <= high) {
            arrayTmp[i++] = array[s2++];
        }
        for (int j = 0; j < arrayTmp.length; j++) {
            array[low+j] = arrayTmp[j];
        }
    }

    public static void mergeSortIntenal(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortIntenal(array, low, mid);
        mergeSortIntenal(array, mid+1, high);
        //合并
        merge(array, low, mid, high);
    }

    public static void mergeSort(int[] array) {
        mergeSortIntenal(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 6, 7, 1, 3, 9, 4, 2};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
