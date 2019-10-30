package com.datestructures;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        PeopleNode person1 = new PeopleNode(1,"白琼","beryl");
        PeopleNode person2 = new PeopleNode(2,"小明","haha");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.addByOrder(person2);
        singleLinkedList.addByOrder(person1);
        singleLinkedList.addByOrder(person1);
        singleLinkedList.list();

    }
}

//定义一个SingleLinkedList 管理英雄
class SingleLinkedList {
    //初始化一个头节点，位置不能变
    private PeopleNode head = new PeopleNode(0,"","");
    //不考虑编号顺序
    // 1、找到当前链表的最后节点
    //2、将这个节点的next 指向 新的节点
    public void add(PeopleNode peopleNode) {
        PeopleNode tmp = head;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = peopleNode;
    }

    //按照标号顺序添加节点
    public void addByOrder(PeopleNode peopleNode) {
        //tmp是位于添加节点的前一个节点，否则无法加入
        PeopleNode tmp = head;
        boolean flag = false;
        while (true) {
            if (tmp.next == null) {
                break;
            } else if (tmp.next.id > peopleNode.id) {
                break;
            } else if (tmp.next.id == peopleNode.id) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            System.out.println("已经存在，不能添加");
        } else{
            peopleNode.next = tmp.next;
            tmp.next = peopleNode;
        }
    }

    //显示链表，遍历
    public void list() {
        PeopleNode tmp = head;
        //判断链表是否为空
        while(true) {
            if (tmp == null) {
                break;
            }
            //输出节点信息
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }
}
//定义一个HeroNode，每个HeroNode就是一个节点
class PeopleNode {
    public int id;
    public String name;
    public String nickName;
    public PeopleNode next; //next域 存放下一个节点的信息

    public PeopleNode(int pid, String pname, String pnickname) {
        this.id = pid;
        this.name = pname;
        this.nickName = pnickname;
    }

    //重写toString方法
    public String toString() {
        return "PeopleNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
