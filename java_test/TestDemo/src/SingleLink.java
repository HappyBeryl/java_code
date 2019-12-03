import sun.font.FontRunIterator;

class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
    }
}

public class SingleLink {
    public Node head;
    public SingleLink(Node head) {
        this.head = null;
    }

    //删除链表中给定key的所有节点
    public void removeAllKey(int key) {
        Node prev = this.head;
        Node cur = prev.next;
        while (cur != null) {
            if (key == prev.next.data) {
               prev.next = cur.next;
               cur = cur.next;
            } else {
                cur = cur.next;
                prev = prev.next;
            }

        }
        if (this.head.data == key) {
            this.head = head.next;
        }
    }

    //翻转
    public Node reverseList() {
        Node prev = null;
        Node cur = this.head;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext.next;
        }
        return newHead;
    }

    //返回中间节点
    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null)  {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //倒数第k个节点
    public Node FindKthToTail(int k) {
        if (k <= 0 || this.head == null) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
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

    //合并有序链表
    public static Node mergeTwoLists1(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            } else {
                tmp.next = headB.next;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA == null) {
            tmp.next = headB;
        } else {
            tmp.next = headA;
        }
        return tmp.next;
    }

    public Node partition(int x) {
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while (cur != null) {
            if (cur.data < x) {
               if (bs.next == null) {
                   bs = cur;
                   be = cur;
                   cur = cur.next;
               } else {
                   be.next = cur;
                   be = be.next;
                   cur = cur.next;
               }
            } else {
                if (as.next == null) {
                    as = cur;
                    ae = cur;
                    cur = cur.next;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                    cur = cur.next;
                }
            }
        }
        if (be.next != null) {
            be.next = as;
        }
        if (bs == null) {
            return as;
        }
        if (as != null) {
            ae.next = null;
        }
        return bs;
    }

    //删除重复节点
    public Node deleteDuplication() {
        Node cur = this.head;
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (cur != null) {
            if (cur.next != null && cur != null) {
                while (cur.next != null && cur != null) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead;
    }



    public boolean chkPalindrome() {
        if (this.head == null) {
            return false;
        }
        //一个数
        if (head.next == null) {
            return true;
        }
        //1、找到单链表的中间节点
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node cur = slow.next;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //
        while (this.head != slow) {
            if (this.head.data != slow.data) {
                return false;
            }
            //偶数个数
            if (this.head.next == slow) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
        }

    //找公共节点
    public static Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null) {
            return null;
        }
        Node pL = headA;//永远指向长的单链表
        Node pS = headB;//永远指向短的单链表
        int lenA = 0;
        int lenB = 0;
        //求的lenA  lenB
        while (pL != null) {
            lenA++;
            pL = pL.next;
        }
        while (pS != null) {
            lenB++;
            pS = pS.next;
        }
        //pl、ps为空了
        pL = headA;
        pS = headB;
        //差值-》最长的单链表先走len步
        int len = lenA-lenB;
        if(len < 0) {
            pL = headB;
            pS = headA;
            len = lenB-lenA;
        }
        //让pL先走len步
        for (int i = 0; i < len; i++) {
            pL = pL.next;
        }
        //开始一起走  (pL  != pS ) {一人一步走}
        while (pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
//        if (pL == null) {
//            return null;
//        }
//        return pL;
        return pL;
    }

    //入环的第一个节点
    public Node detectCycle() {
     Node fast = this.head;
     Node slow = this.head;
     while (fast != null && fast.next != null) {
         fast = fast.next.next;
         slow = slow.next;
         if (fast == slow) {
             break;
         }
     }
     if (fast == null || fast.next == null) {
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

