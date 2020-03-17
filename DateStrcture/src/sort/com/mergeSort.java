package sort.com;

import java.util.Arrays;

public class mergeSort {

    //合并递归完的数组
    public static void merge1(int[] array,int low,int mid,int high) {

        int s1 = low;
        int s2 = mid+1;

        int[] tmpArr = new int[high-low+1];  //需要重新申请一个空间存储数组元素
        int i = 0;//tmpArr的数组下标
        //当两个归并段都有数据的时候
        while (s1 <= mid && s2 <= high) {
            //如果是小于，那么就不稳定了
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
        //tmpArr里面存放的是有序的数据
        //将tmpArr里面存放的有序的数据，放回到array里面
        for (int j = 0; j < tmpArr.length; j++) {
            array[low+j] = tmpArr[j];
        }
    }

    //进行递归：分
    public static void mergeSortInternal(int[] array,int low,int high) {
        if(low >= high) { //递归的终止条件
            return;
        }
        //以mid区分前后两段 分段递归
        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //把递归完的数组进行合并
        merge1(array,low,mid,high);
    }

    public static void mergeSort1(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }


}
