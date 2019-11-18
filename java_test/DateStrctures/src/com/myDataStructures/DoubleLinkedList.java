//package com.myDataStructures;
//
////创建一个双向链表节点的类
//class Node1 {
//   public int data;
//   public Node prev;
//   public Node next;
//   public Node1(int data) {
//        this.data = data;
//    }
//}
//
//
////创建一个双向链表节点的类
//public class DoubleLinkedList {
//    Node1 head;
//
//    //添加
//    public void addLast(int data) {
//      Node1 cur = this.head;
//      Node1 node = new Node1(data);
//        //找到最后一个节点
//      while (cur.next != null) {
//          cur = cur.next;
//      }
//      //添加
//        cur.next = node;
//        node.prev = cur;
//    }
//
//    //遍历
//    public void disPlay() {
//        if (head.next == null) {
//            return;
//        }
//        Node cur = this.head.next;
//        while (true) {
//            if (cur == null) {
//                break;
//            }
//            System.out.print(cur);
//            cur = cur.next;
//        }
//    }
//
//}
//
