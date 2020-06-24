package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}
//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}
//有返回值无参数
@FunctionalInterface interface NoParameterReturn {
    int test();
}

//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}

//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

public class TestLambda {
    /*
    public static void main(String[] args) {
        NoParameterNoReturn noParameterNoReturn = ()->{
            System.out.println("无参数无返回值！");
        };
        noParameterNoReturn.test();

        OneParameterNoReturn oneParameterNoReturn = (int a)->{
            System.out.println("一个参数无返回值！"+a);
        };
        oneParameterNoReturn.test(10);

        NoParameterReturn noParameterReturn = () ->{
            System.out.println("有返回值无参数");
            return 11;
        };
        int ret = noParameterReturn.test();
    }
    */

    public static void main1(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("haha");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s+" ");
            }
        });
        //lambda表达式表示
        list.forEach(
                s-> System.out.println(s+" ")
        );
    }

    public static void main2(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("bq");
        list.add("hello");
        list.add("lambda");
        list.sort(new Comparator<String>() {
            @Override public int compare(String str1, String str2){
                //注意这里比较长度
                return str1.length()-str2.length();
            }
        });
        System.out.println(list);
        System.out.println("---------");
        //调用带有2个参数的方法，且返回长度的差值
        list.sort((str1,str2)-> str1.length()-str2.length());
        System.out.println(list);
    }

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "a");
        hashMap.put(2, "b");
        hashMap.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println("key:"+integer+"val:"+s);
            }
        });
        hashMap.forEach((k,v)-> System.out.println("key:"+k+"val:"+v));
    }



}
