package sort.com;

import java.util.Arrays;

public class HeapSort {

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

    public static void creatHeap(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
    }

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

    public static void main(String[] args) {
        int[] array = new int[]{27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

}
