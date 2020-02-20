package tree.com;

public class SearchBinrayTree {

    class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node root = null;

    /*
    插入
     */
    public boolean insert(int key) {
        Node node = new Node(key);
        Node cur = root;
        Node parent = null;
        if (root == null) {
            root = node;
            return true;
        }

        while (cur != null) {
            if (cur.data > key) {
                parent = cur;
                cur = cur.left;
            } else if (cur.data < key) {
                parent = cur;
                cur = cur.right;
            } else {
                return false;
            }
        }

        //开始插入
        if(key < parent.data) {
            parent.left = node;
        }else {
            parent.right = node;
        }
        return true;
    }

    /*
    查找
     */
    public Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if(cur.data == key) {
                return cur;
            }else if(cur.data < key) {
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }

    /*
    显示 中序+前序
     */
    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    public void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /*
    删除节点
     */
    //删除关键字为key的节点
    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.data == key) {
                //找到了要删除的节点
                removeNode(parent,cur);
                return;
            }else if(cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    private void removeNode(Node parent, Node cur) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }

        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.right) {
                parent.right = cur.left;
            }else {
                parent.left = cur.left;
            }

        }else {
            Node targetParent = cur;//要删除的节点的父亲节点-》替罪羊的父亲
            //在右边找最小值
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }

            cur.data = target.data;
            //target的左肯定是空的
            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }


}
