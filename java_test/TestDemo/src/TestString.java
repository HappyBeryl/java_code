import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class TestString {
    public static void main1(String[] args) {
        String str = "abcdef";
        String str2 = new String("abcdef");
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f'};
        String str3 = new String(array);
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);
    }

    public static void main2(String[] args) {
        String str1 = "abcdef";
        String str2 = new String("abcdef").intern();
        System.out.println(str1 == str2); //false

        String str3 = "abc" + "def";
        System.out.println(str1 == str3); //true

        String str4 = "abc" + new String("def");
        System.out.println(str1 == str4); //false

        String str5 = "abc";
        String str6 = "def";
        String str7 = str5+str6;
        System.out.println(str1 == str7); //false

        String str8 = str5 + new String("def");
        System.out.println(str1 == str8); //false
    }

    public static void main3(String[] args) {
        String str = "hello";
        str = str + "world";
        str += "!!";
        System.out.println(str);
    }

    public static void main4(String[] args) throws NoSuchFieldException , IllegalAccessException{
        String str = "Hello"; //new String（）
        Class cls = String.class; //获取class对象
        Field field = cls.getDeclaredField("value"); //把str中的value获取到
        field.setAccessible(true);
        char[] value = (char[])field.get(str);
        value[0] = 'h';
        System.out.println(str);
    }

    public static void main5(String[] args) {
        String str = "abcdef";
        char[] array = str.toCharArray();
    }

    public static void main6(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = {97, 98, 99, 100};
        String str = new String(bytes);
        System.out.println(str);

        String str1 = "白";
        byte[] bytes1 = str1.getBytes("Unicode");
        System.out.println(Arrays.toString(bytes1));
    }

    public static void main7(String[] args) {
        String str = "Hello";
        String str1 = "hello";
        System.out.println(str.equals(str1));  //false
        System.out.println(str.equalsIgnoreCase(str1)); //true
        System.out.println(str.compareTo(str1)); //-32
    }

    public static void main8(String[] args) {
        String str = "abcdefg";
        //是否包含 底层调用indexOf（）函数
        System.out.println(str.contains("def")); //true

        //查找子串-》返回下标
        System.out.println(str.indexOf("bcd")); //1

        //从后往前查找子串-》返回下标
        System.out.println(str.lastIndexOf("cd")); //2

        //判断是否以指定字符串开头
        System.out.println(str.startsWith("ab")); //true

        //判断是否以指定字符串结束
        System.out.println(str.endsWith("ef")); //false
    }

    public static void main9(String[] args) {
        String str = "a,bc ab,c b,a";
        //[a,bc, ab,c,b,a]
        String[] string = str.split(" ",2); //所要分得的组数最大是2
        for (int i = 0; i < string.length; i++) {
            String[] string2 = string[i].split(",");
            // [a, bc]
            //[ab, c]
            //[b, a]
            System.out.println(Arrays.toString(string2));
        }
        System.out.println(Arrays.toString(string));
        System.out.println(str.replace('a','A')); //AbcAbcbA
        System.out.println(str.replace("ab","##")); //##c##cba
        System.out.println(str.replaceAll("ab","##")); //##c##cba
        System.out.println(str.replaceFirst("abc","**")); //**abcba
    }


    public static void main10(String[] args) {
        String str = "193.168.1.1";
        String[] strings = str.split("\\.");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    public static char[] mySplit(String str, String repx) {
        char[] value = str.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (value[i] != ' ') {
                char value2 = value[i];
            }
        }
        return value;
    }

    public static String myAppend(String str) {
        String[] strs = str.split(" ");
        String ret = "";
        for(String s : strs) {
            ret += s;
        }
        return ret;
    }

    public static void main11(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(myAppend(str));
    }

    public static void main12(String[] args) {
        String str = "abcdefg";
        System.out.println(str.substring(2)); //cdefg
        System.out.println(str.substring(2,5)); //左闭右开   cde
    }

    public static void main13(String[] args) {
        String str1 = "   abc d e     ";
        System.out.println(str1.trim()); //abc d e

        String str2 = "abCDEFg";
        System.out.println(str2.toUpperCase()); //ABCDEFG
        System.out.println(str2.toLowerCase()); //abcdefg

        char[] array = {'a', 'b', 'c'};
        String str3 = new String(array);
        str3.intern();

        String str4 = "hello";
        System.out.println(str4.concat("Java"));

        String str = "";
        System.out.println(str.isEmpty()); //true
        System.out.println(str.length()); //是方法
    }

    //逆置字符串
    public static String reverse(String string) {
        char[] array = string.toCharArray();
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return String.copyValueOf(array);
    }

    public static void main14(String[] args) {
        String str = "abcdef";
        String ret = reverse(str);
        System.out.println(ret);
    }

    public static String reverse2(String str, int start, int end) {
        char[] array = str.toCharArray();
        while (start < end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
        return String.copyValueOf(array);
    }

    public static String fun(String str, int k) {
        str = reverse2(str, 0, k-1);
        str = reverse2(str, k,str.length()-1);
        str = reverse2(str,0,str.length()-1);
        return str;
    }

    public static void main15(String[] args) {
        String str = "abcdef";
        System.out.println(fun(str,3));
    }

    //合并两个有序数组
    public static int[] bineryArray(int[] array1, int[] array2) {
        int i = 0; //记录array1下标
        int j = 0; //记录array2下标
        int[] tmp = new int[array1.length + array2.length];
        int k = 0; //记录tmp下标
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                tmp[k++] = array1[i++];
            } else {
                tmp[k++] = array2[j++];
            }
        }
        while (i < array1.length) {
            tmp[k++] = array1[i++];
        }
        while (j < array2.length) {
            tmp[k++] = array2[j++];
        }
        return tmp;
    }

    public static void main16(String[] args) {
        int[] array1 = {1,3,6,9};
        int[] array2 = {2,4,6,8};
        int[] ret = bineryArray(array1,array2);
        System.out.println(Arrays.toString(ret));
    }

    //字符串的转化（压缩） aabbccda -》 2a2b2c1d1a
    public static String changeString(String str) {
        char ch = str.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                count++;
            } else {
               stringBuilder.append(count).append(ch);
               ch = str.charAt(i);
               count = 1;
            }
        }
        return stringBuilder.append(count).append(ch).toString(); //拷贝最后一组
    }

    public static void main17(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(changeString(str));
    }

    //i am student -> stduent am i
    //先整体逆置，再单词逆置
    public static String reverseString(char[] array, int start, int end) {
        while (start < end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
        return String.copyValueOf(array);
    }

    public static String fun(String str) {
        char[] array = str.toCharArray();
        //整体逆置
        reverseString(array,0,str.length()-1);
        //逆置单词
        int i = 0;
        int j = 0;
        while (i < array.length) {
            if (array[i] == ' ') {
                i++;
                j++;
            } else if (j == array.length || array[j] == ' ') {
                reverseString(array,i,j-1);
                i = ++j;
            } else {
                j++;
            }
        }
        return String.copyValueOf(array);
    }

    public static void main18(String[] args) {
        String str = "i am stdent";
        System.out.println(fun(str));
    }

    public boolean rotateString(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        sb.append(A);
        if(A.length() == B.length() && A.contains(B)) {
            return true;
        }
        return false;
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0; //指向num1
        int j = 0; //指向num2
        while(i < m && j < n ) {
            if(nums1[i] > nums2[j]) {
                nums1[i++] = nums2[j++];
            } else {
                i++;
            }
        }
        while(j < n ) {
            nums1[i++] = nums2[j++];
        }
        return nums1;
    }

    public static void main20(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        int[] ret = merge(num1,3,num2,3);
        System.out.println(Arrays.toString(ret));
    }

    public static  boolean rotateString1(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        sb.append(A);
        if (A.length() == B.length()) {
             if (sb.toString().contains(B)) {
                 return true;
             } else {
                 return false;
             }
        } else {
            return false;
        }
    }
    public static void main21(String[] args) {
        String str = "ABCDE";
        String str1 = "BCDEA";
        boolean bol = rotateString1(str,str1);
        System.out.println(bol);
    }

    public static void main(String[] args) {
        //abcfdabc --> abcfd
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!stringBuilder.toString().contains(ch + "")) {
               stringBuilder.append(ch);
            }
        }
        System.out.println(stringBuilder.toString());
    }


}

