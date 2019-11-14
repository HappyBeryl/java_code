public class TestMySingleList {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(2);
        mySingleList.addLast(1);
        boolean bol = mySingleList.chkPalindrome();
        System.out.println(bol);
    }

}
