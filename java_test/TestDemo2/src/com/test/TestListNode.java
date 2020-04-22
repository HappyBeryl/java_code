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



}
