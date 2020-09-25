package nine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.*;

public class Mainjingdong {


    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       //int n = sc.nextInt(); //爬n cm
       //int m = sc.nextInt();
        int n = 60;
        int m = 1;
       int high = m*100;
       int days = 0;
       int tmp = n/2;
       int last = tmp;
       while (high > 0) {
           if (days != 0) {
               tmp = tmp+last;
               last /= 2;
           }
           high = high-n;
           if (high <= 0) {
               break;
           } else {
               high += tmp;
           }
           days++;
       }
        System.out.println(days);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            if (str.length() >= 4) {
                for (int i = 0; i < str.length() - 4; i++) {
                    for (int j = i; j < str.length() - 4; j++) {
                       // if (str.contains())
                    }
                }
            }
        }

    }
}
