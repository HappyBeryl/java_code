package tree.com;
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

    //前序遍历 A B D E H C F G
    void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历   //D B E H A C F G
    void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        preOrderTraversal(root.right);
    }

    //后序遍历   A B D E H C F G
    void postOrderTraversal(TreeNode root) {
        inOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

}
