import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    //三数之和
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }


}
