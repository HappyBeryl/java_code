package queue.com;

public class MyListQueue {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    Node front;
    Node rear;
    int usedSize;

    //判断是否为空
    public boolean isEmpty() {
        return usedSize == 0;
    }

    // 入队(尾插)
    public void offer(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
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
