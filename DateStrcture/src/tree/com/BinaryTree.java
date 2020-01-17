package tree.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    char value;
    TreeNode left;
    TreeNode right;
    public TreeNode(char value) {
        this.value = value;
    }
}

public class BinaryTree {

    public BinaryTree() {

    }
    //建造树
    public TreeNode buildTree() {
        TreeNode root = new TreeNode('A');
        TreeNode B= new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        root.left = B;
        root.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return root;
    }

    /**
     * 二叉树的前序遍历
     * 递归与非递归
     */
    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //非递归
    public List<Character> preorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
           while (cur != null) {
            stack.push(root);
            list.add(cur.value);
            cur = cur.left;
        }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

      /**
       * 二叉树的中序遍历
       * 递归与非递归
       */

    void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        preOrderTraversal(root.right);
    }

    //非递归中序遍历
     public List<Character> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        TreeNode  cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.value);
            cur = cur.right;
        }
        return list;
     }


    public List<Character> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.value);
            cur = cur.right;
        }
        return list;
    }


    //后序遍历   A B D E H C F G
    void postOrderTraversal(TreeNode root) {
        inOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    //非递归后序遍历

    //10.二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return leftHight > rightHight
                ? leftHight + 1 : rightHight + 1;
    }
    //11.判断一颗二叉树是否为平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return Math.abs(leftHight - rightHight) <=1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    //12.镜像（对称）二叉树
    public boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree) {
        if(leftTree == null && rightTree!= null || leftTree != null && rightTree == null) {
            return false;
        }
        if(leftTree == null && rightTree == null) {
            return true;
        }
        return leftTree.value == rightTree.value &&
                isSymmetricChild(leftTree.left,rightTree.right)
                &&isSymmetricChild(leftTree.right,rightTree.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetricChild(root.left , root.right);
    }


}
