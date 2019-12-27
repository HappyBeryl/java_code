import java.util.Arrays;

//大根堆   堆排序  时间空间复杂度
public class TestSortDemo {
    public static void insertSort(int[] array) {
        int i = 1;
        int j = 0;
        int tmp = 0;
        while (i < array.length) {
            tmp = array[i];
            while (j >= 0) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                    j--;
                } else {
                    break; //说明前面的序列已经有序
                }
            }
            array[j+1] = tmp;
            i++;
            j = i-1;
        }
    }

    public static void insertSort1(int[] array) {

        /**
         * 时间复杂度： 最坏O(N^2)、 最好O(N)[有序的时候] 当数据越有序越快
         * 空间复杂度： O(1)
         * 稳定性：稳定的排序
         * if（）条件加等号  2 2' ==》不稳定
         *
         */
        for (int i = 0; i < array.length; i++) {
            int tmp = array[i];
            int j = 0;
            for (j = i-1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    break;//说明前面的序列已经有序
                }
            }
            array[j+1] = tmp;
        }
    }

    /**希尔排序
     * 时间复杂度：O（N^1.3-1.5）
     * 空间复杂度：O(1)
     * 稳定性：不稳定的排序
     */

    /**
     * 选择排序
     *时间复杂度：O(N^2) 一直是
     * 空间复杂度：O（1）
     * 稳定性：不稳定
     *
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for(int j = i+1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp  = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度 O（N^2）  优化过为O（N） 数据有序
     *空间复杂度O（1）
     * 稳定的
     */

    /**
     * 快速排序
     *时间复杂度  O(Nlog2N)     最坏的情况O（N^2）[有序]
     *空间复杂度  O(log2N)
     * 不稳定
     */

    public static int partion(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while ((start < end) && array[end] >= tmp) {
                end--;
            }
            if (start >= end) {
                array[start] = tmp;
                break;
            } else {
                array[start] = array[end];
            }

            while ((start < end ) && array[start] <= tmp) {
                start++;
            }
            if (start >= end) {
                array[start] = tmp;
                break;
            } else {
                array[end] = array[start];
            }
        }
        return start;
    }

    //优化
    public static int partion2(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while ((start < end) && array[end] >= tmp) {
                end--;
            }
            array[start] = array[end];

            while ((start < end ) && array[start] <= tmp) {
                start++;
            }
                array[end] = array[start];
        }
        array[start] = tmp;
        return start;
    }




    public static void main(String[] args) {
        int[] array1 = new int[]{8,7,10,5,3,9};
//        insertSort(array1);
        selectSort(array1);
        System.out.println(Arrays.toString(array1));
    }

    //"============================"
    public static void bubbleSort(int[] array) {
        boolean flg = false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(!flg) {
                break;
            }
        }
    }
    public static void adjustDown(int[] array,int root,int len) {
        //log2n
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            if(child+1 < len && array[child] < array[child+1]) {
                child++;
            }
            //child保存的是最大值的下标
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }

    }
    public static void adjustDown1(int[] array,int root,int len) {
        //log2n
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            if(child+1 < len && array[child] < array[child+1]) {
                child++;
            }
            //child保存的是最大值的下标
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }

    }

    public static void createHeap(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
           adjustDown(array,i,array.length);
        }
    }



}
