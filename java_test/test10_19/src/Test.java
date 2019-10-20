public class Test {
    public static void narNum(int n) {
        for (int i = 0; i <= n; i++) {
            int count = 0; //位数
            int tmp = i;
            while (tmp != 0) {
                count++;
                tmp /= 10;
            }
            tmp = i;
            int sum = 0;
            while (tmp != 0) {
                sum += Math.pow(tmp%10, count);
                tmp /= 10;
            }
            if(sum == i) {
                System.out.println(i);
            }

        }
    }

    public static void main(String[] args) {
        narNum(999999);
    }
}
