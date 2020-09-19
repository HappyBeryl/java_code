package nine;

import java.util.*;

public class Main091302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        List<List<Integer>> result = func(arr);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j)+" ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> func(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i >= 1 && arr[i] == arr[i - 1]) {
                continue;
            }
            int j = i + 1;
            int z = arr.length - 1;
            while (j < z) {
                if (arr[i] + arr[j] + arr[z] == 0) {
                    ret.add(Arrays.asList(arr[i], arr[j], arr[z]));
                    j++;
                    z--;
                    while (j < z && arr[j] == arr[j - 1]) j++;
                    while (j < z && arr[z] == arr[z + 1]) z--;
                } else if (arr[i] + arr[j] + arr[z] > 0) {
                    z--;
                } else {
                    j++;
                }
            }
        }
        return ret;
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length/2]);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Set<Character> set = new HashSet<>();
        int ret = 0;
        for (int i = 0, j=0; j < str.length(); j++) {
            char ch = str.charAt(j);
            while (set.contains(ch)) {
                set.remove(str.charAt(i++));
            }
            set.add(ch);
            ret = Math.max(ret, j-i+1);
        }
        System.out.println(ret);
    }
}
