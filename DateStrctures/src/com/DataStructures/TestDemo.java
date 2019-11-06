package com.DataStructures;

public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(8);
        mySingleList.addLast(1);
        mySingleList.addLast(3);
        mySingleList.addLast(4);
        mySingleList.addLast(2);
        mySingleList.addIndex(2,111);
//        boolean bool = mySingleList.contains(111);
//        System.out.println(bool);
//        ListNode node = mySingleList.middleNode();
//        System.out.println(node.data);
 //       mySingleList.disPlay();
//        ListNode newHead = mySingleList.reverseList();
//        mySingleList.disPlay2(newHead);
       // mySingleList.reverseList2();
//      ListNode node = mySingleList.findKthToTail(2);
         mySingleList.display();
//        ListNode node = mySingleList.findKthToTail1(66);
//        if(node == null) {
//            System.out.println("不存在");
//        } else {
//            System.out.println(node.data);
//        }

//        ListNode node = mySingleList.reverseList();
//        mySingleList.disPlay2(node);
        ListNode node1 = mySingleList.middleNode();
        System.out.println(node1.data);




    }
}
