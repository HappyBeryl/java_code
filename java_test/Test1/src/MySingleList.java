class ListNode {
    int data;
    ListNode next;
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class MySingleList {
    ListNode head;
    public MySingleList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            head = node;
        } else {
            node.next = this.head;
            head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //显示
    public void disPlay() {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    //任意节点插入，第一个位置是0号坐标
    //找前驱
    private ListNode findPrevNode (int index) {
        ListNode prev = this.head;
        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }
        return prev;
    }

    //求长度
    private int getLength() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public boolean addIndex(int index, int data) {
        if (index < 0 || index > getLength()) {
            return false;
        }
        if (index == 0) {
            addFirst(data);
            return true;
        }
        ListNode prev = findPrevNode(index);
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        return true;
    }

    //查找是否包含关键字key
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (key == cur.data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现的关键字key
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
        ListNode cur = getPrevNode(key);
        ListNode del = cur.next;
        cur.next = del.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode prev =  this.head;
        ListNode cur = prev.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
            if (key == this.head.data) {
                this.head = head.next;
            }
        }
    }

    //清空单链表
    public void clear() {
        while (this.head.next != null) {
            ListNode cur = this.head.next;
            this.head.next = cur.next;
        }
    }

    //反转一个单链表
    public ListNode reverse() {
        ListNode cur = this.head;
        ListNode prev = null;
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

    // 显示2
        public void disPlay2(ListNode newHead) {
            if (newHead == null) {
                return;
            }
            ListNode cur = newHead;
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
        }

        //返回中间节点
    public ListNode midNode() {
        ListNode slow = this.head;
        ListNode fast = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //倒数第k个，遍历一遍
    public ListNode findKthToTail1(int k) {
        if (k <= 0) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        for (int i = 0; i < k-1; i++) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
