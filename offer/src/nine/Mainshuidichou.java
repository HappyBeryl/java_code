package nine;
class ListNode {
    ListNode next;
    int val;
}
public class Mainshuidichou {
    static int maxsumofSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        if (count == n) {
            return head.next;
        }
        cur = head;
        for (int i = 0; i < count-n-1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

//    static ListNode removeNthFromEnd(ListNode head, int n) {
//        if (n < 1 || head == null) {
//            return head;
//        }
//        ListNode node = head;
//        while (node != null) {
//            n--;
//            node = node.next;
//        }
//        if (n == 0) {
//            head = head.next;
//        }
//        if (n < 0) {
//            node = head;
//            while (++n != 0) {
//                node = node.next;
//            }
//            node.next = node.next.next;
//        }
//
//    }
}
