package nine;

import java.util.Arrays;

public class Mainzuiyou {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,3,6,7};
        int[] result = findNumTwo(arr);
        System.out.println(Arrays.toString(result));
    }
    public static int findNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("非法");
            return -1;
        }
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tmp ^= arr[i];
        }
        return tmp;
    }

    public static int[] findNumTwo(int[] arr) {
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tmp ^= arr[i];
        }
        int len = Integer.SIZE;
        int flg = 1;
        while (len >= 0) {
            len--;
            if (((flg<<len)&tmp) != 0) {
                flg <<= len;
                break;
            }
        }
        //分组
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((flg & arr[i]) == 0) {
              a ^= arr[i];
            } else {
                b ^= arr[i];
            }
        }
        return new int[]{a,b};
    }

        public static int binarySearch(int[] arr, int tar) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (tar < arr[mid]) {
                right = mid-1;
            } else if (tar > arr[mid]) {
                left = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
