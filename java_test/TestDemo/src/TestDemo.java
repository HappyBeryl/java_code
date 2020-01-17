import java.util.List;
class TreeNode4 {
    int val;
    TreeNode left;
    TreeNode right;
}

public class TestDemo {
    public static void main(String[] args) {

        void preOrderTraversal(TreeNode4 root){
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


    }
}
