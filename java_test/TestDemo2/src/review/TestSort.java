package review;
import java.util.Arrays;
import java.util.Stack;

import static com.test.TestStack.quick1;

public class TestSort {
    public static void quickSort(int[] array) {
        quick(array, 0, array.length-1);
    }

    private static void quick(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partion(array, low, high);
        quick(array, low, pivot);
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
        quicks(array, 0, array.length-1);
    }

    private static void quicks(int[] array, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        int pivot = partion(array, low, high);
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

    public  static void heapSort(int[] array) {
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
            if ((child+1<len) && array[child] < array[child+1]){
                child++;
            }
            if (array[child] > array[root]){
                int tmp = array[child];
                array[child] = array[root];
                array[root] = tmp;
                root = child;
                child = 2 * root+1;
            } else {
                break;
            }
        }
    }

    public static void mergeSort(int[] array) {
        mergeSortChild(array, 0, array.length-1);
    }

    private static void mergeSortChild(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSortChild(array, low, mid);
        mergeSortChild(array, mid+1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid+1;
        int[] arrNew = new int[high-low+1];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if (array[s1] <= array[s2]) {
                arrNew[i++] = array[s1++];
            } else {
                arrNew[i++] = array[s2++];
            }
        }
        while (s1 <= mid) {
            arrNew[i++] = array[s1++];
        }
        while (s2 <= high) {
            arrNew[i++] = array[s2++];
        }
        for (int j = 0; j < arrNew.length; j++) {
            array[low+j] = arrNew[j];
        }
    }

    public static void bubbleSort(int[] array) {
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

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            for (j = i-1;  j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,4,3,5,2,9,7,8,6,0};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
