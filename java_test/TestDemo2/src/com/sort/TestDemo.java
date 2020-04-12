package com.sort;

import java.util.*;

public class TestDemo {

    public static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length-1);
    }

    public static void mergeSortInternal(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid+1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid+1;
        int[] tmpArr = new int[high - low + 1];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if (array[s1] <= array[s2]) {
                tmpArr[i++] = array[s1++];
            } else {
                tmpArr[i++] = array[s2++];
            }
        }

        while (s1 <= mid) {
            tmpArr[i++] = array[s1++];
        }

        while (s2 <= high) {
            tmpArr[i++] = array[s2++];
        }

        for (int j = 0; j < tmpArr.length; j++) {
            array[low+j] = tmpArr[j];
        }
    }

    public static void mergeSort1(int[] array) {
        for (int i = 1; i < array.length; i *= 2) {
            merge1(array, i);
        }
    }

    private static void merge1(int[] array, int gap) {
        int[] tmpArr = new int[array.length];
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length-1;
        int k = 0;
        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] <= array[s2]) {
                    tmpArr[k++] = array[s1++];
                } else {
                    tmpArr[k++] = array[s2++];
                }
            }
            while (s1 <= e1) {
                tmpArr[k++] = array[s1++];
            }

            while (s2 <= e2) {
                tmpArr[k++] = array[s2++];
            }
            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2 + gap - 1 < array.length ? s2 + gap -1 : array.length - 1;
        }

        while (s1 <= array.length -1) {
            tmpArr[k++] = array[s1++];
        }
        for (int i = 0; i < tmpArr.length; i++) {
            array[i] = tmpArr[i];
        }


    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 6, 3, 2, 8, 9, 0, 10, 4, 7};
       mergeSort1(array);
        System.out.println(Arrays.toString(array));
    }


}

