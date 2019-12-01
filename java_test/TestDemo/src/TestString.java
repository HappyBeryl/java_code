import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Arrays;

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

    public static void main(String[] args) {
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
}

