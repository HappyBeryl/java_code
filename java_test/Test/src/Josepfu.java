public class Josepfu {
    public static void main(String[] args) {
        CircleSingleList circleSingleList = new CircleSingleList();
        circleSingleList.addNode(5);
        //  circleSingleList.disPlay();
        circleSingleList.countNode(1,2,5);
    }
}

//创建节点
class Node {
    public int no;
    public Node next;
    public Node(int no) {
        this.no = no;
    }
}

//创建一个环形链表
class CircleSingleList {
    Node head;
    public CircleSingleList() {
        this.head = head;
    }

    //添加环形单链表节点
    public void addNode(int nums) {
        if (nums < 1) {
            return;
        }
        Node cur = null;
        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if (i == 1) {
                //自成环
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

    //遍历显示
    public void disPlay() {
        if (this.head == null) {
            return;
        }
        Node cur = this.head;
        while (true) {
            System.out.print(cur.no + " ");
            //终止条件
            if (cur.next == head) {
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
        if (this.head == null || startNo < 0 || startNo > nums) {
            return;
        }
        //需要一个辅助节点时最后一个节点
            Node tmp = this.head;
            while (true) {
                if (tmp.next == head) {
                    break;
                }
                tmp = tmp.next;
            }
         //从第start开始数数
            for (int i = 0; i < startNo-1; i++) {
                head = head.next;
                tmp = tmp.next;
            }
         // 循环出圈
            while (true) {
                if (tmp == this.head) {
                    break;
                }
                for (int i = 0; i < countNum-1; i++) {
                    head = head.next;
                    tmp = tmp.next;
                }
                //head所指的节点出圈
                System.out.printf("%d号出圈",head.no);
                System.out.println();
                head = head.next;
                tmp.next = head;
            }
            System.out.printf("最后留在圈中的%d号",head.no);
    }
}
