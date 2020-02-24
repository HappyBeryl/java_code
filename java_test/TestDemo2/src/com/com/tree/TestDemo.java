package com.com.tree;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode root;
}
public class TestDemo {
    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }

        //判断队列中的元素是否全为空
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            if (cur != null) {
                return false;
            } else {
                queue.poll();
            }
        }
        return true;
    }
}
