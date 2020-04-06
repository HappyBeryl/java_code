package com.sort;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

public class TestDemo {


    //冒泡排序
    public static void bubbleSort(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }


    //选择排序
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

    //直接插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = 0;
            int tmp = array[i];
            for (j = i-1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    //希尔排序

    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = 0;
            for (j = i - gap; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j+gap] = array[j];
                } else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int[] drr = {5, 3, 1};
        for (int i = 0; i < drr.length; i++) {
            shell(array, drr[i]);
        }
    }

    public static void heapSort(int[] array) {
        creatHeap(array);
        int end = array.length-1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array, 0, end);
            end--;
        }
    }

    private static void creatHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
    }

    private static void adjustDown(int[] array, int root, int len) {
        int child = 2 * root + 1;
        while (child < len) {
            if (child + 1 < len && array[child] < array[child+1]) {
                child++;
            }
            if (array[child] > array[root]) {
                int tmp = array[child];
                array[child] = array[root];
                array[root] = tmp;
                root = child;
                child = 2 * root + 1;
            } else {
                break;
            }
        }
    }

    //归并排序
    private static void mergeSort1(int[] array) {
        mergeSortInternal(array, 0, array.length-1);
    }

    private static void mergeSortInternal(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid + 1, high);
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
            array[low + j] = tmpArr[j];
        }
    }

    private static void mergeSort(int[] array) {
        for (int i = 1; i < array.length; i *= 2) {
            merge1(array, i);
        }
    }

    private static void merge1(int[] array, int gap) {
        int[] tmpArr = new int[array.length];
        int k = 0;
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;
        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] < array[s2]) {
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
            e2 = s2 + gap - 1 < array.length ? s2 + gap -1 :array.length - 1;
        }
        while (s1 <= array.length-1) {
            tmpArr[k++] = array[s1++];
        }

        for (int i = 0; i < tmpArr.length; i++) {
            array[i] = tmpArr[i];
        }
    }

    //快速排序
    private static void quickSort(int[] array) {
        quick(array, 0, array.length-1);
    }

    private static void quick(int[] array, int low, int high) {
        if (low >= high){
            return;
        }

        int pivot = partion(array, low, high);
        quick(array, low, pivot-1);
        quick(array, pivot + 1, high);
    }

    private static int partion(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while ((start < end) && array[end] >= tmp) {
                end--;
            }
            if (start >= end) {
                break;
            } else {
                array[start] = array[end];
            }

            while ((start < end) && array[start] <= tmp) {
                start++;
            }
            if (start >= end) {
                break;
            } else {
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }


    private static void quickSort1(int[] array) {
        quick1(array, 0, array.length-1);
    }

    private static void quick1(int[] array, int low, int high) {
        int pivot = partion(array, low, high);
        Stack<Integer> stack = new Stack<>();
        if (pivot > low + 1) {
            stack.push(low);
            stack.push(pivot-1);
        }

        if (pivot < high -1) {
            stack.push(pivot+1);
            stack.push(high);
        }

        while (!stack.empty()) {
            high = stack.pop();
            low = stack.pop();
            pivot = partion(array, low, high);
            if (pivot > low + 1) {
                stack.push(low);
                stack.push(pivot-1);
            }

            if (pivot < high-1) {
                stack.push(pivot+1);
                stack.push(high);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 6, 3, 2, 8, 9, 0, 10, 4, 7};
        quickSort1(array);
        System.out.println(Arrays.toString(array));
    }
}

