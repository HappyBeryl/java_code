package queue.com;

public class MyCircularQueue {

        public int[] elem;
        public int front;
        public int rear;
        public int usedSize;
        public MyCircularQueue(int k) {
            this.elem = new int[k];
            this.front = 0;
            this.rear = 0;
            this.usedSize = 0;
        }
        //进队列
        public boolean enQueue(int value) {
          if (isFull()) {
              return false;
          }
          this.elem[rear] = value;
          this.rear = (this.rear + 1) % this.elem.length;
          this.usedSize++;
          return true;
        }

        //出队列
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            this.front = (this.front+1) % this.elem.length;
            this.usedSize--;
            return true;
        }

        //弹出队头元素
        public int Front() {
            if(isEmpty()) {
                return -1;
            }
            return this.elem[this.front];
        }
        //弹出队尾元素
        public int Rear() {
            if(isEmpty()) {
                return -1;
            }
            //or(rear+length)%length-1
            int index = this.rear == 0 ? index = this.elem.length-1 : this.rear-1;
            return elem[index];
        }

        public boolean isEmpty() {
            return this.front == this.rear;
        }

        public boolean isFull() {
            return this.front == (this.rear+1)%this.elem.length;
        }

}
