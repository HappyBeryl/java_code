package tree.com;

import java.util.*;

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


    /**
     * 二叉树的后序遍历
     * 递归与非递归
     */

    //左右根  A B D E H C F G
    void postOrderTraversal(TreeNode root) {
        inOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    //非递归后序遍历
    public List<Character> postorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
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
                list.add(cur.value);
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return list;
    }

    /**
     * 二叉树的层序遍历
     */
    public List<List<Character>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Character>> ret = new ArrayList<>();
        if(root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Character> list = new ArrayList<>();
            while(size > 0) {
                TreeNode cur = queue.poll();
                list.add(cur.value);
                size--;
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ret.add(list);
        }
        return ret;
    }

    /**
     * 求节点个数
     * 子问题思路和遍历思路
     */

    int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + getSize(root.right) + 1;
    }


    static int size = 0;
    void getSize1(TreeNode root){
        if(root == null) {
            return ;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    /**
     * 求叶子节点个数
     * 子问题思路和遍历思路
     */
    int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    static int leafSize = 0;
    void getLeafSize1(TreeNode root){
        if(root == null) {
            return ;
        }else if(root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    /**
     * 求第k层节点个数
     * @param root
     * @return
     */

    int getKLevelSize(TreeNode root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k-1) + getKLevelSize(root.right, k-1);
    }

    /**
     * 查找val所在节点
     * @param root
     * @return
     */

    TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.value == val) {
            return root;
        }

        TreeNode ret = find(root.left, val);
        if (ret != null) {
            return ret;
        }
        ret = find(root.right, val);
        if (ret != null) {
            return ret;
        }
        return null; //没找到
    }


    /**
     * 检查两棵树是否相同
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p != null && q == null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        if(p.value != q.value) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 二叉树的最大深度
     * @param root
     * @return
     */

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lenLeft = maxDepth(root.left);
        int lenRight = maxDepth(root.right);
        return lenLeft > lenRight ? lenLeft+1 : lenRight+1;
    }

    /**
     *判断一颗二叉树是否为平衡二叉树
     * @param root
     * @return
     */

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return Math.abs(leftHight - rightHight) <=1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     *   镜像（对称）二叉树
     */
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

    /**
     * 判断一棵树是不是完全二叉树
     */
    boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }

        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            if(cur != null) {
                return false;
            }else {
                queue.poll();
            }
        }
        return true;
    }

    



}
