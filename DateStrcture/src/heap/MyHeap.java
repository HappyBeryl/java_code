package heap;

import java.util.Arrays;

/**
 * 调整为大根堆
 */
public class MyHeap {

    public int[] elem;
    public int usedSize;

    public MyHeap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    public void AdjustDown(int root, int len) {
        int parent = root;
        int child = 2 * parent + 1;
        //判断是否有孩子
        while (child < len) {
            if (child + 1 < len &&
                    this.elem[child] < this.elem[child + 1]) {
                child = child + 1;
            }
            //child是左右孩子的最大值下标
            if (this.elem[child] > this.elem[parent]) {
                //交换
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }


    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        /**
         * i:代表的是每一棵树的根节点
         *
         */
        for (int i = (this.usedSize - 1 - 1) / 2; i >= 0; i--) {
            //是每一棵树都按照向下调整的方式进行调整
            AdjustDown(i, this.usedSize);
        }
    }

    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
}