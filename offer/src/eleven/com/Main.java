package eleven.com;

import java.util.Scanner;

public class Main {

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer(str);
        String s = new String();
        for (int i = str.length()-1; i >= 0; i++) {
            sb1.append(str.charAt(i));
        }
        s = sb1.toString();
        for (int i = s.length()-1; i >= 1 && !func(sb2.toString()); i--) {
            sb2.insert(s.length(), s.c)
        }
    }

    public static boolean func(String str) {
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if (str.toCharArray()[i] != str.toCharArray()[len-1-i]) {
                return false;
            }
        }
        return true;
    }


}
