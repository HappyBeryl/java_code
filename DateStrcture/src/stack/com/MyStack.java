package stack.com;

public class MyStack<T> {
    public T elem[];
    int top; //top是当前能放元素位置的下标

    public MyStack() {
        this.elem = (T[]) new Object[10];
        this.top = 0;
    }

    //判断是否未满
    private boolean isEmpty() {
        return top == elem.length;
    }

    //入栈
    public void push(T val) {
        if (isEmpty()) {
            return;
        }
        elem[top] = val;
        top++;
    }

    //判断是否为空
    private boolean isFull() {
        return top == 0;
    }

    //出栈
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T tmp = elem[top-1];
        top--;
        return tmp;
    }

    //查看栈顶元素
    public T peek() {
        return elem[top-1];
    }

}
