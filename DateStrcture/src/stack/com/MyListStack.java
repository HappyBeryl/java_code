package stack.com;

public class MyListStack {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    Node head;

    //入栈
    public void push(int val) {
        Node node = new Node(val);
        node.next = this.head;
        this.head = node;
    }

    //判断是否为空
    private boolean isEmpty() {
        return head == null;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int tmp = head.data;
        head = head.next;
        return tmp;
    }

    //查看栈顶元素
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }


}
