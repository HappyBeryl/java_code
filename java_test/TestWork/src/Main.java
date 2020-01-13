import java.util.Arrays;

public class Main {
    /**
     * 大写转小写
     * A 65 Z 90
     * a 97 z 122
     */
    public String toLowerCase(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 65 && ch <= 90) {
                ch = (char) (ch + 32);
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public String toLowerCase1(String str) {
        return str.toLowerCase();
    }

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int cur = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int tmp = nums[j];
                nums[j] = cur;
                cur = tmp;
            }
        }
    }

    //全部翻转 -》 翻转前k个 -》翻转后n-k个
    public static int[] rotate2(int[] nums, int k) {
        k %= nums.length; //防止k非法
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return nums;
    }

    public static void reverse(int[] nums, int first, int last) {
        while (first <= last) {
            int tmp = nums[first];
            nums[first] = nums[last];
            nums[last] = tmp;
            first++;
            last--;
        }
    }

    //移除指定元素
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        int len = nums.length;
        while (i < len) {
            if (nums[i] != val) {
                nums[i] = nums[len - 1];
                len--;
            } else {
                i++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums));
        int[] array = rotate2(nums,3);
        System.out.println(Arrays.toString(array));

    }

}
