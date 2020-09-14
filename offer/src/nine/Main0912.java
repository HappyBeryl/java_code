package nine;

import java.util.Scanner;


class TreeNode {
    TreeNode left;
    TreeNode right;
    char val;

    public TreeNode(char val) {
        this.val = val;
    }
}
public class Main0912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        if (str.length() <= n) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flg = false;
            for (int j = 0; j < str.length()-1; j++) {
                char x = str.charAt(j);
                char y = str.charAt(j+1);
                //某一位大于他后面的一位进行移除
                if (x > y) {
                    str = str.substring(0,j)+str.substring(j+1, str.length());
                    flg = true;
                    break;
                }
            }
            if (!flg) {
                str = str.substring(0, str.length()-1);
            }
            for (int j = 0; j < str.length()-1; j++) {
                if (str.charAt(0) != '0') {
                    break;
                }
                str = str.substring(1, str.length());
            }
        }
        if (str.length() == 0) {
            System.out.println("0");
            return;
        }
        System.out.println(str);
    }




    static int postIndex = 0;
    public static void main1(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        char[] inorde = new char[strArr[0].length()];
        for (int i = 0; i < inorde.length; i++) {
            inorde[i] = strArr[0].charAt(i);
        }
        char[] postorder = new char[strArr[1].length()];
        for (int i = 0; i < postorder.length; i++) {
            postorder[i] = strArr[1].charAt(i);
        }
        TreeNode root = buildTree(inorde, postorder);
        prints(root);
    }

    private static void prints(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        prints(root.left);
        prints(root.right);
    }

    public static TreeNode buildTree(char[] inorde, char[] postorder) {
        if (postorder == null || inorde == null) {
            return null;
        }
        postIndex = postorder.length-1;
        return buildTreeChild(inorde, postorder, 0, inorde.length-1);
    }

    private static TreeNode buildTreeChild(char[] inorde, char[] postorder, int inbegin, int inend) {
        if (inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        int rootIndex = findIndexOfInorder(inorde, inbegin, inend, postorder[postIndex]);
        postIndex--;
        root.right = buildTreeChild(inorde, postorder, rootIndex+1,inend);
        root.left = buildTreeChild(inorde, postorder, inbegin, rootIndex-1);
        return root;
    }

    private static int findIndexOfInorder(char[] inorde, int inbegin, int inend, char c) {
        for (int i = inbegin; i <= inend; i++) {
            if (inorde[i] == c) {
                return i;
            }
        }
        return -1;
    }
}
