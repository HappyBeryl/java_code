package com.test;

import java.util.Arrays;

public class Demo {

    public static int[] mulTwoArray(int[] array) {
        int[] array2 = new int[5];
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i]*2;
        }
        return
                array2;
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] array2 = mulTwoArray(array);
        for(int x : array2) {
            System.out.println(x);
        }

        int[] arr = {1,2,3};
//        for (int x: arr) {
//            System.out.println(x);
//        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main2(String[] args) {
        /*
        数组的拷贝
        1、for循环
        2、System.arraycopy拷贝
        3、Array.copyOf拷贝
        4、数组名.clone

         */

        //2
//        int[] arr = {1,2,3};
//        int[] arr2 = new int[arr.length];
//        System.arraycopy(arr,0,arr2,0,arr.length);
//        System.out.println(Arrays.toString(arr2));
        //3
//        int[] arr = {1,2,3};
//        int[] arr2 = Arrays.copyOf(arr,arr.length); //arr2只是存放拷贝完的引用
//        System.out.println(Arrays.toString(arr2));
        //4
        int[] arr = {1,2,3};
        int[] arr2 = arr.clone();
        System.out.println(Arrays.toString(arr2));
    }

    public static int changeNum(int n) {
        n = 20;
        return n;
    }

    public static void main3(String[] args) {
        int a = 10;
        int ret = changeNum(a);
        System.out.println(a);
    }

    public static void printArr(int[] arr1) {
        for (int x: arr1) {
            System.out.println(x);
        }
    }

    public static void main4(String[] args) {
        int[] arr = {1,2,3};
        printArr(arr);
    }

    public static void main5(String[] args) {
        int[] arr = {1,2,3};
        String newArr = Arrays.toString(arr);
        System.out.println(newArr);
    }

    public static String tostring(int[] arr) {
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
            if(i != arr.length-1) {
                ret += ",";
            }
        }
        ret += "]";
        return ret;
    }


    public static void main6(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(tostring(arr));
    }

    int[][] array1 = {{1,2,3},{4,5,6}};
    int[][] array2 = new int[][]{{1,2,3},{4,5,6}};
    int[][] array3 = new int[2][3];  //定义 没有初始化
    int[][] array4 = new int[2][]; //可以不写列


    public static int printMax(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }


    public static double printAver(int[] array) {
        double sum = 0;
        for (int i = 0; i <array.length; i++) {
            sum += array[i];
        }
        return sum/array.length;
    }

    public static void reverse(int[] array) {
        int[] newArray = new int[array.length];
        int left = 0;
        int right = array.length-1;
        int tmp = array.length;
        for (int i = 0; i < array.length; i++) {
            while(tmp != 0) {
                newArray[right] = array[left];
                left++;
                right--;
                tmp--;
            }
        }
        System.out.println(Arrays.toString(newArray));
    }

    public  static int[] changePos(int[] array) {
        int left = 0;
        int right = array.length-1;
        while(left < right && left < right) {
            while(array[left]%2 == 0) {
                left++;
            }
            while(left < right && array[right]%2 != 0) {
                right--;
            }
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
       return array;
    }



    public static void main7(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] array = changePos(arr);
        System.out.println(Arrays.toString(array));
        //int ret = printMax(arr);
        //double ret = printAver(arr);
       // reverse(arr);
       // System.out.println(ret);
    }

    public static int binarySearch1(int[] array, int num) {
        int left = 0;
        int right = array.length-1;
        int mid = 0;
        while (left <= right) {
            mid = (left+right)/2;
            if (array[mid] < num) {
                left = mid+1;
            }else if(array[mid] > num) {
                right = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int num, int left, int right) {
        if(left > right ) {
            return -1;
        }
        int mid = left+right;
        if(array[mid] > num) {
            return binarySearch(array, num, left, mid-1);
        }else if(array[mid] < num) {
            return binarySearch(array, num,  mid+1,  right);
        }else {
            return mid;
        }
    }

    public static void main9(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int ret = binarySearch(arr,5,0,arr.length-1);
        System.out.println(ret);
    }

    public static int[] bubbleSort(int[] array) {
        boolean flg =false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                flg = false;
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if (!flg) {
                break;
            }
        }
        return array;
    }


    public static void main(String[] args) {
        int[] arr = {1,3,9,7,4,6,2,8,5};
        int[] arr1 = bubbleSort(arr);
        System.out.println(Arrays.toString(arr1));
    }


}
