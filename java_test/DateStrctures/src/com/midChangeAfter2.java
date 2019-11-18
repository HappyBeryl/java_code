//package com;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//public class midChangeAfter2 {
//    //1+（（2+3）*4）-5 ==》 1 2 3 + 4 * + 5 -
//    public static void main(String[] args) {
//        String str = "1+（（2+3）*4）-5";
//        List infixList = fun(str);
//        System.out.println(infixList);
//        System.out.println("中缀表达式对应的List" +infixList);
//        List after = parse(infixList);
//        System.out.println("后缀表达式对应的List" + after);
//    }
//
//    //将中缀表达式转成对应的List
//    public static List fun(String s) {
//        //定义一个List存放中缀表达式对应的内容
//        List ls = new ArrayList();
//        //用于遍历str
//        int i = 0;
//        //做对多位数的拼接
//        String str;
//        //每遍历到一个字符放入c中
//        char c;
//        do {
//            //如果c是一个非数字，就需要加入到list
//            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
//                ls.add("" + c);
//                i++;
//            } else {
//                //如果是一个数，需要考虑多位数的问题
//                str = "";
//                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57 ) {
//                    str += c; //拼接
//                    i++;
//                }
//                ls.add(str);
//            }
//        } while (i < s.length());
//        return ls;
//    }
//
//
//    public  static List parse(List<String> ls) {
//        //1、定义两个栈
//        Stack s1 = new Stack<String>(); //符号栈
////        Stack s2 = new Stack(); //s2只加东西 逆序输出 不弹栈pop 用List替代
//        List s2 = new ArrayList<String>();
//        //2、遍历ls
//        for(String item: ls) {
//            //若是数，加入
//            if (item.matches("\\d+")) {
//                s2.add(item);
//            } else if (item.equals("(")) {
//                s1.push(item);
//            } else if (item.equals(")")) {
//                while (!s1.peek().equals("(")) {
//                    s2.add(s1.pop());
//                }
//                //将“（”弹出，消除小括号
//                s1.pop();
//            } else {
//                //当item优先级<=s1栈顶运算符的优先级
//               // while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
//                    s2.add(s1.pop());
//                }
//                //还需要将item压入栈中
//                s1.push(item);
//            }
//     //   }
//
//        //7、s1中剩余的加入s2
////        while (s1.size() != 0) {
////            s2.add(s1.pop());
////        }
////        //因为是存放到List，因此顺序输出即可
////        return s2;
////
//  //  }
//}
//
////编写一个类返回运算符的优先级
//class Operation {
//    private static int ADD = 1;
//    private static int SUB = 1;
//    private static int MUL = 2;
//    private static int DIV = 2;
//    public static int getValue(String oper) {
//        int result = 0;
//        switch (oper) {
//            case "+":
//                result = ADD;
//                break;
//            case "-":
//                result = SUB;
//                break;
//            case "*":
//                result = MUL;
//                break;
//            case "/":
//                result = DIV;
//                break;
//            default:
//                 System.out.println("不存在");
//                 break;
//        }
//        return result;
//    }
//
//}
