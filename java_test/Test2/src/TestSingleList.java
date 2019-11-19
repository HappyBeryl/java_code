import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.WeakHashMap;

public class TestSingleList {
    //5、合并两个有序数组
    //合并
    public static ListNode mergeTwoLists12(ListNode headA, ListNode headB){
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
            if (headA == null) {
                tmp.next = headB;
            } else {
                tmp.next = headA;
            }
        }
        return newHead.next;
    }

    public static ListNode mergeTwoLists1(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        if (headA.data < headB.data) {
            tmp.next = headA;
            tmp = tmp.next;
            headA = headA.next;
        } else {
            tmp.next = headB;
            tmp = tmp.next;
            headB = headB.next;
        }
        if (headA == null) {
            tmp.next = headB;
        } else {
            tmp.next = headA;
        }
        return newHead.next;
    }
//    //  创造一个环
//    public static void createCyle(ListNode headA, ListNode headB) {
//        headA.next = headB.next.next;
//    }

    //    //相交
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode pL = headA;
        ListNode pS = headB;
        int lenA = 0;
        int lenB = 0;
        while (pL != null) {
            lenA++;
            pL = pL.next;
        }
        while (pS != null) {
            lenB++;
            pS = pS.next;
        }
        pL = headA;
        pS = headB;
        int len = lenA-lenB;
        if (len < 0) {
            pL = headB;
            pS = headA;
            len = lenB-lenA;
        }
        for (int i = 0; i < len; i++) {
            pL = pL.next;
        }
        while (pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
        return pL;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pL = headA;
        ListNode pS = headB;
        int lenA = 0;
        int lenB = 0;
        while (pL != null) {
            lenA++;
            pL = pL.next;
        }
        while (pS != null) {
            lenB++;
            pS = pS.next;
        }
        pL = headA;
        pS = headB;
        int len = lenA-lenB;
        if (len < 0) {
            pL = headB;
            pS = headA;
        }
        for (int i = 0; i < len-1; i++) {
            pL = pL.next;
        }
        while (pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
        return pL;
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addLast(1);
        singleList.addLast(4);
        singleList.addLast(2);
        singleList.addLast(18);
        singleList.addLast(0);
        ListNode node = singleList.removeNthFromEnd(5);
        singleList.disPlay2(node);
       // ListNode node = singleList.partition(2);
        // singleList.disPlay2(node);




    }
}
