package com.sort;

public class TestDemo {
    //堆排序

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

    private static void adjustDown(int[] array, int root, int len) {
        int child = 2 * root + 1;
        while (child < len) {
            if (child + 1 < len && array[child] < array[child+1]){
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

    private static void creatHeap(int[] array) {
        for (int i = (array.length-1)/2; i >=0 ; i--) {
            adjustDown(array, i, array.length);
        }
    }

    //快速排序
    public static void quickSort(int[] array) {
        quick(array, 0, array.length-1);
    }

    private static void quick(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partion(array, low, high);
        quick(array, low, pivot-1);
        quick(array, pivot+1, high);
    }

    private static int partion(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            if ((start < end) && array[end] >= tmp) {
               end--;
            }
            if (start >= end) {
                break;
            } else {
                array[start] = array[end];
            }

            if ((start < end) && array[end] <= tmp) {
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

    //直接插入排序
    public static void insert(int[] array) {
        int j = 0;
        for (int i = 1; i < array.length; i++) {
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

    //归并排序
    public static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length-1);
    }

    private static void mergeSortInternal(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid+1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid+1;
        int[] arrayNew = new int[high-low+1];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if (array[s1] < array[s2]) {
                arrayNew[i++] = array[s1++];
            } else {
                arrayNew[i++] = array[s2++];
            }
        }

        while (s1 <= mid) {
            arrayNew[i++] = array[s1++];
        }
        while (s2 <= high) {
            arrayNew[i++] = array[s2++];
        }
        for (int j = 0; j < arrayNew.length; j++) {
            array[low+j] = arrayNew[j];
        }
    }
}
