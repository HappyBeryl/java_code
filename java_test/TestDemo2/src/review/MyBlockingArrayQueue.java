package review;

public class MyBlockingArrayQueue {
    int[] array = new int[1];
    int front; //消费者修改 头
    int rear; //生产者修改 尾
    int size = 0;

    synchronized void put(int x) throws InterruptedException {
        while (size == array.length) {
            wait();
        }
        array[rear] = x;
        rear = (rear+1)%array.length;
        size++;
        notifyAll();
    }

    synchronized int take() throws InterruptedException {
        while (size == 0) {
            wait();
        }

        int ret = array[front];
        front = (front+1)%array.length;
        size--;
        notifyAll();
        return ret;
    }

}
