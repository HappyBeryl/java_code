package com.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestStack {
   int[] elem = new int[10];
   int top;

   //入栈
   public void push(int val) {
       if (isEmpty()) {
           return;
       }
       elem[top] = val;
       top++;
   }

    private boolean isEmpty() {
       return top == elem.length;
    }

    //判断是否为空
    private boolean isFull() {
        return top == 0;
    }

    //出栈
    public int  pop() {
        if (isEmpty()) {
            return -1;
        }
        int tmp = elem[top-1];
        top--;
        return tmp;
    }

    //查看栈顶元素
    public int peek() {
        return elem[top-1];
    }


    //实现最小栈
    class MinStack {
       Stack<Integer> stack = new Stack<>();
       Stack<Integer> minStack = new Stack<>();

       MinStack() {

       }

       //入栈
        public void push(int val) {
           stack.push(val);
           if (minStack.empty()) {
               minStack.push(val);
           } else {
               if (minStack.peek() >= val) {
                   minStack.push(val);
               }
           }
        }

        //出栈
        public void pop() {
           int tmp = stack.pop();
           if (tmp == minStack.peek()) {
               stack.pop();
           }
        }
        int top() {
            return stack.peek();
        }

        int getMin() {
            return minStack.peek();
        }
    }

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push1(int x) {
        if(!queue1.isEmpty()) {
            queue1.offer(x);
        }else if(!queue2.isEmpty()){
            queue2.offer(x);
        }else {
            queue1.offer(x);
        }
    }

    public int pop1() {
        if(!queue1.isEmpty()) {
            int size1 = queue1.size()-1;
            for (int i = 0; i < size1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
        if(!queue2.isEmpty()){
            int size2 = queue2.size()-1;
            for (int i = 0; i < size2; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        return -1;
    }

    //二叉树
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(char c) {

        }

        public TreeNode(int i) {
        }
    }

    //先序遍历
    void prev(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        prev(root.left);
        prev(root.right);
    }

    void prev1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }
    //中序遍历
    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        prev(root.left);
        System.out.println(root.val);
        prev(root.right);
    }

    void inorder1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    //后序遍历
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        prev(root.left);
        prev(root.right);
        System.out.println(root.val);
    }

    void postOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
           if (cur.right == null || cur.right == prev) {
               stack.pop();
               System.out.println(cur.val);
               prev = cur;
               cur = null;
           } else {
               cur = cur.right;
           }
        }
    }

    //层序遍历
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    int getSize2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int size = getSize2(root.left) + getSize2(root.right) + 1;
        return size;
    }

    int getLeafSize2(TreeNode root){
        if(root == null) {
            return 0;
        }else if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    TreeNode find(TreeNode root, int val){
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode ret = find(root.left,val);
        if(ret != null) {
            return ret;
        }
        ret = find(root.right,val);
        if(ret != null) {
            return ret;
        }
        return null;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (isSameTree1(A,B)) return true;
        if (isSubStructure(A.left, B)) return true;
        if (isSubStructure(A.right, B)) return true;
        return false;
    }

    boolean isSameTree1(TreeNode A, TreeNode B) {
        if(B == null) return true; //B越过了A
        if(A == null || A.val != B.val) return false; //A越过了B
        return isSameTree1(A.left, B.left) && isSameTree(A.right, B.right);
    }

    public int maxDepth(TreeNode root){
        if(root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return leftHight > rightHight
                ? leftHight + 1 : rightHight + 1;
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

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }

    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if (leftTree == null && rightTree != null ||
                leftTree != null && rightTree != null) {
            return false;
        }
        if (leftTree == null && rightTree == null) {
            return true;
        }
        return leftTree.val == rightTree.val &&
                isSymmetricChild(leftTree.left,rightTree.right)
                &&isSymmetricChild(leftTree.right,rightTree.left);
    }
    //判断一颗树是否为完全二叉树：依赖队列
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }

        //判断队列中的元素是否全为空
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            if (cur != null) {
                return false;
            } else {
                queue.poll();
            }
        }
        return true;
    }

    static int i = 0;
    TreeNode buildTree(String str){
        TreeNode root = null;
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        } else {
            i++;
        }
        return root;
    }

    public  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        //leftTree和rightTree接收的就是返回的root
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
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

    TreeNode prev = null;
    public void ConvertChild(TreeNode pCur) {
        if (pCur == null) {
            return;
        }
        ConvertChild(pCur.left);
        pCur.left = prev;
        if (pCur != null) {
            prev.right = pCur;
        }
        prev = pCur;
        ConvertChild(pCur.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree){
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    //根据一棵树的前序遍历与中序遍历构造二叉树
    int preIndex= 0;
    public TreeNode buildTreeChild(int[] preorder,int[] inorder,int inbegin, int inend) {

        //终止条件 判断是否有左树或者右树
        if (inbegin > inend) {
            return null;
        }

        //new 根节点
        TreeNode root = new TreeNode(preorder[preIndex]);

        //在中序遍历找到pi所在下标元素
        int rootIndex = findIndexOfInorder(inorder, inbegin, inend, preorder[preIndex]);
        preIndex++;
        root.left = buildTreeChild(preorder, inorder, inbegin,rootIndex-1);
        root.right = buildTreeChild(preorder, inorder, rootIndex+1,inend);
        return root;
    }

    private int findIndexOfInorder(int[] inorder, int inbegin, int inend, int val) {
        for (int i = inbegin; i <= inend; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeChild(preorder, inorder, 0, inorder.length-1);
    }

    //堆排序
    public static void heapSort(int[] array){
        createHeap(array);
        int end = array.length-1;
        while (end > 0 ) {
            int tmp = array[end];
            array[end] = array[0];
            array[0] = tmp;
            adjustDown(array, 0, end);
            end--;
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
    }

    private static void adjustDown(int[] array, int root, int len) {
        int child = 2 * root + 1;
        while (child < len) {
            if ((child+1 < len) && array[child] < array[child+1]) {
                child++;
            }
            if (array[child] > array[root]) {
                int tmp = array[child];
                array[child] = array[root];
                array[root] = tmp;
            }
            root = child;
            child = 2 * root + 1;
        }
    }

    public static void insertSort(int[] array) {
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            for (j = i-1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = 0;
            for (j = i-gap; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j+gap] = array[j];
                } else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        //分的组数
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array, drr[i]);
        }
    }

    public static void quickSort(int[] array) {
        quick1(array, 0, array.length-1);
    }

    private static void quick(int[] array, int l, int h) {
        if (l >= h) {
            return;
        }
        int pivot = partion(array, l, h);
        quick(array, l, pivot-1);
        quick(array, pivot+1, h);
    }

    private static int partion(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while ((start <end) && array[end] >= tmp) {
                end--;
            }
            if (start >= end) {
                break;
            } else {
                array[start] = array[end];
            }

            while ((start <end) && array[start] <= tmp) {
                start++;
            }
            if (start >= end) {
                break;
            } else {
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }

    public static void quick1(int[] array, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        int pivot = partion(array, low, high);
        if (pivot > low+1) {
            stack.push(low);
            stack.push(pivot-1);
        }
        if (pivot < high-1) {
            stack.push(pivot+1);
            stack.push(high);
        }

        while (!stack.empty()) {
            high = stack.pop();
            low = stack.pop();

            pivot = partion(array, low, high);
            if (pivot > low+1) { //左边有两个元素可以入栈
                stack.push(low);
                stack.push(pivot-1);
            }
            if (pivot < high-1) { //右边有两个元素可以入栈
                stack.push(pivot+1);
                stack.push(high);
            }
        }
    }

    public static void mergeSort(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }

    public static void mergeSortInternal(int[] array,int low,int high) {
        if (low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array,mid+1,high);
        merge(array,low,mid,high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid+1;
        int[] tmpArr = new int[high-low+1];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if (array[s1] < array[s2]) {
                tmpArr[i++] = array[s1++];
            } else {
                tmpArr[i++] = array[s2++];
            }
        }
        //S1还有数据的情况下
        while (s1 <= mid) {
            tmpArr[i++] = array[s1++];
        }
        //s2还有数据的情况下
        while (s2 <= high) {
            tmpArr[i++] = array[s2++];
        }

        for (int j = 0; j < tmpArr.length; j++) {
            array[j+low] = tmpArr[j];
        }
    }

    public static void mergeSort1(int[] array) {
        for (int i = 0; i < array.length; i*=2) {
            merge1(array, i);
        }
    }

    private static void merge1(int[] array, int gap) {
        int[] tmpArr = new int[array.length];
        int k = 0;
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < array.length ? s2+gap-1 : array.length-1;
        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] <= array[s2]) {
                    tmpArr[k++] = array[s1++];
                } else {
                    tmpArr[k++] = array[s2++];
                }
            }
            while (s1 <= e1) {
                tmpArr[k++] = array[s1++];
            }
            while (s2 <= e2) {
                tmpArr[k++] = array[s2++];
            }
             s1 = e2+1;
             e1 = s1+gap-1;
             s2 = e1+1;
             e2 = s2+gap-1 < array.length ? s2+gap-1 : array.length-1;
        }
        while (s1 <= array.length-1) {
            tmpArr[k++] = array[s1++];
        }

        for (int i = 0; i < tmpArr.length; i++) {
            array[i] = tmpArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,4,6,3,7,2,9,8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }







}
