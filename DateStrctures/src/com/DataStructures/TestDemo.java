package com.DataStructures;

public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(4);
        mySingleList.creteLoop();
        boolean bol = mySingleList.hasCycle();
        System.out.println(bol);
        ListNode node = mySingleList.detectCycle();
        System.out.println(node.data);



    }
}
