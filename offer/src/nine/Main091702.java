
package nine;

import java.util.Arrays;
import java.util.Scanner;

public class Main091702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int zu = Integer.parseInt(sc.nextLine());
        while (zu-- > 0) {
            int n = sc.nextInt();
            int[] xArray = new int[n];
            int[] yArray = new int[n];
            for (int i = 0; i < n; i++) {
                xArray[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                yArray[i] = sc.nextInt();
            }
            int big = 0;
            int small = 0;
            for (int i = 0; i < xArray.length; i++) {
                for (int j = i+1; j < xArray.length; j++) {
                    if (xArray[i] > xArray[j] && yArray[i] > yArray[j]) {
                        big++;
                    } else if (xArray[i] < xArray[j] && yArray[i] < yArray[j]){
                        small++;
                    }
                }
            }
            int result = big > small ? big:small;
            System.out.println(result);
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] distance = new int[n];
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        Arrays.sort(score);
        System.out.println(score[score.length-1]);
    }
}
