package review;

import java.util.ArrayList;
import java.util.List;

public class TestRemove {
    public static void main(String[] args) {
        Integer a = -128;
        Integer b = 256;
        Integer c = -128;
        Integer d = 256;
        System.out.println(a == c);
        System.out.println(b == d);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (int i = 0; i < list.size(); i++) {
            list.remove(list.get(i).equals(3));
        }
        System.out.println(list);
    }
}
