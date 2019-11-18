public class TestDemo {
    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        doubleList.addLast(1);
        doubleList.addLast(2);
        doubleList.addLast(3);
        doubleList.addLast(1);
        doubleList.addLast(1);
        doubleList.removeAllKey(1);
        doubleList.disPlay();
    }
}
