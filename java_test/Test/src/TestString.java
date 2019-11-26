public class TestString {
    public static void main(String[] args) {
            String str = "abcdef";//直接赋值
            String str2 = new String("abcdef");
            System.out.println(str == str2);//false
            System.out.println(str.equals(str2));
            char[] array = {'a','b','c','d'};
            String str3 = new String(array);
            System.out.println(str == str3);
        }

        public static void main1(String[] args) {
            String str = "abcdef";//直接赋值
            String str2 = new String("abcdef");
            char[] array = {'a','b','c','d'};
            String str3 = new String(array);
            System.out.println(str);
            System.out.println(str2);
            System.out.println(str3);
        }
    }
