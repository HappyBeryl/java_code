package sort.com;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {

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

    public static void main(String[] args) {
        int[] array = new int[10000];
        /*for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }*/
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
        long time1 = System.currentTimeMillis();
        selectSort(array);
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        System.out.println(Arrays.toString(array));
    }
}
