package com.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        ListNode prev = null;
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null) {
            //重复的节点
            if(cur.next != null && cur.data == cur.next.data) {
                //每一次都需要判断cur.next
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        //最后一个节点如果也是重复的，需要将tmp.next置为空
        tmp.next = null;
        return newHead.next;
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    public void preorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.value);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.value);
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }


    public boolean hasCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null)  {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next ==null) {
            return false;
        }
        return true;
    }

}
