
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
        for (int i = (this.usedSize-1-1)/2; i >= 0 ; i--) {
            //是每一棵树都按照向下调整的方式进行调整
            AdjustDown(i,this.usedSize);
        }
    }

    public void AdjustDown(int root, int length) {
        //root是向下调整的父节点 调整child是向下调整的子节点的最大值
        int child = 2*root+1;
        while (child < length) {
            if (child+1 < length && this.elem[child] < this.elem[child+1]) {
                child = child+1;
            }

            if (this.elem[child] > this.elem[root]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[root];
                this.elem[root] = tmp;
                root = child;
                child = 2*root+1;
            } else {
                break;
            }
        }
    }

    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] +" ");
        }
        System.out.println();
    }
 }