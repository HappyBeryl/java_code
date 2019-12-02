//泛型 容器=集合 18-22web

class MyException extends Exception {
    public MyException(String s) {
        super(s);
    }
}


public class TestException {
    public static void main1(String[] args) {
        int a = 10;
        try {
            if (a == 10) {
                throw new Exception("异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }


    //2、
    public static void main2(String[] args) {
        String str = null;
        try{
            System.out.println(str.length());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("空指针异常");
        }
        System.out.println("java");
    }

    public static void main3(String[] args) {
        int[] array = {1,2,3};
        try {
            array[4] = 99;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("数组越界异常");
        }
        System.out.println("hello");
    }

    public static void main15(String[] args)  {
        int a = 10;
        try {
            if (a == 10) {
                throw new   MyException("异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main16(String[] args) {
        String str = "abc";
        String str2 = str + "def";
        System.out.println(str2);
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb);
        sb.append("java");
        System.out.println(sb);
        System.out.println(sb.append("java"));
    }


}


