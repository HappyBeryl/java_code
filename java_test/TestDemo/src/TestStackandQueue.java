/*
顺序栈：数组实现栈
 */

class MyStack1 {
   int[] elem;
   int top;
   public MyStack1() {
       this.elem = new int[10];
       this.top = 0;
   }

   //入栈
    private boolean isFull() {
       return top == elem.length-1;
    }

    public void push(int num) {
       if (isFull()) {
           return;
       }
       elem[top] = num;
       top++;
    }

    //出栈

    public boolean isEmpty() {
       return top == 0;
    }
    public int pop() {
       if (isEmpty()) {
           return -1;
       }
       int tmp = elem[top-1];
       top--;
       return tmp;
    }

    //查看栈顶元素
    public int peek() {
       return elem[top-1];
    }
}

/*
 链式栈 用单链表实现栈
 */
class Node2 {
    int val;
    Node2 next;

    public Node2(int val) {
        this.val = val;
        this.next = next;
    }
}
class MyStack2 {
    Node2 head;

    //入栈 从头入
    public void pushStack(int num) {
        Node2 node = new Node2(num);
        node.next = this.head;
        this.head = node;
    }

    //出栈 从头出
    private boolean isEmpty() {
        return head == null;
    }

    public int popStack() {
        if (isEmpty()) {
            return -1;
        }
        int tmp = head.val;
        head = head.next;
        return tmp;
    }

    //查看栈顶元素
    public int peekStack() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }
}

/*
  链式队列：链表实现
 */

class MyListQueue1 {
    Node2 front;
    Node2 rear;
    int usedSize;

    //判断是否为空
    public boolean isEmpty() {
        return usedSize == 0;
    }

    // 入队(尾插)
    public void offer(int data) {
        Node2 node = new Node2(data);
        if (isEmpty()) {
           this.front = node;
           this.rear = node;
        } else {
           this.rear.next = node;
           rear = node;
        }
        this.usedSize++;
    }

    //出队（从头出）
    public int poll() {
        int tmp = this.front.val;
        this.front = this.front.next;
        this.usedSize--;
        return tmp;
    }

    //弹出队头元素
    public int peek() {
        return this.front.val;
    }
}

public class MyCircularQueue1 {
// 从rear入 从front出
    public int[] elem;
    public int front;
    public int rear;
    public int usedSize;

    public MyCircularQueue1(int k) {
        this.elem = new int[k];
        this.front = 0;
        this.rear = 0;
        this.usedSize = 0;
    }

    //进队列
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.elem[rear] = value;
        this.rear = (this.rear+1)%this.elem.length;
        this.usedSize++;
        return true;
    }

    //出队列
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front+1) % this.elem.length;
        this.usedSize--;
        return true;
    }

    //弹出队头元素
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return this.elem[this.front];

    }

    //弹出队尾元素
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = this.rear == 0 ? this.elem.length-1 : rear-1;
        return elem[index];
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return this.front == (this.rear+1)%this.elem.length;
    }

}



public class TestStackandQueue {
    public static void main(String[] args) {
        MyStack1 myStack = new MyStack1();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
    }
}
