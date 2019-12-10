package stack.com;

public class TestDemo {
    public static void main(String[] args) {
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
    }
}
