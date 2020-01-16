package stack.com;

import java.util.Stack;

public class TestDemo {
    public static void main(String[] args) {
        MyListStack myListStack = new MyListStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(1); //压栈
        stack.pop(); //出栈
        stack.peek(); // 查看栈顶元素
        System.out.println(stack.empty()); //判断栈是否为空
        myListStack.push(1);
        myListStack.push(2);
        myListStack.push(3);
        System.out.println(myListStack.pop());
        System.out.println(myListStack.peek());
    }
    public static void main1(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        System.out.println(myStack.pop());//40
        System.out.println(myStack.peek());//30

        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("Java");
        myStack2.push("HELLO");
        myStack2.push("2019");
        myStack2.push("hhhh");
        System.out.println(myStack2.pop());//40
        System.out.println(myStack2.peek());//30

        //1.实现一个最小栈

    }
}
