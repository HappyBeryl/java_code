package eleven.com;

import java.util.*;

public class Main082402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n > 100) {
                return;
            }
            int score = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (b == 0) {
                    score += a;
                }
                if (b == 1) {
                    list.add(a);
                }
            }

            Collections.sort(list);
            for (int j = list.size() - 1; j >= 0; j--) {
                if (score + list.get(j) > score * 2) {
                    score += list.get(j);
                } else {
                    score = score * 2;
                }
            }
            System.out.println(score);
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] array = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            boolean flg = true;
            for (int i = 0; i < array.length; i++) {
                char ch = array[i];
                if (ch == 65 || ch == 72 || ch == 73 || ch == 77 || ch ==79 || ch == 84 || ch == 85
                        || ch == 86 || ch == 87 || ch == 88 || ch == 89) {
                    sb.append(ch);
                } else {
                    System.out.println("NO");
                    flg = false;
                    break;
                }
            }
            if (flg) {
                String a = sb.toString();
                String b = sb.reverse().toString();
                if (a.equals(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
