package com.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestStack {
   int[] elem = new int[10];
   int top;

   //入栈
   public void push(int val) {
       if (isEmpty()) {
           return;
       }
       elem[top] = val;
       top++;
   }

    private boolean isEmpty() {
       return top == elem.length;
    }

    //判断是否为空
    private boolean isFull() {
        return top == 0;
    }

    //出栈
    public int  pop() {
        if (isEmpty()) {
            return -1;
        }
        int tmp = elem[top-1];
        top--;
        return tmp;
    }

    //查看栈顶元素
    public int peek() {
        return elem[top-1];
    }


    //实现最小栈
    class MinStack {
       Stack<Integer> stack = new Stack<>();
       Stack<Integer> minStack = new Stack<>();

       MinStack() {

       }

       //入栈
        public void push(int val) {
           stack.push(val);
           if (minStack.empty()) {
               minStack.push(val);
           } else {
               if (minStack.peek() >= val) {
                   minStack.push(val);
               }
           }
        }

        //出栈
        public void pop() {
           int tmp = stack.pop();
           if (tmp == minStack.peek()) {
               stack.pop();
           }
        }
        int top() {
            return stack.peek();
        }

        int getMin() {
            return minStack.peek();
        }
    }

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push1(int x) {
        if(!queue1.isEmpty()) {
            queue1.offer(x);
        }else if(!queue2.isEmpty()){
            queue2.offer(x);
        }else {
            queue1.offer(x);
        }
    }

    public int pop1() {
        if(!queue1.isEmpty()) {
            int size1 = queue1.size()-1;
            for (int i = 0; i < size1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
        if(!queue2.isEmpty()){
            int size2 = queue2.size()-1;
            for (int i = 0; i < size2; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        return -1;
    }

    //二叉树
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    //先序遍历
    void prev(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        prev(root.left);
        prev(root.right);
    }

    void prev1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }
    //中序遍历
    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        prev(root.left);
        System.out.println(root.val);
        prev(root.right);
    }

    void inorder1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    //后序遍历
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        prev(root.left);
        prev(root.right);
        System.out.println(root.val);
    }

    void postOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
           if (cur.right == null || cur.right == prev) {
               stack.pop();
               System.out.println(cur.val);
               prev = cur;
               cur = null;
           } else {
               cur = cur.right;
           }
        }
    }

    //层序遍历
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    int getSize2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int size = getSize2(root.left) + getSize2(root.right) + 1;
        return size;
    }

    int getLeafSize2(TreeNode root){
        if(root == null) {
            return 0;
        }else if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    TreeNode find(TreeNode root, int val){
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode ret = find(root.left,val);
        if(ret != null) {
            return ret;
        }
        ret = find(root.right,val);
        if(ret != null) {
            return ret;
        }
        return null;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (isSameTree1(A,B)) return true;
        if (isSubStructure(A.left, B)) return true;
        if (isSubStructure(A.right, B)) return true;
        return false;
    }

    boolean isSameTree1(TreeNode A, TreeNode B) {
        if(B == null) return true; //B越过了A
        if(A == null || A.val != B.val) return false; //A越过了B
        return isSameTree1(A.left, B.left) && isSameTree(A.right, B.right);
    }


}
