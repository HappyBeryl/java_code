import java.util.Arrays;

public class TestArray {
    public static void func(int[] arr) {
        arr[0] = 99;
    }
    public static void func1(int x) {
        x = 99;
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3,4};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        func(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        int a = 10;
        System.out.println(a);
        func1(a);
        System.out.println(a);
    }

    public static int[] transform(int[] arr) {
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i]*2;
        }
        return tmp;
    }

    public static void main3(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = transform(arr);
        System.out.println(Arrays.toString(arr2));
    }


    public static String toString(int[] array) {
        String str = "\"";
        for (int i = 0; i < array.length; i++) {
            str += array[i];
            if (i != array.length-1) {
                str += ",";
            }
        }
        str += "\"";
        return str;
    }
    public static void main4(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(toString(arr));
    }

    public static void main5(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        System.out.println(Arrays.toString(array2));
    }

    public static void main6(String[] args) {
       // arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
        //src：代表源数组
        //srcPos：从源数组的pos位置开始拷贝
        //dest：目的数组
        //destPos：目的数组的位置
        //length:要拷贝的长度
        int[] array = {1,2,3,4,5};
        int[] array2 = new int[array.length];
        System.arraycopy(array,0,array2,0,array.length);
        System.out.println(Arrays.toString(array2));
    }

    public static void main7(String[] args) {
        // copyOf(int[] original, int newLength)
        //original:源数组
        //newLength：拷贝的长度
    }

    public static int sum(int...array) {
        int ret = 0;
        for(int x: array) {
            ret += x;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(sum(1,2,3,4,5));
        int[] array = {1,2,3,4,5};
        System.out.println(sum(array));
        //匿名数组
        System.out.println(sum(new int[]{1,2,3,4,5}));



    }




}
