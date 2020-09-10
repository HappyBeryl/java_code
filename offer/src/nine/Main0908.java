package nine;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main0908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] arr1String = str1.split(" ");
        if (arr1String == null || arr1String.length == 0) {
            System.out.println(0);
            return;
        }
        int[] arr1 = new int[arr1String.length];
        for (int i = 0; i < arr1String.length; i++) {
            arr1[i] = Integer.parseInt( arr1String[i]);
        }
        String str2 = sc.nextLine();
        String[] arr2String = str2.split(" ");
        if (arr2String == null || arr2String.length == 0) {
            System.out.println(0);
            return;
        }
        int[] arr2 = new int[arr2String.length];
        for (int i = 0; i < arr2String.length; i++) {
            arr2[i] = Integer.parseInt( arr2String[i]);
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int count = 0;
        int min = Math.min(arr1.length, arr2.length);
        for (int i = 0; i < min; i++) {
            if (arr1[i] <= arr2[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
