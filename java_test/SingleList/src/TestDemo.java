public class TestDemo {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst(7);
        singleList.addFirst(4);
        singleList.addFirst(3);
        singleList.addFirst(2);
        singleList.addFirst(3);
        singleList.addIndex(1,111);
        boolean bol = singleList.contains(2);
        System.out.println(bol);
        //singleList.removeAllKey(3);
//        singleList.disPlay();
//        ListNode node = singleList.reverseList();
//        singleList.disPlay2(node);
        singleList.disPlay();
        ListNode node1 = singleList.findKthToTail(6);
        if (node1 != null)
            System.out.println(node1.data);

    }
}
