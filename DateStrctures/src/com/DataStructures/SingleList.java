//package com.DataStructures;
//
//class ListNode {
//    public int data;
//    public ListNode next;
//    public ListNode(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//class SingleList {
//
//    public ListNode head;//标志头
//
//    public SingleList() {
//        this.head = null;
//    }
//
//    //头插法
//    public void addFirst(int data){
//        ListNode node = new ListNode(data);
//        if (this.head == null) {
//            this.head = node;
//        } else {
//            node.next = this.head;
//            this.head = node;
//        }
//    }
//
//    //尾插法
//    public void addLast(int data){
//        ListNode node = new ListNode(data);
//        ListNode cur = this.head;
//        //判断是否为第一次插入
//        if (this.head == null) {
//            this.head = node;
//        } else {
//            //找尾巴
//            while (cur.next != null) {
//                cur = cur.next;
//            }
//            //进行插入
//            cur.next = node;
//        }
//    }
//
//    private ListNode searchIndex(int index) {
//       // tmp-->index-1;
//        ListNode tmp = this.head;
//        for (int i = 0; i < index-1; i++) {
//            tmp = tmp.next;
//        }
//        return tmp;
//    }
//    //插入到index位置
//    //任意位置插入,第一个数据节点为0号下标
//    public int getLength() {
//        int count = 0;
//        ListNode cur = this.head;
//        while(cur != null) {
//            count++;
//            cur = cur.next;
//        }
//        return count;
//    }
//
//    //任意位置元素插入节点
//    public boolean addIndex(int index,int data){
//        if (index < 0 || index > getLength()) {
//            return false;
//        }
//        if(index == 0) {
//            addFirst(data);
//            return true;
//        }
//        ListNode prev = searchIndex(index);
//        ListNode node = new ListNode(data);
//        node.next = prev.next;
//        prev.next = node;
//        return true;
//    }
//
//
//    //打印单链表
//    public void display() {
//        if (this.head == null) {
//            return;
//        }
//        ListNode cur = this.head;
//        while(cur != null) {
//            System.out.println(cur.data + " ");
//        }
//    }
//
//
//    private ListNode searchPrev(int key) {
//        ListNode prev = head;
//        while (prev.next != null) {
//            if(prev.next.data == key) {
//                return prev;
//            }
//            prev = prev.next;
//        }
//        return null;
//    }
//    //删除第一次出现关键字为key的节点
//    public void remove(int key){
//        //1、删除的节点如果是头结点
//        if (this.head.data == key) {
//            this.head = this.head.next;
//        }
//        //2、找到删除的节点的前驱  如果找不到  返回null
//        ListNode prev = searchIndex(key);
//        if (prev == null) {
//            System.out.println("找不到");
//            return;
//        }
//        //3、进行删除
//        ListNode del = prev.next;
//        prev.next = del.next;
//    }
//
//    public void removeAllkey(int key) {
//        if (head == null) {
//            return;
//        }
//        ListNode prev = this.head;
//        ListNode cur = this.head.next;
//        while(cur != null) {
//            if (prev.next.data == key) {
//                prev.next = cur.next;
//                cur = cur.next;
//            } else {
//                prev = cur;
//                cur = cur.next;
//            }
//        }
//        //最后处理
//        if (this.head.data == key) {
//            this.head = this.head.next;
//        }
//    }
//
//
//}
//
