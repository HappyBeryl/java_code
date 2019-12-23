public class TestDemo {
    public static void main(String[] args) {
        TestHeap.show();
        TestHeap.pushHeap(100);
        TestHeap.show();
        TestHeap.popHeap();
        TestHeap.show();
        System.out.println(TestHeap.getHeapTop());
        System.out.println("================");
        TestHeap.heapSort();
        TestHeap.show();
    }
}
