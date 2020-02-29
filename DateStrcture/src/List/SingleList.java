package List;
//定义节点
class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data) {
        this.data = data;
        this.next = next;
    }
}

public class SingleList {
    public ListNode head; //标志头

    public SingleList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        //判断链表是否为空
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode tmp = this.head;
        //判断链表是否为空
        if (this.head == null) {
            this.head = node;
        } else {
            //找最后一个节点
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    //任意位置插入，第一个节点为0号下标
    private int getlength() {
        ListNode tmp = this.head;
        int count = 0;
        while(tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }
    //找要插入位置的前一个节点(index-1) 返回当前节点的引用
    private ListNode findUpNode(int index) {
        ListNode prev = this.head;
        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }
        return prev;
    }

    public boolean addIndex(int index,int data) {
        //首先判断index是否合法
        if (index < 0 || index > getlength()) {
            System.out.println("非法输入");
            return false;
        }
        //判断是否插入到第一个
        if (index == 0) {
            addFirst(data);
            return true;
        }
        //否的话 找到要插入节点的前一个位置，进行插入
        ListNode prev = findUpNode(index);
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        return true;
    }

    //查找是否包含key关键字在单链表中
    public boolean contains(int key) {
        ListNode tmp = this.head;
        while(tmp != null) {
            if (tmp.data == key) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    //删除第一次出现的关键字key的节点
    //找要删除节点的前驱
    public ListNode findPrevNode(int key) {
        ListNode prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    public void remove(int key) {
        //删除的如果是头节点
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //找到删除的节点的前驱  如果找不到  返回null
        ListNode prev = findPrevNode(key);
        if (prev == null) {
            System.out.println("找不到");
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur != null) {
            if (prev.next.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        //处理第一个节点--最后处理
        if (head.data == key) {
            head = head.next;
        }
    }

    //打印单链表
    public void diaplay() {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while(cur != null) {
            System.out.printf(cur.data + " ");
            cur = cur.next;
        }
    }

    //清空单链表
    //清空单链表1
    public void clear1() {
        this.head = null;
    }

    //清空单链表2
    public void clear() {
        while (this.head.next != null) {
            ListNode tmp = this.head.next;
            this.head.next = tmp.next;
        }
    }


}
