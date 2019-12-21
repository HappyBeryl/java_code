public class TestHeapDemo {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = new int[]{12,33,5,7,1,14};
        testHeap.creatHeap(array);
        testHeap.show();
    }
}
