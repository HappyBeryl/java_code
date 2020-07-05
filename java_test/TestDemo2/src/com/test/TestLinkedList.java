package com.test;

public class TestLinkedList {
    //链表的实现
    class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode head;
    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = head;
        if (head == null) {
            head = node;
        } else {
            while (cur != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void removeAllKey(int key) {
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (prev.next.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.data == key) {
            head = head.next;
        }
    }

    //翻转链表
    public  ListNode reverseList() {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            prev.next = cur;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    //返回链表中间节点
    public ListNode middleNode() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode FindkthtoTail(int k) {
        if (k < 0 || head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k-1; i++) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode headA, ListNode headB) {
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
        }
        if (headB == null) {
            tmp.next = headA;
        }
        return newHead.next;
    }

    public ListNode partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.data < x) {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                }
            }else {
                if (as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                }
            }
            cur = cur.next;
        }
        if (bs == null) {
            return as;
        }
        if (as != null) {
            ae.next = null;
        }
        be.next = as;
        return bs;
    }

   public boolean deleteDuplication() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

       ListNode cur = slow.next;
       while (slow != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (head != slow) {
            if (head.data != slow.data) {
                return false;
            }
            if (head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
       return true;
   }


}
