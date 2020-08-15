package eleven.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main0815 {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        char value;

        public TreeNode(char value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] array = str.split("|");
        for (int i = 1; i < array.length; i++) {
            String s = array[i];
            String[] tmp = s.split("`");
            TreeNode A = new TreeNode(tmp[0].charAt(i));
        }
        System.out.println(200);
    }



    static int[] divingBoard(int a, int b, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            list.add(i*a+(k-i)*b);
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        Arrays.sort(array);
        return array;
    }

    public static void main1(String[] args) {
        int[] array = divingBoard(1,2,3);
        System.out.println(Arrays.toString(array));
    }
}
