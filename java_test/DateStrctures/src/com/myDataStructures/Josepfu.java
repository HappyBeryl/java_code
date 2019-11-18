package com.myDataStructures;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleList circleSingleList = new CircleSingleList();
        circleSingleList.add(5);
      //  circleSingleList.disPlay();
        circleSingleList.countNode(1,2,5);
    }
}

//创建一个环形的单向链表
class CircleSingleList {
    public Node head;
    public CircleSingleList() {
        this.head = null;
    }

    //添加
    public void add(int nums) {
        //nums是添加小孩的数量
        if (nums < 1) {
            return;
        }
        Node cur = null;
        for (int i = 1; i <= nums; i++) {
            Node node =new Node(i);
            //如果是第一个要自成环
            if (i == 1) {
               this.head = node;
               this.head.next = this.head;
               cur = this.head;
            } else {
                cur.next = node;
                node.next = head;
                cur = node;
            }
        }
    }

    //遍历
    public void disPlay() {
        if (this.head == null) {
            return;
        }
        Node cur = this.head;
        while (true) {
            System.out.print(cur.no + " ");
            if(cur.next == head) {
                break;
            }
            cur = cur.next;
        }
    }

    //根据用户输入 计算出圈顺序
    public void countNode(int startNo, int countNum, int nums) {
        /**
         * startNo示从第几个人开始数
         * countNum表示数几下
         * nums表示人的数量
         */
        //判断startNum的有效性
        if (startNo < 0 || startNo > nums || head == null) {
            return;
        }
        //创建辅助指针tmp，指向环形链表最后的节点
        Node tmp = this.head;
        while (true) {
            if (tmp.next == this.head) {
                break;
            }
            tmp = tmp.next;
        }
        //让tmp和head指针同时移动startNo-1c次
        for (int i = 0; i < startNo-1; i++) {
            head = head.next;
            tmp = tmp.next;
        }
        //报数时，让head和tmp同时移动countNum-1次，然后出圈
        while(true) {
            if (tmp == head) {
                break;
            }
            for (int i = 0; i < countNum-1; i++) {
                head = head.next;
                tmp = tmp.next;
            }
            //这时first指向的节点，就是出圈的节点
            System.out.printf("小孩%d要出圈",head.no);
            System.out.println();
            head = head.next;
            tmp.next = head;
        }
        System.out.printf("最后留在圈中的小孩是%d" , head.no);
    }



}

//创建节点
class Node {
    public int no; //编号
    public Node next; //指向下一个节点
    public Node (int no) {
        this.no = no;
    }
}



