import java.util.PriorityQueue;
import java.util.Queue;

public class TestHeapDemo {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = new int[]{12,33,5,7,1,14};
        testHeap.creatHeap(array);
        testHeap.show();
        System.out.println();
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll()); //1
        System.out.println(queue.peek()); //2
    }
}
