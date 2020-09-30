package nine;

import java.util.Scanner;

public class Mainyonghang {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(1);
        ListNode C = new ListNode(2);
        ListNode D = new ListNode(3);
        ListNode E = new ListNode(3);
        ListNode F = new ListNode(4);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        ListNode ret = deleteDuplicates(A);
        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }
        /*
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sum = 0;
        StringBuffer sb = new StringBuffer();
        char ch = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                sum++;
            } else {
                sb.append(ch+"_"+sum+"_");
                sum = 1;
                ch = str.charAt(i);
            }
        }
        sb.append(ch+"_"+sum);*/
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode ret = new ListNode(-1);
        ListNode tmpNode = ret;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
            } else {
                tmpNode.next = cur;
                tmpNode = tmpNode.next;
                cur = cur.next;
            }
        }
        return ret.next;
    }
}
