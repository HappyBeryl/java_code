package com.DataStructures;

public class TestDemo {
    public static void main(String[] args) {
        MySingleList1 mySingleList = new MySingleList1();
        mySingleList.addLast(2);
        mySingleList.addLast(1);
        mySingleList.addLast(3);
        mySingleList.addLast(4);
        mySingleList.addLast(2);
        mySingleList.addIndex(2,111);
        boolean bool = mySingleList.contains(111);
        System.out.println(bool);
//        ListNode node = mySingleList.middleNode();
//        System.out.println(node.data);
        mySingleList.disPlay();
//        ListNode newHead = mySingleList.reverseList();
//        mySingleList.disPlay2(newHead);
       // mySingleList.reverseList2();
        ListNode node = mySingleList.findKthToTail(2);
        System.out.println(node.data);



    }
}
