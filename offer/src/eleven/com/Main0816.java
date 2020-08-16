package eleven.com;

import java.util.*;
/*
老虎集团
 */
public class Main0816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        int count = 1;
        int num = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == num) {
                count++;
            } else {
               count--;
            }
            if (count == 0) {
                num = list.get(i);
                count = 1;
            }
        }
        System.out.println(num);
    }


    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.keySet().contains(array[i])) {
                map.put(array[i],1);
            } else {
                map.put(array[i],map.get(array[i])+1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(array[i]) != 0) {
                System.out.println(map.get(array[i]));
            } else {
                System.out.println("beiju");
            }
        }
    }
}
