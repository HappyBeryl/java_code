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

    public static void main(String[] args) {
        int[] array1 = new int[]{8,7,10,5,3,9};
//        insertSort(array1);
        selectSort(array1);
        System.out.println(Arrays.toString(array1));
    }

    //"======================"
    public static void insertSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = 0;
            for (j = i-1; j >= 0 ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;//前面的序列已经有序
                }
            }
            //
            array[j+1] = tmp;
        }
    }


    public static void shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = 0;
            for (j = i-gap; j >= 0 ; j -= gap) {
                if(array[j] > tmp) {
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
}
