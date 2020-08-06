public class Calculator {
    public static void main(String[] args) {
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        String expression = "3+2*6-2";
        int index = 0;  //用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        while (true) {
            //依次得到每个字符
            ch = expression.substring(index, index+1).charAt(0);
            //判断ch是什么作相应的处理
            if (operStack.isOper(ch)) {
                //是运算符
                if (!operStack.isEmpty()) {
                    //处理
                    //判断优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        //运算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //把当前符号入符号栈
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    //为空
                    operStack.push(ch);
                }
            } else {
                //是数，直接入栈
                numStack.push(ch - 48); //扫描的是字符1
            }
            //index+1，判断是否扫描到index最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (true) {
            //如果符号栈为空，到达计算结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.printf("表达式%s = %d",expression, numStack.pop());
    }
}

//定义一个ArrayStack表示栈
class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈慢
    public boolean isFull() {
        return top == maxSize-1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈-push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，无法添加");
        }
        top++;
        stack[top] = value;
    }

    //出栈-pop
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈空，无法出栈");
        }
        int value = stack[top];
        top--;
        return value;  //value是出栈的数据
    }

    //可以返回当前栈顶的值，不是真正pop
    public int peek() {
        return stack[top];
    }

    //显示,遍历时需要从栈顶开始显示
    public void disPlay() {
        if (isEmpty()) {
            System.out.println("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    //返回运算符的优先级
    public int priority(int oper) {
        if (oper == '+' || oper == '-') {
            return 0;
        } else if (oper == '*' || oper == '/') {
            return 1;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(int oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+' :
                res = num1 + num2;
                break;
            case '-' :
                res = num2 - num1; //注意顺序
                break;
            case '*' :
                res = num1 * num2;
                break;
            case '/' :
                res = num2 / num1;
                break;
             default:
                    break;
        }
        return res;
    }

}

