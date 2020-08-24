package eleven.com;

import java.util.Scanner;

public class Main0824 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(func(a, 3));

//        for (int i = 0; i < a.length; i++) {
//            if (func(a, i) > max) {
//                System.out.println(max);
//            }
//        }

    }

    public static double func(int[] a, int k) {
        double left = Integer.MAX_VALUE;
        double right = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            left = Math.min(left, (double) a[i]);
            right = Math.max(right, (double) a[i]);
        }
        while (right - left > 1e-6) {
            double mid = (right - left) / 2;
            double[] sum = new double[a.length - 1];
            sum[0] = 0;
            for (int i = 0; i < a.length; i++) {
                sum[i + 1] = sum[i] + a[i] - mid;
            }
            double preMin = 0;
            double sumMax = Integer.MIN_VALUE;
            for (int i = k; i <= a.length; i++) {
                sumMax = Math.max(sumMax, sum[i] - preMin);
                preMin = Math.min(preMin, sum[i - k + 1]);
            }
            if (sumMax > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
