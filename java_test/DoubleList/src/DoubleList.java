class ListNode {
    public int data;
    public ListNode next;
    public ListNode prev;
    public ListNode(int data) {
        this.data = data;
    }
}

public class DoubleList {
    public ListNode head;
    public ListNode last;//尾巴

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        //第一次插入
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        //第一次插入
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev= this.last;
            this.last = node;
        }
    }

    //显示
    public void disPlay() {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data +" ");
            cur = cur.next;
        }
        System.out.println();
    }


    //
    private ListNode searchIndex(int index) {
        ListNode cur = this.head;
        for (int i = 0; i < index; i++) {
            if (index < 0 || index >= size()) {
                return null;
            }
            cur = cur.next;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data) {
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == size()) {
            addLast(data);
            return true;
        }
        //中间插入
        ListNode node = new ListNode(data);
        ListNode cur = searchIndex(index);
        if (cur == null) {
            return false;
        }
        cur.prev.next = node;
        node.prev = cur.prev;
        node.next = cur;
        cur.prev = node;
        return true;
    }

    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

//    //查找是否包含关键字key是否在链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                //删除头节点
                if (cur == this.head) {
                    this.head = this.head.next;
                    head.prev = null;
                } else {
                    //删除中间节点
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else { //尾节点
                        this.last = cur.prev;
                    }
                    return;
                }
                cur = cur.next;
            }
        }
    }

    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                //删除头节点
                if (cur == this.head) {
                    this.head = this.head.next;
                    head.prev = null;
                } else {
                    //删除中间节点
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else { //尾节点
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    //清空
    public void clear() {
        while (this.head != null) {
            ListNode cur = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = cur;
//            cur = cur.next;
        }
        this.last = null;
    }


}
