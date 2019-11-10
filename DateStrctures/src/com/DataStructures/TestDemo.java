package com.DataStructures;

public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(1);
        mySingleList.addLast(4);
        mySingleList.addLast(3);
        mySingleList.addLast(2);
        mySingleList.addLast(5);
        mySingleList.addLast(2);
        mySingleList.display();
        ListNode newHead = mySingleList.partition(3);
        mySingleList.disPlay2(newHead);



    }
}
