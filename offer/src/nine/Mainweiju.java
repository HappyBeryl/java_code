package nine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Mainweiju {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = func(n);
        System.out.println(ret);
    }

    private static int func(int n) {
        if (n == 1 || n == 2) {
           return 1;
        } else {
            return func(n-1)+func(n-2);
        }
    }

    public static void main1(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        ArrayList<Integer> list = preorderTraversal(root);
        System.out.println(list);
    }
    public static ArrayList<Integer> preorderTraversal (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        ArrayList<Integer> list = new ArrayList<>();
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }
}
