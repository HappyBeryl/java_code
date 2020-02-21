package HashBucket;

public class HashBucket {
    static class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] array = new Node[7]; //存放单链表的头节点
    private int size; //当前数据的个数

    //往数组里面放元素
    public void put(int key, int value) {
        //1.在链表中查找key所在的节点
        int index = key % array.length;
        //2.如果找到了，更新
        for (Node cur  = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
        }
        //3.如果没找到，头插法插入一个新的节点
        Node node = new Node(key, value);
        node.next = array[index]; //先绑后面
        array[index] = node;
        size++;

        //超过负载因子需要扩容
        if (loadFactor() >= 0.75) {
            //扩容
            resize();
        }
    }

    private void resize() {
        //扩容后需要重现哈希
        Node[] newArray = new Node[2*array.length];
        //遍历原来的数组，不为空的元素重现哈希到新数组
        for (int i = 0; i < array.length; i++) {
            Node curNext = null;
//            for (Node cur = array[i]; cur != null; cur = curNext) {
//                int index = cur.key % newArray.length;
//                //提前记录cur.next
//                curNext = cur.next;
//                //头插法插入到新的链表中去
//                cur.next = newArray[index];
//                newArray[index] = cur;
//            }
            Node cur = array[i];
            while (cur != null) {
                int index = cur.key % newArray.length;
                //提前记录cur.next
                curNext = cur.next;
                //头插法插入到新的链表中去
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        array = newArray;
    }

    //负载因子
    private double loadFactor() {
        return this.size*1.0 / array.length;
    }


    //取元素 根据key找value
    public int getValue(int key) {
        //拿到合法的下标
        int index = key % array.length;
        //遍历array[index]下标的链表，找到值为key的数据并返回
        Node head = array[index];
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return cur.value;
            }
        }
        return -1;
    }
}
