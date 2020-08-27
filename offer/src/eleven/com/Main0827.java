package eleven.com;

import java.util.*;

public class Main0827 {
    public static void main(String[] args) {
        System.out.println("");
    }

    static class Sheep {
        public int age = 0;
    }

    public static void main111(String[] args) {
        Scanner sc = new Scanner(System.in);
        int twos = sc.nextInt();
        int fours = sc.nextInt();
        int die = sc.nextInt();
        int year = sc.nextInt();
        int ret = getCount(twos, fours, die, year);
        System.out.println(ret);
    }

    private static int getCount(int twos, int fours, int die, int year) {
        ArrayList<Sheep> sheeps = new ArrayList<>();
        sheeps.add(new Sheep());

        List<Sheep> addSheep = new ArrayList<>();
        List<Sheep> delSheep = new ArrayList<>();

        for (int i = 1; i <= year; i++) {
            for (Sheep s : sheeps) {
                s.age++;
                if (s.age == twos || s.age == fours) {
                    addSheep.add(new Sheep());
                } else if (s.age == die) {
                    delSheep.add(s);
                }
            }
            sheeps.addAll(addSheep);
            sheeps.remove(delSheep);
            addSheep.clear();
            delSheep.clear();
        }
        return sheeps.size();
    }


    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        StringBuffer tmp = new StringBuffer();
       // find(n,m, tmp);
    }

//    private static void find(int n, int m, StringBuffer tmp) {
//        List<StringBuffer> list = new ArrayList<>();
//        if (n != 0) {
//            tmp.append('a');
//            list.add(tmp);
//            find(n-1, m, tmp);
//            tmp.
//        }
//    }




//    static int count = 1;
//
//    private static int func(int twos, int fours, int die, int year) {
//        for (int i = 0; i <= year; i++) {
//            if (i == twos || i == fours) {
//                count++;
//                func(twos, fours, die, year-i);
//            }
//            if (i == 5) {
//                count--;
//                break;
//            }
//        }
//        return count;
//    }

    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.substring(1,str.length()-1);
        String[] strArr = str.split(",");
        int[] array = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            array[i] = Integer.parseInt(strArr[i]);
        }
        int[] dp = new int[array.length+1];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1]+array[i], array[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        int[] dp = new int[list.size()+1];
        dp[0] = list.get(0);
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            dp[i] = Math.max(dp[i-1]+list.get(i), list.get(i));
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }*/


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] array = str.split(" ");
            String haystack = array[0];
            String needle = array[1];
            if (needle.isEmpty()) {
                System.out.println(0);
                return;
            }
            int hlen = haystack.length();
            int nlen = needle.length();
            for (int i = 0; i <= hlen - nlen; i++) {
                int j;
                for (j = 0; j < nlen; j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        break;
                    }
                }
                if (j == nlen) {
                    System.out.println(i);
                    return;
                }
            }
            System.out.println(-1);
            return;
        }
    }
}
