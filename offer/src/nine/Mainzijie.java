package nine;

import java.util.Scanner;

public class Mainzijie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        int j = 0;
        for (int i = 1; i*2 <= len; i++) {
            if (len % i == 0) {
                boolean flg = true;
                for (j = i; j < len; j++) {
                    if (str.charAt(j) != str.charAt(j-i)) {
                        flg = false;
                        break;
                    }
                }
                if (flg) {
                    System.out.println(str.substring(i,j));
                    return;
                }
            }
        }
        System.out.println(str);

    }
}
