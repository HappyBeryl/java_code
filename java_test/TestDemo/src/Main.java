public class Main {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
    }

    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        for (char s: S.toCharArray())
            for (char j: J.toCharArray())
                if (j == s) {
                    ans++;
                    break;
                }
        return ans;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return leftHight > rightHight
                ? leftHight + 1 : rightHight + 1;

    }
}


    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return Math.abs(leftHight-rightHight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return leftHight > rightHight
                ? leftHight + 1 : rightHight + 1;

    }



class Solution {
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree == null && rightTree!= null ||
                leftTree != null && rightTree == null) {
            return false;
        }
        if(leftTree == null && rightTree == null) {
            return true;
        }
        return leftTree.val == rightTree.val &&
                isSymmetricChild(leftTree.left,rightTree.right)
                &&isSymmetricChild(leftTree.right,rightTree.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }
}


}
