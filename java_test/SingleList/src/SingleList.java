import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

//定义节点
class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data) {
        this.data = data;
        this.next = next;
    }
}

//定义单链表
class SingleList {
    public ListNode head; //标志头

    public SingleList() {
        this.head = null;
    }

        //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        } else {  //必须加else
            node.next = this.head;
            this.head = node;
        }

    }

    //显示
    public void disPlay() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
     //尾插法
     public void addLast(int data) {
         ListNode node = new ListNode(data);
         ListNode cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
     }

//     //任意位置插入,第一个数据节点为0号下标
//    //获取链表长度
    private int getLength() {
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return  count;
    }

    //找前驱
    private ListNode findPrevNode(int index) {
        ListNode prev = this.head;
        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }
        return prev;
    }

     public boolean addIndex(int index,int data){
        if (index < 0 || index > getLength()) {
            return false;
        }
        if (index == 0) {
            addFirst(index);
            return true;
        }
        ListNode prev = findPrevNode(index);
        if (prev ==null) {
            System.out.println("非法");
            return false;
        } else {
            ListNode node = new ListNode(data);
            node.next = prev.next;
            prev.next = node;
            return true;
        }
    }


    //查找是否包含关键字key是否在单链表当中
        public boolean contains(int key) {
            ListNode cur = this.head;
            while (cur != null) {
                if(cur.data == key) {
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }
     //删除第一次出现关键字为key的节点
    //找前驱
    public ListNode getPrevNode(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

     public void remove(int key) {
        ListNode prev = getPrevNode(key);
        ListNode del = prev.next;
        if ( prev != null) {
            prev.next = del.next;
        }
    }

     //删除所有值为key的节点
     public void removeAllKey(int key) {
        ListNode prev = this.head;
        ListNode cur = prev.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        //处理头节点
         if (this.head.data == key) {
            head = head.next;
         }
     }
    //清空
     public void clear() {
        while (head.next != null) {
           ListNode cur = this.head.next;
           this.head.next = cur.next;
        }
    }

    //反转单链表
    public ListNode reverseList() {
        if (this.head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = this.head; //反转的节点
        ListNode newHead = null;
        while (cur != null) {
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

    public void disPlay2(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //返回中间节点
    public ListNode middleNode() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //倒数第k个 遍历yibian
    public ListNode findKthToTail(int k) {
        if (k <= 0) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        for (int i = 0; i < k-1; i++) {
            if (fast.next == null) {
                System.out.println("无");
                return null;
            }
            fast = fast.next;
        }
            while (fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
        return slow;
        }



}