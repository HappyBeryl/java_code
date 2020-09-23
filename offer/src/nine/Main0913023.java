package nine;

import java.util.Scanner;

public class Main0913023 {

    public static void main(String[] args) {
        System.out.println(7.9/20);
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        if (str == null || str.length() == 0) {
            return;
        }
        if (k >= str.length()) {
            System.out.println(reverse(str));
            return;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length()-1; i+=k) {
            String tmp = str.substring(i, i+k);
            String ret = reverse(tmp);
            sb.append(ret);
            if (i+k == str.length()-1) {
                break;
            }
        }

        if (str.length() % 2 == 1) {
            String add = str.charAt(str.length() - 1) + "";
            sb.append(add);
        }
        System.out.println(sb.toString());
    }

    private static String reverse(String str) {
        int i = 0;
        int j = str.length()-1;
        char[] arr = str.toCharArray();
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
