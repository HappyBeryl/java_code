package nine;

/*
tuhu
 */
/*
不同二叉搜索树+36->10
 */
import java.util.Scanner;

public class Maintuhu {
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isLowerCase(num.charAt(i)) && !Character.isUpperCase((num.charAt(i)))
                    && !Character.isDigit(num.charAt(i)) && num.charAt(i) != '-'){
                System.out.println(0);
                return;
            }
        }
        long ret = Long.parseLong(num, 16);
        System.out.println(ret);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println(1);
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        System.out.println(dp[n]);
    }
}
