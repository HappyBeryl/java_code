import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 */

public class MyStack {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    //哪个栈不为空入哪个栈
    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else if (!queue2.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!queue1.isEmpty()) {
            int size1 = queue1.size()-1; //由于每次queue1.poll()导致size发生变化，因此要事先保存
            for (int i = 0; i < size1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
        if (!queue2.isEmpty()) {
            int size2 =  queue2.size()-1;
            for (int i = 0; i < size2; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        if (!queue1.isEmpty()) {
            int size1 = queue1.size(); //由于每次queue1.poll()导致size发生变化，因此要事先保存
            int tmp = 0;  //查看栈顶元素，但是要把元素全部弹入另外一个栈，因为入栈的是非空栈
            for (int i = 0; i < size1; i++) {
                tmp = queue1.poll();
                queue2.offer(queue1.poll());
            }
            return tmp;
        }
        if (!queue2.isEmpty()) {
            int size2 =  queue2.size();
            int tmp = 0;
            for (int i = 0; i < size2; i++) {
                tmp = queue2.poll();
                queue1.offer(queue2.poll());
            }
            return tmp;
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}
