package com.sort;

import java.util.*;

public class TestDemo {


    public static void mergeSort(int[] array) {
        mergeSortIntenal(array, 0 , array.length-1);
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

    public static void main1(String[] args) {
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

    public static int partion(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while ((start < end) && array[end] > tmp) {
                end--;
            }
            if (start >= end) {
                break;
            } else {
                array[start] = array[end];
            }

            while ((start < end) && array[start] < tmp) {
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
    public static void quick(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partion(array, low, high);
        quick(array, low, pivot-1);
        quick(array, pivot+1, high);
    }

    public static void quickSort(int[] array) {
        quick(array, 0, array.length-1);
    }



    public static int partion1(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while ((start < end) && array[end] >= tmp) {  //9 3 2 9 10
                end--;
            }
            if (start >= end) {
                break;
            } else {
                array[start] = array[end];
            }

            while ((start < end) && array[start] <= tmp) {  //9 3 2 9 10
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

    public static void quick1(int[] array, int low, int high) {
        int pivot = partion1(array, low, high);
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
            pivot = partion1(array, low, high);

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
    public static void quickSort1(int[] array) {
        quick1(array, 0, array.length-1);
    }

    //向下调整
    public static void adjustDown(int[] array, int root, int len) {
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            if (child+1 < len && array[child] < array[child+1]) {
                child++;
            }
            //此时child就是指向子孩子的较大值
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                //调整子树也要是大根堆
                parent = child;
                child = 2*parent+1;
            } else {
                break;
            }
        }
    }

    //每棵树都向下调整
    public static void creatHeap(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
    }

    //进行排序
    public static void heapSort(int[] array) {
        creatHeap(array);
        int end = array.length-1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            //adjustDown取不到len 所以先调整后end--
            adjustDown(array, 0, end);
            end--;
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j =0;
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

    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = 0;
            for (j = i-gap; j >= 0; j -= gap) {
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
        //分的组数
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array, drr[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,5,6,3,2,8,9,0,10,4,7};
        shellSort(array);
        List l = new ArrayList();
        System.out.println(Arrays.toString(array));
    }








}
