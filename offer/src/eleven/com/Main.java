package eleven.com;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("NO");
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        String op = arr[1]; //操作符号
        String fz = arr[0];
        String fm = arr[2];
        int a = Integer.parseInt(fz.split("/")[0]);
        int b = Integer.parseInt(fz.split("/")[1]);
        int c = Integer.parseInt(fm.split("/")[0]);
        int d = Integer.parseInt(fm.split("/")[1]);
        int x = 0;
        int y = 0; //x/y
        if (op.equals("+")) {
            y = b*d/func(b,d);
            x = y/b*+y/d*c;
        } else if (op.equals("-")) {
            y = b*d/func(b,d);
            x = y/b*a-y/d*c;
        } else if (op.equals("*")) {
            x = a*c;
            y = b*d;
        } else if (op.equals("/")){
            x = a*d;
            y = b*c;
        }
        int tmp = Math.abs(func(x,y));
        x /= tmp;
        y /= tmp;
        if (x == y || x == -y) {
            System.out.println(x/y);
        } else if (y == 0) {
            System.out.println(0);
        } else {
            System.out.println(x+"/"+y);
        }
    }

    public static int func(int a, int b) {
        if (b == 0) {
            return a;
        }
        return func(b, a%b);
    }

}
