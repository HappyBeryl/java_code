package test;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        if (leftNode != null) {
            return leftNode;
        }
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

    public int strToInt(String str) {
        char[] arr = str.trim().toCharArray();
        if(arr.length == 0) return 0;
        int sign = 1;
        int i = 1;
        int res = 0;
        int maxmin = Integer.MAX_VALUE/10;
        if (arr[0] == '-') sign = -1;
        else if (arr[0] != '+') i = 0;
        for (int j = i; j < arr.length; j++) {
            if (arr[j] < '0' || arr[j] > '9') break;
            if(res > maxmin || res == maxmin && arr[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (arr[j] - '0');
        }
        return sign*res;
    }

}
