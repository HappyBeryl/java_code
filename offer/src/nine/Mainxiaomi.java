package nine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
小米
 */
public class Mainxiaomi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int col = 0;
        String findWord = "";
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        findWord = list.get(list.size()-1);
        col = list.get(0).length();
        String[][] arr = new String[list.size()][col];
        for (int i = 0; i < arr.length; i++) {
            String str = list.get(i);
            String[] arrString = str.split(",");
            for (int j = 0; j < col-1; j++) {
                System.out.println("是我"+arrString[j]);
                arr[i][j] = arrString[j];
            }
        }
        System.out.println(isExist(arr,findWord));
    }

    public static boolean isExist(String[][] arr, String findWord) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == findWord.charAt(0)+"") {
                    if (func(i,j,0,arr,findWord)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean func(int i, int j, int start, String[][] arr, String findWord) {
        if (findWord.length() == start) {
            return true;
        }
        if (i < 0 || i >=  arr.length || j < 0 || j >= arr[0].length || arr[i][j] != findWord.charAt(start)+"") {
            return false;
        }
        String ch = arr[i][j];
        arr[i][j] = "#";
        boolean ret;
        ret = func(i+1,j,start+1,arr,findWord)
                ||func(i-1,j,start+1,arr,findWord)
                ||func(i,j+1,start+1,arr,findWord)
                ||func(i,j-1,start+1,arr,findWord);
        arr[i][j] = ch;
        return ret;
    }

    static int[] primeFactorization(int num) {
        int x = 2;
        List<Integer> list = new ArrayList<>();
        while (x <= num) {
            if (x == num) {
                list.add(num);
                break;
            } else if (num % x == 0) {
                list.add(x);
                num /= x;
            } else {
                x++;
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static void main1(String[] args) {
        int[] ret = primeFactorization(100);
        System.out.println(Arrays.toString(ret));
    }
}
