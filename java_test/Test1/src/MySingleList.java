

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
class  MySingleList {
    public ListNode head; //标志头
    public MySingleList() {
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

    //  尾插法
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
    //得到链表长度
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

    //打印单链表
    public void display() {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while(cur != null) {
            System.out.printf(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

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

    //d打印2
    public void disPlay2(ListNode newHead) {
        if (newHead == null) {
            return;
        }
        ListNode cur = newHead;
        while(cur != null) {
            System.out.printf(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    //以x为基准分割链表
    public ListNode partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while(cur != null) {
            if (cur.data < x) {
                //判断是否为第一次加入
                if (bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }

            } else {
                //判断是否为第一次加入
                if (as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        be.next = as;
        if (bs == null) {
            return as;
        }
        //把最后一个节点的next置空，否则会造成死循环（此时尾节点不为空）
        if (as != null) {
            ae.next = null;
        }
        return bs;
    }

    //删除重复节点
    public ListNode deleteDuplication() {
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        if (cur.next != null && cur.data == cur.next.data) {
            while (cur.next != null && cur.data == cur.next.data) {
                cur = cur.next;
            }
            cur = cur.next;
        } else {
            tmp.next = cur;
            tmp = tmp.next;
            cur = cur.next;
        }
        tmp.next = null;
        return newHead.next;
    }


    //单链表判断回文数
    public boolean chkPalindrome() {
        //1、找到中间节点
        ListNode slow = this.head;
        ListNode fast = this.head;
        while (fast.next != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、反转
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3、head往后 slow往前
        while (this.head != slow) {
            if (this.head.data != slow.data) {
                return false;
            }
            //偶数个
            if (this.head.next == slow) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode findKthToTail(int k) {
        if (k <= 0 || this.head == null) {
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
