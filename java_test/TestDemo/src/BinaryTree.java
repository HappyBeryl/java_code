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

    //构造树
    public TreeNode buildTree() {
        TreeNode root = new TreeNode('A');
        TreeNode B = new TreeNode('B');
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

    // 前序遍历
    void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    List<Character> preOrderTraversalNor(TreeNode root) {
        List<Character> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.value + " ");
                list.add(cur.value);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

    // 中序遍历
    void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    List<Character> inOrderTraversalNor(TreeNode root) {
        List<Character> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null && !stack.empty()) {
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

    // 后序遍历
    void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    //当前节点已经被打印
    //cur = null
//    List<Character> postOrderTraversalNor(TreeNode root) {
//
//    }

    //求节点个数
    public int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + getSize(root.right) +1;
    }

    //求叶子节点的个数
    public int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    //第k层节点的个数
    int getKLevelSize(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k-1) + getKLevelSize(root.right, k-1);
    }

    //找值为val的节点
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
        return null;
    }

    //4.是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.value != q.value) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //5.是否子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        if(isSameTree(s,t))  return true;
        if (isSameTree(s.left,t)) return true;
        if (isSameTree(s.right,t)) return true;
        return false;
    }

  //6.最大深度
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return leftHight > rightHight
                ? leftHight + 1 : rightHight + 1;
    }


    //7.平衡二叉树
    //1.以当前root为根节点，判断当前root是否为平衡的
    //如果是 判断左树右树是否是
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        return Math.abs(leftHight-rightHight) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    //8.镜像二叉树
    public boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree != null || leftTree != null && rightTree == null) {
            return true;
        }
        if (leftTree == null && rightTree == null) {
            return true;
        }
        return leftTree.value == rightTree.value &&
                isSymmetricChild(leftTree.left ,rightTree.right) &&
                isSymmetricChild(leftTree.right , rightTree.left );
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetricChild(root.left,root.right);
    }

    //9.层序遍历      《打印最右边》 二叉树的题都与几个遍历有关！！
    public void levelOrderTraversal (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.value + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

//   public List<List<Character>> levelOrderTraversal2(TreeNode root) {
//
//    }

    //----------------------------
    //10.判断完全二叉树(依赖于层序遍历)
    /*cur不为空放左右子节点到队列
    遇到null 说明所有元素都放入队列（如果是完全二叉树）
    队列里全为null --》是
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

    //11.二叉树的构建及遍历（依赖于前序遍历）
    /*
    不为null new节点，不为null i++
    思考总结：前序遍历的问题思考！！
     */
    public static int i = 0;
    public static TreeNode buildTree(String str) {
        TreeNode root = null;
        if(str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        }else {
            i++;
        }
        return root;
    }


    //12.最近公共祖先（依赖于前序遍历）
    /*
    三种情况，递归实现
    如果左边为空，右边不为空，右边的第一个节点就是最近公共祖先，反之
    左右两边都找到了，最近公共祖先是root
     */
    public TreeNode find (TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftTree = find(root.left, p, q);
        TreeNode rightTree = find(root.right, p, q);
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

    //13.二叉搜索树转换为排序双向链表
    /*
    根左<根 根右 >根 ==》二叉搜索树
    1）有序==》中序遍历
    2）left前驱，right后继
     */
    TreeNode prev = null;
    public void ConvertChild(TreeNode pCur) {
        if(pCur == null) {
            return;
        }
        ConvertChild(pCur.left);
        pCur.left = prev;
        if(prev != null) {
            prev.right = pCur;
        }
        prev = pCur;
        ConvertChild(pCur.right);
    }

    //返回的是双向链表的头结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        //这个函数，执行完成后，二叉搜索树的结构已经被改变了
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        //一路向左
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }


    //14.根据一棵树的前序遍历和中序遍历构建二叉树
    /*
    prevIndex只要一份！2--5 需要返回5 若为局部变量 返回2
    判断条件，是否有左树或者右树
    思路：以前序遍历的方式进行思考！
     */


    //15.根据一棵树的中序遍历和后序遍历构建二叉树
    /*

     */

    //16.二叉树创建字符串（前序遍历）
    /*
    左树：
       左为空，右为空 什么都不做
       左为空，右不为空  + ‘（）’
       左不为空，+‘（’遍历左树 + ‘）’

    右树：
        右为空 什么都不做
        右不为空 +‘（’遍历右树 + ‘）’
     */




}