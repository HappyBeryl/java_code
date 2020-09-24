package nine;

public class Mainbanyu {

    //平衡括号字符串的最小插入次数
    public int minInsertions (String s) {
        // write code here
        int l = 0;
        int index = 0;
        int ret = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                l++;
                index++;
            } else {
                if (l > 0) {
                    l--;
                } else {
                    ret++;
                }
                if (index == s.length()-1 || s.charAt(index+1) != ')') {
                    ret++;
                    index++;
                } else {
                    index = index+2;
                }
            }
        }
        return ret;
    }

    //行走机器人
    public int movingCount (int m, int n, int k) {
        // write code here
        boolean[][] arr = new boolean[m][n];
        return movingCountChild(0,0,m,n,k,arr);
    }

    private int movingCountChild(int i, int j, int m, int n, int k, boolean[][] arr) {
        if (i <0 || j < 0 || i >=m|| j>=n||func(i)+func(j) > k || arr[i][j] == true) {
            return 0;
        }
        arr[i][j] = true;
        return 1+movingCountChild(i+1, j, m,n, k, arr)+
                movingCountChild(i-1, j, m,n, k, arr)+
                movingCountChild(i, j+1, m,n, k, arr)+
                movingCountChild(i, j-1, m,n, k, arr);
    }

    private int func(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    //负二进数转换
    public String baseNeg2 (int N) {
        // write code here
        if (N == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        while (N != 0) {
            int tmp = N % -2;
            sb.append(tmp == -1 ? 1: tmp);
            N /= -2;
            if (tmp == -1) {
                N++;
            }
        }
        return sb.reverse().toString();
    }
}
