package eleven.com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       // Scanner sc = new Scanner(System.in);
      //  int n = sc.nextInt();
      //  String  str = sc.nextLine();
        String str = "acacb";
        int i = 0;
        int j = str.length()-1;
        int count = 0;
        while ((i != j) && i < str.length() && j >= 0) {
            if (str.charAt(i) != str.charAt(j)) {
                count++;
            }
            i++;
            j--;
        }
        System.out.println(count);
    }
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt(); //k次操作
        int d = sc.nextInt(); //-d
        int sum = 0;
        int maxrow = 0;
        int maxline = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        int num = 0;
        int[][] array = new int[m][n];
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = sc.nextInt();
            }
        }
       while (k>0) {
           for (int i = 0; i < array.length; i++) {
               for (int j = 0; j < array[0].length; j++) {
                   tmp1 += array[i][j];
               }
               if (tmp1 > maxrow) {
                   maxline = tmp1;
                   for (int j = 0; j < array[0].length; j++) {
                       array[i][j] -= d;
                   }
               } else {
                   tmp1 = 0;
               }
           }

           for (int i = 0; i < array[0].length; i++) {
               for (int j = 0; j < array.length; j++) {
                   tmp2 += array[j][i];
               }
               if (tmp2 > maxline) {
                   maxline = tmp2;
                   for (int j = 0; j < array.length; j++) {
                       array[j][i] = array[j][i]-d;
                   }
               } else {
                   tmp2 = 0;
               }
           }
           sum += (maxrow > maxline ? maxrow:maxline);
           k--;
       }
        System.out.println(sum);


    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int grop = sc.nextInt();
        for (int i = grop; i > 0; i--) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println();
        }
    }
}
