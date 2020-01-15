import java.util.ArrayList;
import java.util.List;

class TreeNode2 {
    int val;
    TreeNode root;
}

public class TestTree {

    void preOrderTraversal(TreeNode root){
        if(root == null) {
            return;
        }
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        list.add(root.val);
        List<Integer> list1 = preorderTraversal(root.left);
        list.addAll(list1);
        List<Integer> list2 = preorderTraversal(root.right);
        list.addAll(list2);
        return list;
    }



} public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q != null || p != null && q == null) {
        return false;
    }
    if (p == null && q == null) {
        return true;
    }
    if (p.value != q.value) {
        return false;
    }
    return isSameTree(p.left,q.left) && isSameTree(p.right,q.right); \
 }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        if(isSameTree(s,t))  return true;
        if (isSameTree(s.left,t)) return true;
        if (isSameTree(s.right,t)) return true;
        return false;
    }


}
