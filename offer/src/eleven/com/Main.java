package eleven.com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 2; i <= n/2; i++) {
            if (isPrime(i) && isPrime(n-i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        boolean flg = false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                flg = true;
                break;
            }
        }
        if (flg) {
            return false;
        } else {
            return true;
        }
    }
}
