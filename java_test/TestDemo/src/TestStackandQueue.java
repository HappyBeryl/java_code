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

public class TestStackandQueue {
    public static void main(String[] args) {
        MyStack1 myStack = new MyStack1();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
    }
}
