package sort.com;

import java.util.Arrays;

public class ShellSort {

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
        int[] array = new int[]{27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
