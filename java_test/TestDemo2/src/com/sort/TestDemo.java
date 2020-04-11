package com.sort;
import java.util.*;

import static com.sort.shellsort.mergeSortInternal;

public class TestDemo {
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







    public static void quickSort1(int[] array) {
        quick1(array, 0, array.length-1);
    }
    private static void quick1(int[] array, int low, int high) {
        int pivot = partion(array, low, high);
        Stack<Integer> stack = new Stack<>();
        if (pivot > low+1) {
            stack.push(low);
            stack.push(pivot-1);
        }

        if (pivot < high-1) {
            stack.push(pivot+1);
            stack.push(high);
        }

        while (!stack.empty()) {
            high = stack.pop();
            low = stack.pop();
            pivot = partion(array, low, high);
            if (pivot > low+1) {
                stack.push(low);
                stack.push(pivot-1);
            }

            if (pivot < high-1) {
                stack.push(pivot+1);
                stack.push(high);
            }
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
        for (int i = (array.length-2)/2; i >= 0; i--) {
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


    //合并递归完的数组
    public static void merge1(int[] array,int low,int mid,int high) {

        int s1 = low;
        int s2 = mid+1;

        int[] tmpArr = new int[high-low+1];  //需要重新申请一个空间存储数组元素
        int i = 0;//tmpArr的数组下标
        //当两个归并段都有数据的时候
        while (s1 <= mid && s2 <= high) {
            //如果是小于，那么就不稳定了
            if(array[s1] <= array[s2]) {
                tmpArr[i++] = array[s1++];
            }else {
                tmpArr[i++] = array[s2++];
            }
        }
        //S1还有数据的情况下
        while (s1 <= mid) {
            tmpArr[i++] = array[s1++];
        }
        //s2还有数据的情况下
        while (s2 <= high) {
            tmpArr[i++] = array[s2++];
        }
        //tmpArr里面存放的是有序的数据
        //将tmpArr里面存放的有序的数据，放回到array里面
        for (int j = 0; j < tmpArr.length; j++) {
            array[low+j] = tmpArr[j];
        }
    }

    //进行递归：分
    public static void mergeSortInternal(int[] array,int low,int high) {
        if(low >= high) { //递归的终止条件
            return;
        }
        //以mid区分前后两段 分段递归
        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //把递归完的数组进行合并
        merge1(array,low,mid,high);
    }

    public static void mergeSort1(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 6, 3, 2, 8, 9, 0, 10, 4, 7};
        mergeSort1(array);
        System.out.println(Arrays.toString(array));
    }


}

