package com.hym.datastructure.datastructure.queue;

public class MyArrayQueue<E> {
    private Object[] datas;
    private int size;
    private int head = 0;
    private int tail = 0;

    public MyArrayQueue(int capacity) {
        datas = new Object[capacity];
        size = capacity;
    }

    /**
     * 入队
     *
     * @param e
     * @return
     */
    public boolean enqueue(E e) {
        if (tail == size) {
            //tail==size&&head==0表示队列已经满了，无法在插入元素
            if (head == 0) {
                return false;
            } else {
                //head>0,表示队列头部有空闲位置，可以通过数据搬迁，将空闲位置挪到队列尾部
                System.arraycopy(datas, head, datas, 0,
                        tail - head);
                tail = tail - head;
                head = 0;
            }
        }
        datas[tail] = e;
        tail++;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public E dequeue() throws Exception {
        //队列为空
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }
        //返回队列头部的元素，同时head向后移动一位
        E item = (E) datas[head];
        datas[head] = null;
        head++;
        return item;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        } else {
            return false;
        }
    }
}
