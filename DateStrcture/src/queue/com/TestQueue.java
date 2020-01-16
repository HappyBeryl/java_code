package queue.com;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); //入队列  [抛出异常]
        queue.offer(1); //入队列 [返回特殊值]
        queue.remove(); //出队列 [抛出异常]
        queue.poll(); // 出队列 [返回特殊值]
        queue.element(); //队首元素 [抛出异常]
        queue.peek(); //队首元素 [返回特殊值]
    }
}
