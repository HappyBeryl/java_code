package com.com.tree;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode left;
    TreeNode right;
    int val;
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


    //ABC##DE#G##F###  前序遍历
    public int i = 0;
    TreeNode buildTree(String str) {
        TreeNode root = null;
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        } else {
            i++;
        }
        return root;
    }

    //最近公共祖先
    public  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
        if (leftTree != null && rightTree != null) {
            return root;
        }

        if (leftTree != null) {
            return leftTree;
        }

        if (rightTree != null) {
            return rightTree;
        }
        return null;
    }

    //二叉搜索树转化为排序的双向链表
    TreeNode prev = null; //标记上一个节点
    public void Convertchild(TreeNode pCur) {
        if (pCur == null) {
            return;
        }
        Convertchild(pCur.left);
        //绑前驱
        pCur.left = prev;
        //绑后继 第一次不用 否则会造成空指针异常
        if (prev != null) {
            prev.right = pCur;
        }
        prev = pCur;
        Convertchild(pCur.right);
    }

    //返回的是双向链表的头节点
    public TreeNode Convert(TreeNode pRootOfTree) {
        //这个函数执行完，二叉搜索树的结构已经被改变
        Convertchild(pRootOfTree);
        TreeNode head = pRootOfTree;
        if (head == null) {
            return null;
        }
        //一路向左
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    //根据一棵树的前序遍历与中序遍历构造二叉树
    int preIndex= 0;
    public TreeNode buildTreeChild(  int[] preorder,int[] inorder,int inbegin, int inend) {

        //终止条件 判断是否有左树或者右树
        if (inbegin > inend) {
            return null;
        }

        //new 根节点
        TreeNode root = new TreeNode(preorder[preIndex]);

        //在中序遍历找到pi所在下标元素
        int rootIndex = findIndexOfInorder(inorder, inbegin, inend, preorder[preIndex]);
        preIndex++;
        root.left = buildTreeChild(preorder, inorder, inbegin,rootIndex-1);
        root.right = buildTreeChild(preorder, inorder, rootIndex+1,inend);
        return root;
    }

    private int findIndexOfInorder(int[] inorder, int inbegin, int inend, int val) {
        for (int i = inbegin; i <= inend; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeChild(preorder, inorder, 0, inorder.length-1);
    }

    //根据一棵树的后序遍历与中序遍历构造二叉树
    public int postIndex = 0;
    public TreeNode buildTreeChild1(int[] inorder, int[] postorder,int inbegin, int inend) {

        //终止条件 判断是否有左树或者右树
        if (inbegin > inend) {
            return null;
        }

        //new 根节点
        TreeNode root = new TreeNode(postorder[postIndex]);

        //在中序遍历找到pi所在下标元素
        int rootIndex = findIndexOfInorder(inorder, inbegin, inend, postorder[postIndex]);
        postIndex--;
        root.right = buildTreeChild1(inorder,postorder, rootIndex+1,inend);
        root.left = buildTreeChild1(inorder, postorder, inbegin,rootIndex-1);
        return root;
    }

    private int findIndexOfInorder1(int[] inorder, int inbegin, int inend, int val) {
        for (int i = inbegin; i <= inend; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null) {
            return null;
        }
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }

        postIndex = postorder.length-1;
        return buildTreeChild1(inorder, postorder, 0, inorder.length-1);
    }

    //二叉树创建字符串

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        tree2strChild(t, sb);
        return sb.toString();
    }

    public void tree2strChild(TreeNode t, StringBuilder str) {
        if (t == null) {
            return;
        }
        str.append(t.val);
        if (t.left == null) {
            if (t.right == null) {
                return;
            } else {
                str.append("()");
            }
        } else {
                str.append("(");
                tree2strChild(t.left, str);
                str.append(")");
        }
    //以上代码是递归前的位置 左执行完了
        if (t.right == null) {
            return;
        } else {
            str.append("(");
            tree2strChild(t.right, str);
            str.append(")");
        }
    }


}
