import java.util.Arrays;

public class ReviewOrderBy {

    /*
    堆排序
     */
    public static void adjustDown(int[] array, int p, int len) {
        int c = 2*p + 1;
        while (c < len) {
            //保证有有孩子
            while (c + 1 < len && array[c] < array[c+1]) {
                c++;
            }
            //c指向子孩子的较大自
            if (array[p] < array[c]) {
                int tmp = array[p];
                array[p] = array[c];
                array[c] = tmp;
                p = c;
                c = 2*p + 1;
            } else {
                break;
            }
        }
    }

    //调整为大根堆
    public static void creatHeap(int[] array) {
        //每棵树都要调整为大根堆
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
    }

    //堆排序
    public static void heapSort(int[] array) {
        creatHeap(array);
        int end = array.length-1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            //取不到end 所有先调整 后--
            adjustDown(array,0,end);
            end--;
        }
    }


    public static void insertSort(int[] array) {
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

    public static void insertSort1(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }


        public static void main(String[] args) {
        int[] array = new int[] {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        insertSort1(array);
        System.out.println(Arrays.toString(array));
    }


}
