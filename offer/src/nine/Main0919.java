package nine;

import java.lang.reflect.Array;
import java.util.*;

public class Main0919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        int start = 0;
        while (list.size() > 1) {
            for (int i = 1; i < m; i++) {
                index = (index+1)%list.size();
            }
            list.remove(index);
        }
        System.out.println(list.get(0));
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split("110");
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length > maxLen) {
                maxLen = arr.length;
            }
        }
        System.out.println(maxLen);
    }

}
