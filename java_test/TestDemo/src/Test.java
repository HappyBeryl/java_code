public class Test {
    //斐波那契数列 011234
    public int fib(int N) {
        if(N <= 1) {
            return N;
        }
        if(N == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for(int i = 3; i <= N; i++) { //比如5个数就执行3次
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
