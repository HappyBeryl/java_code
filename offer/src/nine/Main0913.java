package nine;

import java.util.Arrays;
import java.util.Scanner;

public class Main0913 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();

    }
    public static void main222(String[] args) {
        int n = 8;
        int m = 3;
        int[][] arr = {{1,0,1},{0 ,1, 0},{0, 1, 0,}, {1 ,0 ,1}, {1, 0, 1},
                {0 ,1 ,0}, {0 ,1 ,0}, {1 ,0 ,1}};
        int i = 0;
        int j = arr.length-1;
        int k  =0;
        int num = arr[0].length;
        int count = 0;
        while (i < j-1) {
            for (k = 0; k < num; k++) {
                if (arr[i][k] != arr[j][k]) {
                    break;
                }
            }
            if (k == num) {
                i++;
                j--;
                count++;
            } else {
                j--;
            }
        }
        int[][] ret = new int[i+1][num];
        for (int l = 0; l < ret.length; l++) {
            for (int o = 0; o < ret[0].length; o++) {
                ret[l][o] = arr[l][o];
            }
        }
        for (int l = count-1; l < ret.length; l++) {
            for (int o = 0; o < ret[0].length; o++) {
                System.out.print(ret[l][o]+" ");
            }
            System.out.println();
        }
    }
    public static void main11(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int i = 0;
        int j = arr.length-1;
        int k  =0;
        int num = arr[0].length;
        while (i < j) {
            for (k = 0; k < num; k++) {
                if (arr[i][k] != arr[j][k]) {
                    break;
                }
            }
            if (k == num) {
                i++;
                j--;
            } else {
                j--;
            }
        }
        int[][] ret = new int[i+1][num];
        for (int l = 0; l < ret.length; l++) {
            for (int o = 0; o < ret[0].length; o++) {
                ret[l][o] = arr[l][o];
            }
        }
        for (int l = 0; l < ret.length; l++) {
            for (int o = 0; o < ret[0].length; o++) {
                System.out.println(ret[l][o]+" ");
            }
            System.out.println();
        }
    }



    public static void main1(String[] args) {
      //  Scanner sc = new Scanner(System.in);
        int n = 8;
        int m = 3;
        int[][] arr = {{1,0,1},{0 ,1, 0},{0, 1, 0,}, {1 ,0 ,1}, {1, 0, 1},
                {0 ,1 ,0}, {0 ,1 ,0}, {1 ,0 ,1}};
        int i = 0;
        int j = arr.length-1;
        int k  = 0;
        int num = arr[0].length;
        while (i < j-1) {
            for (k = 0; k < num; k++) {
                if (arr[i][k] != arr[j][k]) {
                    break;
                }
            }
            if (k == num) {
                i++;
                j--;
            } else {
                j--;
            }
        }
        int[] ret1 = new int[num];
        for (int l = 0; l < ret1.length; l++) {
            ret1[l] = arr[i][l];
        }
        int[] ret2 = new int[num];
        for (int l = 0; l < ret2.length; l++) {
            ret2[l] = arr[j+1][l];
        }
        System.out.println(Arrays.toString(ret1));
        System.out.println(Arrays.toString(ret2));


    }



    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        int low = 1;
        int high = 2;
        int count = 0;
        while (low < high) {
            int total = (low+high)*(high-low+1)/2;
            if (total == n && high >= d && high <= k) {
                low++;
                count++;
            } else if (total < n) {
                high++;
            } else {
                low++;
            }
        }
        System.out.println(count);
    }
    public static void main22(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int j = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length-m+1; i++) {
            for (j = i; j < i+m; j++) {
                if (arr[j] < k) {
                    break;
                }
            }
            if (j == i+m) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main2(String[] args) {
        int n = 8;
        int m = 2;
        int k = 5;
        int j = 0;
        int count = 0;
        int[] arr = new int[]{5,5,5,4,5,5,5,5};
        for (int i = 0; i < arr.length-m+1; i++) {
            for (j = i; j < i+m; j++) {
                if (arr[j] < k) {
                    break;
                }
            }
            if (j == m+k) {
                count++;
            }
        }
        System.out.println(count);
    }




}
