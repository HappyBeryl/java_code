//package com;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class midChangeAfter {
//    //1+（（2+3）*4）-5 ==》 1 2 3 + 4 * + 5 -
//    public static void main(String[] args) {
//        String str = "1+（（2+3）*4）-5";
//        List infixList = fun(str);
//        System.out.println(infixList);
//    }
//
//    //将中缀表达式转成对应的List
//    public static List<String> fun(String s) {
//        //定义一个List存放中缀表达式对应的内容
//        List<String> ls = new ArrayList<String>();
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
//}
