package eleven.com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main0820 {

    public int eraseOverlapIntervals (int[][] intervals) {
        // write code here
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int count = 0;
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] > intervals[i][0]) {
                count++;
                if (intervals[index][1] > intervals[i][1]) {
                    index = i;
                }
            } else {
                index = i;
            }
        }
        return count;
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        if (arr == null || arr.length == 0) {
            System.out.println(0);
            return;
        }
        int max = 0;
        int tmp[][] = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                max = Math.max(max, func(arr, tmp, i+1, j, arr[i][j])+1);//下
                max = Math.max(max, func(arr, tmp, i-1, j, arr[i][j])+1); //上
                max = Math.max(max, func(arr, tmp, i, j+1, arr[i][j])+1);//右
                max = Math.max(max, func(arr, tmp, i, j-1, arr[i][j])+1);//左
            }
        }
        System.out.println(max);
    }

    private static int func(int[][] arr, int[][] tmp, int i, int j, int n) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] >= n) {
            return 0;
        }
        if (tmp[i][j] == 0) {
            tmp[i][j] = func(arr, tmp, i+1, j, arr[i][j])+1;
            tmp[i][j] =Math.max(tmp[i][j], func(arr, tmp,i, j+1,arr[i][j])+1);
            tmp[i][j] =Math.max(tmp[i][j], func(arr, tmp,i-1, j,arr[i][j])+1);
            tmp[i][j] =Math.max(tmp[i][j], func(arr, tmp,i, j-1,arr[i][j])+1);
        }
        return tmp[i][j];
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        for (int i = 0; i < str.length()-1; i++) {
            for (int j = 0; j < str.length()-1; j++) {
                if (str.substring(i,j).equals("Good")) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String good = "Good";
        int count = 0;
        int num = 0; //相等个数
        int j = 0;
        int k = 0;
        while (k > str.length()) {
                if (num == good.length()) {
                    num = 0;
                    count++;
                }
                if (j == good.length()) {
                    break;
                }
                if (str.charAt(k) == good.charAt(j)) {
                    k++;
                }
                else {

                }
        }
    }
}
