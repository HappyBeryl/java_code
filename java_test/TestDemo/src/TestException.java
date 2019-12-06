//泛型 容器=集合 18-22web

import java.util.Scanner;

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

    public static void main26(String[] args) {
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb);
        sb.append("java");
        System.out.println(sb);
        System.out.println(sb.append("java"));
        //异常
        System.out.println(10/0);
        int[] arr = {1,2,3};
        System.out.println(arr[100]);

    }

    //测试异常
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println("before");
            System.out.println(arr[100]);
            System.out.println("afer");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("afer try catch");
        try(Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            System.out.println("sum = " + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int divide(int x, int y) {
        if (y == 0) {
            throw new ArrayIndexOutOfBoundsException("抛出除0异常");
        }
        return x/y;
    }

    private static void login(String userName, String password) {
        if (userName.equals(userName)) {
            System.out.println("处理用户名错误");
        }
        if (password.equals(password)) {
            System.out.println("处理密码错误");
        }
        System.out.println("登陆成功");
    }


}


