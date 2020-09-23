package nine;

import java.util.Arrays;
import java.util.Scanner;

public class Main091402 {
    public static void main(String[] args) {
        System.out.print(1);
        System.out.print(1);
        System.out.print(1);
        System.out.print(1);

        System.out.println();
        System.out.print(0);
        System.out.print(1);
        System.out.print(0);
        System.out.print(1);
        System.out.println();

        System.out.print(1);
        System.out.print(1);
        System.out.print(0);
        System.out.print(1);
        System.out.println();
        System.out.print(0);
        System.out.print(0);
        System.out.print(1);
        System.out.print(0);



    }
    
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; i++) { //上
            ret[0][i] = arr[0][i];
        }
        for (int i = 0; i < n; i++) {
            ret[n-1][i] = arr[n-1][i];
        }
        for (int i = 0; i < n; i++) {
            ret[i][0] = arr[i][0];
        }
        for (int i = 0; i < n; i++) {
            ret[i][n-1] = arr[i][n-1];
        }

        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (arr[i][j] == 1) {
                    ret[i][j] = arr[i][j];
                } else {
                    if (arr[i-1][j] == 1 && arr[i+1][j]==1 && arr[i][j-1]==1 && arr[i][j+1]==1){
                        ret[i][j] = arr[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ret[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int u = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            u -= arr[i];
            if (u < 0) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
