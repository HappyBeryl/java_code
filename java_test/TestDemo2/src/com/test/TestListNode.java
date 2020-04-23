package com.test;

public class TestListNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    ListNode head  = null;
    public void removeAllKey(int key) {
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while (cur != null) {
            if (prev.next.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev.next = cur;
                cur = cur.next;
            }
        }
        if (this.head.val == key) {
            this.head = this.head.next;
        }
    }

    public int kthToLast(ListNode head, int k) {
        if(head == null || k <= 0) {
            return -1;
        }
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < k-1; i++) {
            if(fast.next == null) {
                return -1;
            }
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    public ListNode partition(int k) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < k) {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                if (as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
        }

        if (bs == null) {
            return as;
        }
        if (be != null) {
            be.next = as;
        }
        if (be.next != null) {
            be.next = null;
        }
        return bs;
    }
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
        return pL;
    }




}
