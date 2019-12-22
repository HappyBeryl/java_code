import java.util.Arrays;

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    //创建一个最大堆
    public void creatHeap(int[] array) {
        //赋值
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }

        //向下调整的方式进行调整 i代表每一棵树的根节点
        for (int i = (this.usedSize - 1 - 1) / 2; i >= 0; i--) {
            //是每一棵树都按照向下调整的方式进行调整
            AdjustDown(i, this.usedSize);
        }
    }

    public void AdjustDown(int root, int length) {
        //root是向下调整的父节点 调整child是向下调整的子节点的最大值
        int child = 2 * root + 1;
        while (child < length) {
            if (child + 1 < length && this.elem[child] < this.elem[child + 1]) {
                child = child + 1;
            }

            if (this.elem[child] > this.elem[root]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[root];
                this.elem[root] = tmp;
                root = child;
                child = 2 * root + 1;
            } else {
                break;
            }
        }
    }

    //打印
    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    /**
     * 优先级队列
     */
    //入队列
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    public void AdjustUp(int child) {
        int root = (child - 1) / 2;
        while (child > 0) {
            if (this.elem[child] > this.elem[root]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[root];
                this.elem[root] = tmp;
                child = root;
                root = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public void pushHeap(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        this.elem[usedSize] = val;
        this.usedSize++;
        //开始向上调整
        AdjustUp(this.usedSize - 1);
    }

    //出队列
    public boolean isEmpty() {
        return usedSize == 0;
    }

    public void popHeap() {
        if (isEmpty()) {
            return;
        }
        int tmp = this.elem[0];
        this.elem[0] = this.elem[usedSize - 1];
        this.elem[usedSize - 1] = tmp;
        this.usedSize--;
        AdjustDown(0, this.usedSize);
    }

    //得到队列第一个元素：
    public int getHeapTop() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[0];
    }

    //堆排序
    public void heapSort() {
        int end = this.usedSize - 1;
        while (end > 0) {
            int tmp = this.elem[end];
            this.elem[end] = this.elem[0];
            this.elem[0] = tmp;
            AdjustDown(0, end);
            end--;
        }
    }


}