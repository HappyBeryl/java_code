package nine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main0915 {

    public static void main(String[] args) {
        System.out.println("5678");
    }
    public static void main11(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String max = "";
        int count = 0;
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '5' && str.charAt(i) <= '8') {
                j = i;
                while (str.charAt(i) >= '5' && str.charAt(i) <= '8') {
                    i++;
                }
                if (i < str.length()) {
                    String tmp = str.substring(j, i);
                    if (tmp.length() > max.length()) {
                        max = tmp;
                    }
                }

            }
         }
        System.out.println(max);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str ="AAAAABCCCCCCC";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey()+"="+entry.getValue()+" ");
        }
    }
}
