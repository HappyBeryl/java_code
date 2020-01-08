public class Main {
    /**
     * 大写转小写
     * A 65 Z 90
     * a 97 z 122
     */
    public String toLowerCase(String str) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 65 && ch <= 90) {
                ch = (char)(ch + 32);
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
     *
     * 示例 1:
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     */
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length-1];
            for(int j = 0; j < nums.length; j++) {
                int tmp = nums[j];
                nums[j] = last;
                last = tmp;
            }
        }
    }

}
