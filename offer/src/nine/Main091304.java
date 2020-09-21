package nine;

import java.util.Scanner;

public class Main091304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;
        if (m == 0) {
            result = 3*n;
        }
        for (int i = 1; i <= 3*n; i++) {
            result +=  m*i;
        }
        System.out.println(result);

    }
}
