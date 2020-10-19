package com.hym.datastructure.datastructure.queue;

/**
 * 循环队列
 *
 * @param <E>
 */
public class MyCircularQueue<E> {
    private Object[] datas;
    private int size;
    private int head = 0;
    private int tail = 0;

    public MyCircularQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("queue capacity must more than zero");
        }
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
        if ((tail + 1) % size == head) {//表示队列已经满了
            return false;
        }
        datas[tail] = e;
        tail = (tail + 1) % size;
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
        head = (head + 1) % size;
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
