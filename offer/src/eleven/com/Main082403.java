package eleven.com;

import java.util.Scanner;

public class Main082403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (isPalindrome(str)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }

    private static boolean isPalindrome(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        int j = arr.length-1;
        if (str.length() == 1) {
            return true;
        }
        while (i != j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
