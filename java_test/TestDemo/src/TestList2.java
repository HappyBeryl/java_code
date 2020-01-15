import sun.font.FontRunIterator;

import java.util.*;
import java.util.stream.LongStream;

class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestList2 {

    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(4);
        list.add(7);
        list.add(6);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> triangle = new ArrayList<>();
       triangle.add(new ArrayList<>()); //0行
        triangle.get(0).add(1);
        //行数
        for (int i = 0; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            //上一行
            List<Integer> prevRow = triangle.get(i-1);
            //第i行第j列
            for (int j = 1; j < i; j++) {
                int tmp = prevRow.get(j-1)+prevRow.get(j);
                curRow.add(tmp);
            }
            curRow.add(1);
            triangle.add(curRow);
        }
        return triangle;
    }

    public static List<Character> func(String str1, String str2) {
        List<Character> ret = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch+"")) {
                ret.add(ch);
            }
        }
        return ret;
    }

    public static void main2(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("a", 22));
        list.add(new Person("c",10));
        list.add(new Person("b",55));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        List<Integer> List2 = new LinkedList<>();
        list.add(1); //尾插
        list.add(1,3); //把3插入index=1的位置
        list.addAll(list);  //传入的参数必须实现Collection接口
        list.remove(0);  //删除index位置元素
        int ret = list.get(1);  //获得index位置的元素
        list.set(0,11); //将0号下标的元素设为11
        boolean bol = list.contains(11); //判断11是否在线性表中
        int ret1 = list.indexOf(11); //返回第一个11所在的位置
        int re2 = list.lastIndexOf(11); //返回最后一个11所在的位置
        List l1 = list.subList(0,1); //截取部分list 没有产生新的对象！
    }



}
