package sort.com;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort2 {

    public static int partion(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while ((start < end) && array[end] >= tmp) {  //9 3 2 9 10
                end--;
            }
            if (start >= end) {
                break;
            } else {
                array[start] = array[end];
            }

            while ((start < end) && array[start] <= tmp) {  //9 3 2 9 10
                start++;
            }
            if (start >= end) {
                break;
            } else {
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }

    public static void quick(int[] array, int low, int high) {
      int pivot = partion(array, low, high);
      Stack<Integer> stack = new Stack<>();

      if (pivot > low+1) { //左边有两个元素可以入栈
          stack.push(low);
          stack.push(pivot-1);
      }
      if (pivot < high-1) { //右边有两个元素可以入栈
          stack.push(pivot+1);
          stack.push(high);
      }

      while (!stack.empty()) {
          high = stack.pop();
          low = stack.pop();
          pivot = partion(array, low, high);
          if (pivot > low+1) { //左边有两个元素可以入栈
              stack.push(low);
              stack.push(pivot-1);
          }
          if (pivot < high-1) { //右边有两个元素可以入栈
              stack.push(pivot+1);
              stack.push(high);
          }
      }

    }

    public static void quickSort(int[] array) {
        quick(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

}
