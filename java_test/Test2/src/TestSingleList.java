public class TestSingleList {
    //合并两个有序数组
    //合并
//    public static ListNode mergeTwoLists1(ListNode headA, ListNode headB){
//
//    }
//
//    //  创造一个环
//    public static void createCyle(ListNode headA, ListNode headB) {
//        headA.next = headB.next.next;
//    }
//
//    //    //相交
//    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//    }


    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addLast(1);
        singleList.addLast(2);
        singleList.addLast(3);
        singleList.addLast(4);
        ListNode newHead = singleList.reverseList();
        System.out.println();




    }
}
