public class TestDemo {
    public static void main(String[] args) {
        char ch = '呵';
        System.out.println(ch);

        byte a = 10;
        byte b = 20;
        //  byte c = a + b; //编译报错
        byte c = (byte)(a+b);
        System.out.println(c);

        short s = 10;
       // char c = (char)s;
        System.out.println(c == s);

       // System.out.println(funbonic(6));

        print(1234);
    }

    public static void print(int n) {
        if (n > 9) {
           print(n/10);
        }
        System.out.println(n%10);
    }

    public static int print2(int n) {
        if (n < 10) {
            return n;
        }
        return n%10 + print2(n/10);
    }

    public static int funbonic(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;
        for (int i = 3; i <= n ; i++) {
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }


}
