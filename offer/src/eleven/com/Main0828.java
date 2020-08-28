package eleven.com;

import java.util.Scanner;

public class Main0828 {

    public static void main(String[] args) {
        System.out.println(37+" "+""+22);
    }
    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int n = sc.nextInt();
        int xa = sc.nextInt();
        int ya = sc.nextInt();
        int xb = sc.nextInt();
        int yb = sc.nextInt();
        int xc = sc.nextInt();
        int yc = sc.nextInt();
        int acount1 = x;
        int bcount1 = 1;
        int ccount1 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < x; j++) {
                bcount1 += xa;
                ccount1 += ya;
            }
        }
        int acount2 = 1;
        int bcount2 = y;
        int ccount2 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < y; j++) {
                acount2 += xb;
                ccount2 += yb;
            }
        }
        int acount3 = 1;
        int bcount3 = 1;
        int ccount3 = z;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < z; j++) {
                acount3 += xc;
                bcount3 += yc;
            }
        }
        System.out.println(acount1+acount2+acount3+" "+bcount1+bcount2+bcount3+" "+ccount1+ccount2+ccount3);
    }

    public static void main1(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while (sc.hasNext()) {
            String strs = sc.nextLine();
            strs = strs.toUpperCase();
            String[] strings = strs.split(" ");
            String str = strings[0];
            String a = strings[1];
            String b = strings[2];
            int x = str.indexOf(a);
            int y = str.lastIndexOf(b);
            int ret1 = Math.abs(x - y);
            if (x == -1 || y == -1) {
                System.out.println(-1);
                return;
            }
            int m = str.lastIndexOf(a);
            int n = str.indexOf(b);
            int ret2 = Math.abs(m - n);
            if (m == -1 || n == -1) {
                System.out.println(-1);
                return;
            }
            int ret = ret1 > ret2 ? ret1 : ret2;
            System.out.println(ret);
        }
    }
}
