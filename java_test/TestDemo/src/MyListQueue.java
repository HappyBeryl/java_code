public class MyListQueue {
    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    public Node front;
    public Node rear;
    public int usedSize;

    private boolean isEmpty() {
        return this.usedSize == 0;
    }
    //入队
    public void offer(int data) {
        Node node = new Node(data);
        if(isEmpty()) {
            this.front = node;
            this.rear = node;
        } else {
            this.rear.next = node;
            this.rear = node;
        }
        this.usedSize++;
    }

    //出队（从头出）
    public int poll() {
        int tmp = this.front.data;
        this.front = this.front.next;
        this.usedSize--;
        return tmp;
    }

    //弹出队头元素
    public int peek() {
        return this.front.data;
    }
}



