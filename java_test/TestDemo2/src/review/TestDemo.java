package review;

import java.util.*;

public class TestDemo {

     class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
     }
     ListNode head = null;

     public void removeAllKey(int key) {
         ListNode prev = head;
         ListNode cur = head.next;
         while (cur != null) {
             if (cur.val == key) {
                 prev.next = cur.next;
                 cur = cur.next;
             } else {
                 prev = cur;
                 cur = cur.next;
             }
         }
         if (head.val == key) {
             head = head.next;
         }
     }

    public ListNode reverse() {
         if (head == null) {
             return null;
         }
         ListNode prev = null;
         ListNode newHead = null;
         ListNode cur = head;
         while (cur!= null) {
             ListNode curNext = cur.next;
             if (curNext == null) {
                 newHead = cur;
             }
             cur.next = prev;
             prev = cur;
             cur = curNext;
         }
         return newHead;
    }

    public ListNode findKthToTail(int k) {
         if (k < 0 || head == null) {
             return null;
         }
         ListNode fast = head;
         ListNode slow = head;
        for (int i = 0; i < k-1; i++) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean hw() {
         if(head == null) {
             return false;
         }
         if (head.next == null) {
             return true;
         }
         ListNode fast = head;
         ListNode slow = head;
         while (fast != null && fast.next != null) {
             fast = fast.next.next;
             slow = slow.next;
         }
         ListNode cur = slow.next;
         while (cur != null) {
             ListNode curNext = cur.next;
             cur.next = slow;
             slow = cur;
             cur = curNext;
         }
         while (head != slow) {
             if (head.val != slow.val) {
                 return false;
             }
             if (head.next == slow) {
                 return true;
             }
             head = head.next;
             slow = slow.next;
         }
         return true;
    }

    public ListNode copy(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);
    }

    //最小栈
    class MinStack {
         public Stack<Integer> stack = new Stack<>();
         public Stack<Integer> minStack = new Stack<>();
         MinStack(){}

         void push(int x) {
             stack.push(x);
             if (minStack.empty()) {
                 minStack.push(x);
             } else {
                 if (x <= stack.peek()) {
                     minStack.push(x);
                 }
             }
         }

         void pop() {
             int tmp = stack.pop();
             if (tmp == minStack.peek()) {
                 minStack.pop();
             }
         }

         int top() {
             return stack.peek();
         }
         int getMin() {
             return minStack.peek();
         }
     }

     //队列-》栈
    class MyStack {
         Queue<Integer> queue1 = new LinkedList<>();
         Queue<Integer> queue2 = new LinkedList<>();

         void push(int x) {
             if (!queue1.isEmpty()) {
                 queue1.offer(x);
             } else if (!queue2.isEmpty()) {
                 queue2.offer(x);
             } else {
                 queue1.offer(x);
             }
         }
         int pop() {
             int size = queue1.size()-1;
             for (int i = 0; i < size; i++) {
                 queue2.offer(queue1.poll());
             }
             return queue1.poll();
         }
     }

    public static void main1(String[] args) {
        int[] array = new int[]{1,4,3,5,8,7,6,9,0,2};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    //归并
    public static void mergeSort(int[] array) {
        mergeSortInternal2(array,0,array.length-1);
    }

    private static void mergeSortInternal2(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSortInternal2(array, low, mid);
        mergeSortInternal2(array, mid+1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid+1;
        int i = 0;
        int[] tmpArr = new int[high-low+1];
        while (s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {
                tmpArr[i++] = array[s1++];
            }else {
                tmpArr[i++] = array[s2++];
            }
        }
        //S1还有数据的情况下
        while (s1 <= mid) {
            tmpArr[i++] = array[s1++];
        }
        //s2还有数据的情况下
        while (s2 <= high) {
            tmpArr[i++] = array[s2++];
        }
        for (int j = 0; j < tmpArr.length; j++) {
            array[j+low] = tmpArr[j];
        }
    }


    //6 希尔
    public static void shellSort(int[] array) {
       int[] drr = new int[]{5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell2(array, drr[i]);
        }
    }

    private static void shell2(int[] array, int gap) {
        int j = 0;
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            for(j = i-gap; j >= 0; j-=gap) {
                if (array[j] > tmp) {
                    array[j+gap] = array[j];
                } else {
                    break;
                }
            }
            array[j+gap] = tmp;

        }
    }

    //5直接插入
    public static void insertSort(int[] array) {
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            for(j = i-1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

        //4选择
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }


        //3冒泡
    public static void bubbleSort(int[] array) {
        boolean flg = false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if (!flg) {
                break;
            }
        }
    }

    //2堆排序
    public static void heapSort(int[] array) {
        //建堆
        for (int i = (array.length-2)/2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
        int end = array.length-1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array, 0, end);
            end--;
        }
    }

    private static void adjustDown(int[] array, int root, int length) {
        int child = 2 * root+1;
        while (child < length) {
            if (child+1 < length && array[child] < array[child+1]) {
                child++;
            }
            if (array[child] > array[root]) {
                int tmp = array[child];
                array[child] = array[root];
                array[root] = tmp;
                root = child;
                child = 2 * root+1;
            } else {
                break;
            }

        }
    }


    //1快排非递归
    public static void quickSort2(int[] array) {
        quick2(array, 0, array.length-1);
    }

    private static void quick2(int[] array, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        int pivot = partion(array, low, high);
            if (pivot > low+1) {
                stack.push(low);
                stack.push(pivot-1);
            }
            if (pivot < high-1){
                stack.push(pivot+1);
                stack.push(high);
            }
        while (!stack.empty()) {
            high = stack.pop();
            low = stack.pop();
            pivot = partion(array, low, high);
            if (pivot > low+1) {
                stack.push(low);
                stack.push(pivot-1);
            }
            if (pivot < high-1){
                stack.push(pivot+1);
                stack.push(high);
            }
        }
    }

    //快排
    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quick(array, 0, array.length-1);
    }

    private static void quick(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        if (high-low+1 < 100) {
            insertSort2(array, low, high);
            return;
        }

        int pivot = partion(array, low, high);
        quick(array, low, pivot-1);
        quick(array, pivot+1, high);
    }

    public static void insertSort2(int[] array, int low, int high) {
        int j = 0;
        for (int i = low+1; i <= high; i++) {
            int tmp = array[i];
            for (j = i-1; j >= low; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    private static int partion(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while ((start < end) && (array[end] >= tmp)) {
                end--;
            }
            if (start >= end) {
                break;
            } else {
                array[start] = array[end];
            }

            while ((start < end) && (array[start] <= tmp)) {
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
}
