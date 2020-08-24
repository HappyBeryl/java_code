package eleven.com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
中原银行
 */

import java.util.LinkedList;
import java.util.Queue;

public class Main0823 {

    public static void main2(String[] args) {
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

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(",");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        int ret = func(x,y)-1;
        System.out.println(ret);

    }

    private static int func(int n, int m) {
        int[] arr = new int[10000];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        arr[n] = 1;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            if (tmp == m) {
                return arr[m];
            }
            if (tmp+1 <= m &&arr[tmp+1] == 0) {
                queue.offer(tmp+1);
                arr[tmp+1] = arr[tmp]+1;
            }
            if (tmp-1 <= m &&arr[tmp+1] == 0) {
                queue.offer(tmp-1);
                arr[tmp-1] = arr[tmp]+1;
            }
            if (tmp*2 <= m &&arr[tmp+1] == 0) {
                queue.offer(tmp*2);
                arr[tmp*2] = arr[tmp]+1;
            }
        }
        return -1;
    }
}
