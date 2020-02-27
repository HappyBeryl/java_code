package com.com.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root = null;

    //插入
    public boolean insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return true;
        }
        Node parent = null;
        Node cur = null;
        while (cur != null) {
            if (cur.data == data) {
                return false;
            } else if (cur.data > data) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }

        if (data < parent.data) {
            parent.left = node;
        }
        if (data > parent.data) {
            parent.right = node;
        }
        return true;
    }

    //查找
    public Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if (key == cur.data) {
                return cur;
            } else if (key < cur.data) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    //删除
    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.data == key) {
                //找到了要删除的节点
                removeNode(parent,cur);
                return;
            }else if(cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    public void removeNode(Node parent,Node cur){
        //三种大情况
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        }

        if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            //替换法 右边找最小值
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }

            cur.data = target.data;
            //target的左一定是空的
            if (target == targetParent.left) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }

        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        System.out.println(list);
    }

}
