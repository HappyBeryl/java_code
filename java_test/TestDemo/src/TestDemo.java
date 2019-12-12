import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    public static void main1(String[] args) {
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

    public static void main2(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Hello");
        collection.add("Java");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        //打印方式1
        System.out.println(collection);
        collection.remove("Java");
        System.out.println(collection);
        for(String s: collection) {
            System.out.println(s);
        }
    }

    public static void main3(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("及时雨", "宋江");
        map.put("黑旋风", "李逵");
        System.out.println(map);
        String str = map.getOrDefault("及时雨1", "武松");
        System.out.println(str);
        System.out.println(map.containsKey("黑旋风"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main4(String[] args) {
        //int --> Integer 自动装箱
        Integer a = 10;
        //手动装箱
        Integer b = Integer.valueOf(20);
        System.out.println(b); //20
        //Integer --> int 自动拆箱
        int c = a;
        //手动拆箱 还可以是double ...
        int d = a.intValue();
        System.out.println(b); //10

    }

    public static void main5(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        System.out.println(myArrayList);
        myArrayList.add("Java");
//        myArrayList.add(2); //报错
        String ret = myArrayList.get();
    }

    public static void main(String[] args) {
        public static List<List<Integer>> generate(int numRows) {

            List<List<Integer>> triangle = new ArrayList<>();

            if(numRows == 0) {
                return triangle;
            }
            triangle.add(new ArrayList<>());//0
            triangle.get(0).add(1);
            //行数
            for (int i = 1; i < numRows; i++) {
                List<Integer> curRow = new ArrayList<>();
                curRow.add(1);
                //上一行
                List<Integer> prevRow = triangle.get(i-1);
                //第i行的第j列
                for (int j = 1; j < i; j++) {
                    int tmp = prevRow.get(j-1)+prevRow.get(j);
                    curRow.add(tmp);
                }
                curRow.add(1);
                triangle.add(curRow);
            }
            return triangle;
        }

        public static void main5(String[] args) {
            List<List<Integer>> ret = generate(5);

            for (List<Integer> list  : ret) {
                System.out.println(list);
            }
        }
    }







}
