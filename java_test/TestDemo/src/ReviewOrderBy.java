import java.util.Arrays;

public class ReviewOrderBy {

    /*
    堆排序
     */
    public static void adjustDown(int[] array, int p, int len) {
        int c = 2*p + 1;
        while (c < len) {
            //保证有有孩子
            while (c + 1 < len && array[c] < array[c+1]) {
                c++;
            }
            //c指向子孩子的较大自
            if (array[p] < array[c]) {
                int tmp = array[p];
                array[p] = array[c];
                array[c] = tmp;
                p = c;
                c = 2*p + 1;
            } else {
                break;
            }
        }
    }

    //调整为大根堆
    public static void creatHeap(int[] array) {
        //每棵树都要调整为大根堆
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
    }

    //堆排序
    public static void heapSort(int[] array) {
        creatHeap(array);
        int end = array.length-1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            //取不到end 所有先调整 后--
            adjustDown(array,0,end);
            end--;
        }
    }


    public static void insertSort(int[] array) {
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            for (j = i-1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void insertSort1(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp =array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /*
    归并排序
     */

    public static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid+1;

        int[] tmpArr = new int[high-low+1];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            //如果是小于，那么就不稳定了
            if(array[s1] <= array[s2]) {
                tmpArr[i++] = array[s1++];
            }else {
                tmpArr[i++] = array[s2++];
            }
        }

        while (s1 <= mid) {
            tmpArr[i++] = array[s1++];
        }
        while (s2 <= high) {
            tmpArr[i++] = array[s2++];
        }

        for (int j = 0; j < tmpArr.length; j++) {
            array[low+j] = tmpArr[j];
        }

    }

    public static void mergeSortInternal(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSortInternal(array, 0, mid);
        mergeSortInternal(array, mid+1, high);
        merge(array,low,mid,high);
    }

    public static void mergeSort1(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }

    public static void mergeSort(int[] array) {

        for (int i = 1; i < array.length; i *= 2) {
            merge(array,i);
        }
    }
    //gap代表每个归并段的数据
    public static void merge(int[] array,int gap) {
        int[] tmpArr = new int[array.length];
        int k = 0;//下标

        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < array.length ? s2+gap-1:array.length-1;

        //两个归并段都有数据
        while (s2 < array.length) {

            while (s1 <= e1 && s2 <= e2) {
                if(array[s1] <= array[s2]) {
                    tmpArr[k++] = array[s1++];
                }else {
                    tmpArr[k++] = array[s2++];
                }
            }

            while (s1 <= e1) {
                tmpArr[k++] = array[s1++];
            }

            while (s2 <= e2) {
                tmpArr[k++] = array[s2++];
            }

            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 < array.length ? s2+gap-1:array.length-1;
        }
        //判断是不是还有一个归并段，且这个归并段一定是s1那个段,直接小于e1可能会越界
        while (s1 <= array.length-1) {
            tmpArr[k++] = array[s1++];
        }

        for (int i = 0; i < tmpArr.length; i++) {
            array[i] = tmpArr[i];
        }
    }

        public static void main(String[] args) {
        int[] array = new int[] {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        mergeSort1(array);
        System.out.println(Arrays.toString(array));
    }


}
