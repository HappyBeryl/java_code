package com.test;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class TestListNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int val) {
            this.value = val;
        }
    }

    ListNode head = null;
    public void removeAllKey(int key) {
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (prev.next.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == key) {
            head = head.next;
        }
    }

    public ListNode reverseList(){
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
            cur.next = prev;
            prev = cur;
            cur = cur.next;
        }
        return newHead;
    }

    public ListNode middleNode() {
        ListNode fast = head;
        ListNode slow = head;
        if (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode FindKthToTail(int k) {
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

    public  ListNode mergeTwoLists1(ListNode headA, ListNode headB){
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (headA != null && headB != null) {
            if (headA.val < head.val) {
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
            tmp.next = headB;
        }
        return newHead.next;
    }

    public ListNode partition(int x){
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val < x) {
                //判断是否为第一次加入
                if (bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                //判断是否为第一次加入
                if (as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //判断是否k是否小于所以节点
        if (bs == null) {
            return as;
        }
        //连在一起
        if (be != null) {
            be.next = as;
        }
        if (as != null) {
            ae.next = null;
        }
        return bs;
    }

    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null) {
            //重复的节点
            if(cur.next != null && cur.val == cur.next.val) {
                //每一次都需要判断cur.next
                while (cur.next != null && cur.val == cur.next.val) {
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

    public boolean deleteDuplication1(){
        //为空
        if (head == null) {
            return false;
        }
        //一个数
        if (head.next == null) {
            return true;
        }
        //1、找到单链表的中间节点
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、反转单链表
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3、fast/slow往前    head往后走
        while (this.head != slow) {
            if (this.head.val != slow.val) {
                return false;
            }
            //偶数个数
            if (this.head.next == slow) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }

    void preOrderTraversal(TreeNode root){
        if(root == null) {
            return;
        }
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    void preOrderTraversal2(TreeNode root){
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(root);
                System.out.println(cur.value);
                cur = cur.left;
            }
           cur = stack.pop();
           cur = cur.right;
        }
    }
    public void inorderTraversal2(TreeNode root){
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(root);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.value);
            cur = cur.right;
        }
    }

    public void postorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                stack.pop();
                System.out.println(cur.value);
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }

    public void postorderTraversal2(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;  //记录打印过的节点
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                stack.pop();
                System.out.println(cur.value);
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                System.out.println(cur.value);;
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"hha");
        map.put(2,"heh");
        map.put(3,"xix");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void insertSort(int[] array) {
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            for (j = i-1; j < array.length; j++) {
                if (array[j] >tmp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }








    }
