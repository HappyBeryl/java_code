package sort.com;

public class mergeSort2 {
    public static void mergeSort(int[] array) {

        //进行分组归并
        for (int i = 1; i < array.length; i *= 2) {
            merge(array,i);
        }
    }
    //gap代表每个归并段的数据
    public static void merge(int[] array,int gap) {
        int[] tmpArr = new int[array.length];
        int k = 0;//下标

        int s1 = 0; //第一组的开头
        int e1 = s1+gap-1; //第一组的结尾
        int s2 = e1+1; //第二组的开头
        int e2 = s2+gap-1 < array.length ? s2+gap-1:array.length-1; //第二组的结尾

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


}
