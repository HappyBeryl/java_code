package eleven.com;
/*
5
BA
aOWVXARgUbJDG
OPPCSKNS
HFDJEEDA
ABBABBBBAABBBAABAAA
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main082202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n<2||m>105) {
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }

        for (int i = 0; i < m; i++) {
            int bo = sc.nextInt();
            if (bo == 1) {
                int tmp = arr[0];
                for (int j = 0; j < arr.length-1; j++) {
                    arr[j] = arr[j+1];
                }
                arr[arr.length-1] = tmp;
            }
            int t = 0;
            if (bo == 2) {
                for (int j = 0; j < arr.length; j+=2) {
                    t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
        for (int i = 0; i < arr.length-1; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.print
                (arr[arr.length-1]);
    }


    public static void main11(String[] args) {
        int num = 5;
        int count = 0;
        String  str = null;
        String[] strarry= new String[]{"BA","aOWVXARgUbJDG",
                "OPPCSKNS",
                "HFDJEEDA",
                "ABBABBBBAABBBAABAAA"};
        while (num != 0) {
            for (int i = 0; i < num; i++) {
              str = strarry[i];
            }
            char[] arr = str.toCharArray();
            int tmp = 0;
            if (arr.length <= 10) {
                for (int i = 0; i < arr.length; i++) {
                    char ch = arr[i];
                    if (ch >= 65 && ch <= 122) {
                        tmp++;
                    } else {
                        break;
                    }
                }
                if (tmp == arr.length) {
                    count++;
                }
            }
            num--;
        }
        System.out.println(count);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 1 || num > 2000) {
            return;
        }
        int count = 0;
        while (num != 1) {
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            int tmp = 0;
            if (arr.length <= 10) {
                for (int i = 0; i < arr.length; i++) {
                    char ch = arr[i];
                    if (ch >= 65 && ch <= 122) {
                        tmp++;
                    } else {
                        break;
                    }
                }
                if (tmp == arr.length) {
                    count++;
                }
            }
            num--;
        }
        System.out.println(count);
    }
}
