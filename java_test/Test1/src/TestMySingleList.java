public class TestMySingleList {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(4);
        mySingleList.addLast(5);
        boolean bol = mySingleList.contains(100);
        System.out.println(bol);
        //mySingleList.remove(4);
       // mySingleList.removeAllKey(2);
//        ListNode newHead = mySingleList.reverse();
//        mySingleList.disPlay2(newHead);
        mySingleList.disPlay();
//        ListNode node = mySingleList.midNode();
//        System.out.println(node.data);
        System.out.println(mySingleList.findKthToTail1(2).data);

    }


}
