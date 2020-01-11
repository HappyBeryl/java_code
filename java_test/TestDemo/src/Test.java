import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class ListNode {
    int data;
    ListNode next;
}

class TreeNode1 {
    TreeNode left = null;
    TreeNode right = null;
}

public class Test {
    //斐波那契数列 011234
    public int fib(int N) {
        if(N <= 1) {
            return N;
        }
        if(N == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for(int i = 3; i <= N; i++) { //比如5个数就执行3次
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    //三数之和
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    ListNode head = null;
    //单链表删除指定元素
    public void removeAllKey(int key) {
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while (cur != null) {
            if (cur.next.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        //处理第一个节点--最后处理
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    public boolean isBalance (TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return Math.abs(leftHight-rightHight) <= 1 && isBalance(root.left)
                && isBalance(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        return leftHight > rightHight ? leftHight+1 : rightHight+1;
    }

    //12个鸡蛋，一次可以吃2-12个，多少种吃法
//    public static int eatEgg() {
//        int i = 0; //一次可以吃的个数
//        int count = 0; //多少种吃法
//
//    }

    //链表翻转
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = null;
        while(cur != null) {
            if(cur.next == null) {
                newHead = cur;
            }
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    //逆置字符串
    public static String reverse(String string) {
        char[] array = string.toCharArray();
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return String.copyValueOf(array);
    }

    public static void main(String[] args) {
        String str = "abcdef";
        String ret = reverse(str);
        System.out.println(ret);

        StringBuilder sb = new StringBuilder();
        System.out.println(str.length());
    }

    //大写转小写
    //A 65 Z 90
    //a 97 z 122
    //法1：
    public String toLowerCase(String str) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 65 && ch <= 90) {
                ch = (char)(ch + 32);
            }
            sb.append(ch);
        }
        return sb.toString();
    }
    //法2：
    public String toLowerCase1(String str) {
        return str.toLowerCase();
    }

    //删除第一个字符串当中出现第二个字符串的字符
    public static List<Character> func(String str1,String str2) {
        List<Character> ret = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")){
                ret.add(ch);
            }
        }
        return ret;
    }

    //杨辉三角
    //numRows：你的行数
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());//0
        triangle.get(0).add(1);
        //行数
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            //上一行
            List<Integer> prevRow = triangle.get(i-1);
            //第i行的第j列
            for (int j = 1; j < i; j++) {
                int tmp = prevRow.get(j-1)+prevRow.get(j);
                curRow.add(tmp);
            }
            curRow.add(1);
            triangle.add(curRow);
        }
        return triangle;
    }

    //括号匹配问题
    public  static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{'|| ch == '[') {
                stack.push(ch);
            }else {
                if(stack.empty()) {
                    System.out.println("右括号多");
                    return false;
                }
                char top = stack.peek();
                if(top == '(' && ch == ')' ||
                        top == '{' && ch == '}'||
                        top == '[' && ch == ']' ){
                    stack.pop();
                }else {
                    System.out.println("右括号匹配错误！");
                    return false;
                }
            }
        }

        if(!stack.empty()) {
            System.out.println("左括号多！");
            return false;
        }
        return true;
    }






}
