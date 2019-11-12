package com.DataStructures;

import sun.font.FontRunIterator;

public class TestDemo {
    //合并两个有序数组
    //合并
    public static ListNode mergeTwoLists1(ListNode headA, ListNode headB){
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            } else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA == null) {
            tmp.next = headB;
        } else {
            tmp.next = headA;
        }
        return newHead.next;
    }

//    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
//        ListNode newHead = new ListNode(-1);
//        ListNode tmp = newHead;
//        while (headA != null && headB != null) {
//            if (headA.data < headB.data) {
//                tmp.next = headA;
//                headA = headA.next;
//                tmp = tmp.next;
//            } else {
//                tmp.next = headB;
//                headB = headB.next;
//                tmp = tmp.next;
//            }
//        }
//        if (headA == null) {
//            tmp.next = headB;
//        } else {
//            tmp.next = headA;
//        }
//        return newHead.next;
//    }

    public static void createCyle(ListNode headA, ListNode headB) {
        headA.next = headB.next.next;
    }
    //相交
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode pL = headA;//永远指向长的单链表
        ListNode pS = headB;//永远指向短的单链表
        int lenA = 0;
        int lenB = 0;
        //求的lenA  lenB
        while (pL != null) {
            lenA++;
            pL = pL.next;
        }
        while (pS != null) {
            lenB++;
            pS = pS.next;
        }
        //pl、ps为空了
        pL = headA;
        pS = headB;
        //差值-》最长的单链表先走len步
        int len = lenA-lenB;
        if(len < 0) {
            pL = headB;
            pS = headA;
            len = lenB-lenA;
        }
        //让pL先走len步
        for (int i = 0; i < len; i++) {
            pL = pL.next;
        }
        //开始一起走  (pL  != pS ) {一人一步走}
        while (pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
//        if (pL == null) {
//            return null;
//        }
//        return pL;
        return pL;
    }


    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        MySingleList mySingleList1 = new MySingleList();
        mySingleList1.addLast(3);
        mySingleList1.addLast(4);
        mySingleList1.addLast(7);
        mySingleList1.addLast(25);
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(4);
        mySingleList.addLast(8);
        ListNode newHead = mergeTwoLists1(mySingleList.head, mySingleList1.head);
        mySingleList.disPlay2(newHead);



    }
}
