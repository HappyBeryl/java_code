package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //（3+4）*5-6  ==》 3 4 + 5 * 6 -
        String str = "3 4 + 5 * 6 -";
        //1、现将string放到一个ArrayList
        //2、将ArrayList传递方法 遍历ArrayLis配合栈完成计算
        List<String> list = getListString(str);
        int sum = cal(list);
        System.out.println("计算的结果=" + sum);
    }

    public static List<String> getListString(String string)  {
        String[] arr = string.split("");
        List<String> list = new ArrayList<String>();
        for(String ele : arr) {
            list.add(ele);
        }
        return list;
    }

    //完成逆波兰表达式
    public static int cal(List<String> list) {
        //创建一个栈
        Stack stack = new Stack();
        //遍历list
        for (String item : list) {
            //使用正则表达式取出数
            if (item.matches("\\d+")) { //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop出两个数并运算,再入栈
                int num2 = Integer.parseInt((String) stack.pop());
                int num1 = Integer.parseInt((String) stack.pop());
                int rst = 0;
                if (item.equals("+")) {
                    rst = num1 + num2;
                } else if (item.equals("-")) {
                    rst = num1 - num2;
                } else if (item.equals("*")) {
                    rst = num1 * num2;
                } else if (item.equals("/")) {
                    rst = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把rst入栈
                stack.push(rst + "");
            }
        }
        //最后留在stack中的数就是运算结果
        return Integer.parseInt((String) stack.pop());
    }
}
