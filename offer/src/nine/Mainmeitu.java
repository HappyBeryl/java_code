package nine;

import java.util.Scanner;

public class Mainmeitu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (sc.hasNext()) {
            int h = sc.nextInt();
            int l = sc.nextInt();
            int longs = h;
            if (l < h) {
                System.out.println(0);
            } else if (l == h) {
                System.out.println(1);
            } else {
                while (h > 0) {
                    h = h/2;
                    longs += h;
                    count++;
                }
                if (longs != l) {
                    System.out.println("no");
                } else {
                    System.out.println(count);
                }
            }
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int i = 0;
            for (i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) != str.charAt(i + 1)) {

                } else {
                    break;
                }
            }
            if (i == str.length() - 1) {
                System.out.println(str);
                return;
            }
            int start = 0;
            int end = 0;
            StringBuffer sb = new StringBuffer();
            int num = 0;
            while (start < str.length()) {
                end = start;
                char tmp = str.charAt(start);
                while ((end < str.length()) && (str.charAt(end) == tmp)) {
                    end++;
                }
                num = end - start;
                sb.append(tmp);
                sb.append(num);
                start = end;
            }
            System.out.println(sb);
        }
    }
}
