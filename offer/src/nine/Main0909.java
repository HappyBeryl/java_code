package nine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
华为
 */
public class Main0909 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String look = sc.nextLine();
        String count = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        String lookall = sc.nextLine();
        String countall = sc.nextLine();
        int a = -1;
        int b = -1;
        if (lookall.indexOf(look) != -1) {
            a = lookall.indexOf(look);
        }
        if (countall.indexOf(count) != -1) {
            b = countall.indexOf(count);
        }
        if (a == b && a != -1) {
            System.out.println(a+1);
        } else {
            System.out.println(0);
        }
    }
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] look = new int[k];
        int[] count = new int[k];
        for (int i = 0; i < k; i++) {
            look[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            count[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int[] alllook = new int[n];
        int[] allcount = new int[n];
        for (int i = 0; i < n; i++) {
            alllook[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            allcount[i] = sc.nextInt();
        }
        int ret1 = findIndex(look, alllook);
    }

    private static int findIndex(int[] look, int[] alllook) {
        int i = -1;
        int j = -1;
        int index = 0;
        int count = 0;
        while (i < look.length && j < alllook.length) {
            if (look[i] != alllook[j]) {
               j++;
            } else if (look[i] == alllook[j]) {
                i++;
                j++;
                if (look[i] != alllook[j]) {
                    break;
                }
            }

        }
    }*/


    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder look = new StringBuilder();
            StringBuilder count = new StringBuilder();
            StringBuilder allLook = new StringBuilder();
            StringBuilder allCount = new StringBuilder();
            int k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                look.append(sc.nextInt());
            }
            for (int i = 0; i < k; i++) {
                count.append(sc.nextInt());
            }
            if (look.length() != count.length()) {
                System.out.println(0);
                return;
            }
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                allLook.append(sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                allCount.append(sc.nextInt());
            }
            if (allCount.length() != allLook.length()) {
                System.out.println(0);
                return;
            }
            int index1 = -1;
            int index2 = -1;
            int a = allLook.indexOf(look.toString());
            if (a != -1) {
                index1 = a;
            }
            int b = allCount.indexOf(count.toString());
            if (b != -1) {
                index2 = b;
            }
            if (index1 == index2 && index1 != -1) {
                System.out.println(index1 + 1);
            } else {
                System.out.println(0);
            }
        }
    }*/

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
      //  System.out.println(Arrays.toString(arr));
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, func(arr, m, n, i, j));
            }
        }
        System.out.println(max);
    }

    //获取最长路径
    private static int func(int[][] arr, int m, int n, int i, int j) {
        boolean[][] walk = new boolean[m][n];
        int[] maxSize = new int[1];
        getLength(arr, walk, m, n, i, j, new ArrayList<>(), maxSize);
        return maxSize[0];
    }

    private static void getLength(int[][] arr, boolean[][] walk, int m, int n, int i, int j, ArrayList<Integer> list, int[] maxSize) {
        if (i < 0 || i >= m|| j < 0 || j >= n || walk[i][j] == true) {
            return;
        }
        int now = arr[i][j];
        if (list.isEmpty() || list.get(list.size()-1) < now) {
            list.add(now);
            walk[i][j] = true;
            maxSize[0] = Math.max(maxSize[0],list.size());

            //下一个
            getLength(arr, walk, m, n, i-1, j, list, maxSize);
            getLength(arr, walk, m, n, i+1, j, list, maxSize);
            getLength(arr, walk, m, n, i, j-1, list, maxSize);
            getLength(arr, walk, m, n, i, j+1, list, maxSize);

            //回溯
            list.remove(list.size()-1);
            walk[i][j] = false;
        }
    }


    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder look = new StringBuilder();
            StringBuilder count = new StringBuilder();
            StringBuilder allLook = new StringBuilder();
            StringBuilder allCount = new StringBuilder();
            int k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                look.append(sc.nextInt());
            }
            for (int i = 0; i < k; i++) {
                count.append(sc.nextInt());
            }
            if (look.length() != count.length()) {
                System.out.println(0);
                return;
            }
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                allLook.append(sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                allCount.append(sc.nextInt());
            }
            if (allCount.length() != allLook.length()) {
                System.out.println(0);
                return;
            }
            int index1 = -1;
            int index2 = -1;
            int a = allLook.indexOf(look.toString());
            if (a != -1) {
                index1 = a;
            }
            int b = allCount.indexOf(count.toString());
            if (b != -1) {
                index2 = b;
            }
            if (index1 == index2 && index1 != -1) {
                System.out.println(index1 + 1);
            } else {
                System.out.println(0);
            }
        }
    }
    */

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] look = new int[k];
        int[] count = new int[k];
        for (int i = 0; i < k; i++) {
            look[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            count[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int[] alllook = new int[n];
        int[] allcount = new int[n];
        for (int i = 0; i < n; i++) {
            alllook[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            allcount[i] = sc.nextInt();
        }
        int index1 = 0;
        int count1 = 0;
        int index2 = 0;
        int count2 = 0;
        for (int i = 0; i < alllook.length; i++) {
            if (alllook[i] == look[i]) {
                index1 = i;
                count1++;
            } else if (count1 == look.length-1){
                break;
            } else {
                count1 = 0;
            }
        }

        for (int i = 0; i < allcount.length; i++) {
            if (allcount[i] == count[i]) {
                index2 = i;
                count2++;
            } else if (count2 == count.length-1){
                break;
            } else {
               count2 = 0;
            }
        }

        if (index1 == look.length && index2 == index1) {
            System.out.println(index1+1);
        } else {
            System.out.println(0);
        }
    }*/
}
