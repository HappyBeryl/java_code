package nine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main0905 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            if (str.length() == 0 ||str == null) {
                return;
            }

            if (str.length() == 1) {
                System.out.println(0);
                return;
            }

            int result = 0;
            while (true) {
                result++;
                int len = str.length();
                long tmp = 1;
                for (int i = 0; i < len; i++) {
                    int num = str.charAt(i)-'0';
                    if (num == 0) {
                        System.out.println(result);
                        return;
                    } else {
                        tmp *= num;
                    }
                }
                if (tmp < 10) {
                    System.out.println(result);
                    return;
                }
                str = new String(tmp+"");
            }
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        int k = list.get(list.size()-1);
        list.remove(list.get(list.size()-1));
        Collections.sort(list);
        for (int i = 0; i < k-1; i++) {
            System.out.print(list.get(i));
        }
        System.out.println(list.get(k-1));
    }
}
