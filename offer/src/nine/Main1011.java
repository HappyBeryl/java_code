package nine;

import java.util.Scanner;

public class Main1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arrString = str.split(",");
        int[] arr = new int[arrString.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(arrString[i]);
        }
        int min = arr[0];
        int max = arr[1]-min;
        int i = 2;
        while (i < arr.length) {
            if (arr[i-1] < min) {
                min = arr[i-1];
            }
            int tmp = arr[i]-min;
            if (tmp > max) {
                max = tmp;
            }
            i++;
        }
        if (max < 0) {
            System.out.println(0);
        } else {
            System.out.println(max);
        }
    }
    
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 1;
        int b = 2;
        int c = n;
        while (n > 2) {
            c = a+b;
            a = b;
            b = c;
            n--;
        }
        System.out.println(c);
    }


}
