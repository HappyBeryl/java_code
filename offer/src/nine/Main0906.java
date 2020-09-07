package nine;

import java.util.Arrays;
import java.util.Scanner;

public class Main0906 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int l = sc.nextInt();
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int len = 0;
        int k = 0;

    }
    static int findMin(int[][] arr) {
        int[] tmp = new int[arr.length*arr[0].length];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                tmp[k++] = arr[i][j];
            }
        }
        int len = tmp.length;
        for (int i = 1; i <= len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (tmp[j] == i) {
                    count = 1;
                }
            }
            if (count == 0) {
                return i;
            }
        }
        return len+1;
    }

        static int[] subSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return new int[]{-1,-1};
        }
        long min = arr[arr.length-1];
        int index = -1;
        for (int i = arr.length-2; i >= 0; i--) {
            if (min < arr[i]) {
                index = i;
            } else {
                min = Math.min(min, arr[i]);
            }
        }
        if (index == -1) {
            return new int[]{-1,-1};
        }
        long max = arr[0];
        int index2 = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < max) {
                index2 = i;
            } else {
                max = Math.max(max, arr[i]);
            }
        }
        return new int[]{index, index2};
    }



    static int[] subSort(int[] arr) {
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        int l = -1;
        int r = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != tmp[i]) {
                if (l == -1) {
                    l = i;
                }
                r = i;
            }
        }
        return new int[]{l, r};
    }

    static int findMin1(int[][] arr) {
        int[] tmp = new int[arr.length*arr[0].length];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                tmp[k++] = arr[i][j];
            }
        }
        Arrays.sort(tmp);
        if (tmp[0] < 1) {
            return 0;
        } else if (tmp[0] == 1) {
           return tmp[1]-1;
        } else {
           return tmp[0]-1;
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[2][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ret = findMin(arr);
        System.out.println(ret);

    }

}
