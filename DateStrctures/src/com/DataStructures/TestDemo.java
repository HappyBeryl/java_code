package com.DataStructures;

public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(2);
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(4);
        mySingleList.addLast(2);
        mySingleList.addIndex(2,111);
        boolean bool = mySingleList.contains(111);
        System.out.println(bool);
        mySingleList.removeAllKey(2);
        mySingleList.diaplay();



    }
}
