import java.util.Arrays;

public class Demo {
    public static void main1(String[] args) {
        int arr[] = new int[]{1,2,3};
        System.out.println(Arrays.toString(arr));
        int dst = 4;
        int arr1[] = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        arr1[3] = dst;
        arr = arr1;
        System.out.println(Arrays.toString(arr));
    }

    public static void main2(String[] args) {
        int arr[] = new int[]{9,8,7,6,5,4};
        System.out.println(Arrays.toString(arr));
        //要删除元素的下标
        int dst = 3;
        //创建一个新的数组
        int arr1[] = new int[arr.length-1];
        //复制原数组中除了要删除元素以外的所有元素
        for (int i = 0; i < arr1.length ; i++) {
            if(i<dst) {
                arr1[i] = arr[i];
            }else {
                arr1[i] = arr[i + 1];
            }
        }
        //新数组替换旧数组
        arr = arr1;
        System.out.println(Arrays.toString(arr));
    }

    public static void main3(String[] args) {
      int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
      int target = 9;
      int left = 0;
      int right = arr.length-1;
      while (true) {
          int mid = (left+right)/2;
          if(arr[mid] > target) {
              //在tmp左侧
              right = mid-1;
          } else if(arr[mid] < target) {
              //在tmp右侧
              left = mid+1;
          } else {
              System.out.println(mid);
              break;
          }
          if(left >= right) {
              System.out.println("无此元素");
              break;
          }
      }
    }


    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j] == target ) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main4(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int target = 3;
        int[] arr1 = twoSum(arr, target);
        System.out.println(Arrays.toString(arr1));
    }


}
