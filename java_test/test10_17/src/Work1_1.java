
//
//    public static void printAge(int age) {
//        if(age <= 18) {
//            System.out.println("少年");
//        }else if(age <= 28) {
//            System.out.println("青年");
//        }
//    }
//
//    public static int func1(int a, int b) {
//        while(a%b != 0) {
//            int c = a%b;
//            a = b;
//            b = c;
//        }
//        return b;
//    }
//
//    public static int func() {
//        int count = 0;
//        for (int i = 0; i <= 100; i++) {
//            if(i%10 == 9) {
//                count++;
//            }
//            if(i/10 == 9) {
//                count++;
//            }
//        }
//        return count;
//    }
//
////    public static void fun2() {
////        int count = 0;
////        int tmp = i;
////        for (int i = 0; i < 999999; i++) {
////
////        }
////    }
//    public static void main(String[] args) {
//       // printAge(10);
//       //int ret =  func1(15,20);
//        int ret = func();
//        System.out.println(ret);
//    }
//}
public class Work1_1 {
    public static int PrintOneNum(int n) {
        int count = 0;
//        while(n != 0) {
//            if(n%2 == 1) {
//                count++;
//            }
//            n /= 2;
//        }
//        return count;
        while (n != 0) {
            count++;
            n = n &   (n - 1);
        }
        return count;
    }
    public static void main1(String[] args) {
        int ret = PrintOneNum(15);
        System.out.println(ret);
    }


    public static  int aver(int n, int m) {
        return  (n&m) + (n^m)>>1;
    }

    public static void main2(String[] args) {
        int ret = aver(6,8);
        System.out.println(ret);
    }


    public static void printNum(int n) {
        System.out.print("偶数位；");
        for (int i = 31; i >= 1 ; i-=2) {
            System.out.print(((n>>i)&1) + " ");
        }
        System.out.println();
        System.out.println("=========");
        System.out.print("奇数位；");
        for (int i = 30; i >= 0 ; i-=2) {
            System.out.print(((n>>i)&1) + " ");
        }
    }

    public static void main(String[] args) {
        printNum(8);
    }
}