import java.util.Arrays;

public class TestSort {
    public static void insertSort(int[] array) {
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            for (j = i-1; j >= 0; j--) {
                if (tmp < array[j]) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1 ; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public static void main1(String[] args) {
        int[] array = new int[]{34,8,64,51,32,21};
        System.out.println(Arrays.toString(array));
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void adjustDown(int[] array, int root, int len) {
        int child = 2 * root + 1;
        while (child < len) {
            if (child + 1 < len && array[child] < array[child + 1]) {
                child++;
            }
            if (array[child] > array[root]) {
                int tmp = array[child];
                array[child] = array[root];
                array[root] = tmp;
                //调整子树也要是大根堆
                root = child;
                child = 2 * root + 1;
            } else {
                break;
            }
        }
    }

    public static void creatHeap(int[] array){
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

    public static void main2(String[] args) {
        int[] array = new int[]{12, 5, 9, 34, 6, 8, 33, 56, 89, 0, 7, 4, 22, 55, 77};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

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

    public static void quick(int[] array, int low, int high) {
        //递归的终止条件:只有一个元素
        if (low >= high) { //=zuo  >you
            return;
        }
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
        final  int b= 10;
        int[] array = new int[]{27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }


}


