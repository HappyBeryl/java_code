package com.SingleList;

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
class
MySingleList {
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
        if (this.head.data == key) {
            this.head = this.head.next;
        }
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


  //  反转单链表
    public ListNode reverseList() {
        if(this.head == null) {
            return null;
        }
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

    public void disPlay2(ListNode newHead) {
        if (newHead == null) {
            return;
        }
        ListNode tmp = newHead;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public ListNode middleNode() {
//        ListNode cur = this.head;
//        int length = getlength()/2;
//        for (int i = 0; i < length; i++) {
//            cur = cur.next;
//        }
//        return cur;
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    //输入一个链表，输出链表的倒数第k个节点--方法1
    public ListNode findKthToTail1(int k) {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        if (k <= 0 || k > count || this.head == null) {
            return null;
        }
        cur = this.head;
        for (int i = 0; i < count-k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //输入一个链表，输出链表的倒数第k个节点---方法2
    public ListNode FindKthToTail(int k) {
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
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;

        }
        return slow;
    }

    //以x为基准分割链表
    public ListNode partition(int x){
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.data < x) {
                //是不是第一次插入
                if(bs == null) {
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                //是不是第一次插入
                if(as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //第一个区间没有数据
        if (bs == null) {
            return as;
        }
        be.next = as;
        //把最后一个节点的next置空，否则会造成死循环（此时尾节点不为空）
        if (as != null) {
            ae.next = null;
        }
        return bs;
    }



//删除重复的节点
    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null) {
            //重复的节点
            if(cur.next != null && cur.data == cur.next.data) {
                //每一次都需要判断cur.next
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        //最后一个节点如果也是重复的，需要将tmp.next置为空
        tmp.next = null;
        return newHead.next;
    }



    //单链表判断回文数
    public boolean chkPalindrome() {
        //为空
        if (this.head == null) {
            return false;
        }
        //一个数
        if (head.next == null) {
            return true;
        }
        //1、找到单链表的中间节点
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、反转单链表
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3、fast/slow往前    head往后走
        while (this.head != slow) {
            if (this.head.data != slow.data) {
                return false;
            }
            //偶数
            if (this.head.next == slow) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }


    //创造一个环
    public void creteLoop() {
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next;
    }

    //判断链表是否有环
    public boolean hasCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null)  {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next ==null) {
            return false;
        }
        return true;
    }

    //返回链表入环的第一个节点
    public ListNode detectCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null)  {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next ==null) {
            return null;
        }
        slow = this.head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }







}
