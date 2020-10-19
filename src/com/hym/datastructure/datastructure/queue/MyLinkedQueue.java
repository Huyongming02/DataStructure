package com.hym.datastructure.datastructure.queue;

/**
 * 链式队列
 *
 * @param <E>
 */
public class MyLinkedQueue<E> {
    private Node<E> head;
    private Node<E> tail;

    /**
     * 入队
     *
     * @param e
     * @return
     */
    public boolean enqueue(E e) {
        Node<E> node = new Node<>(e);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public E dequeue() {
        if (head == null) {
            return null;
        } else {
            E e = head.item;
            head = head.next;
            if (head == null) {//head等于null，表示队列中的元素已经全部出队了，这时要将tail置空，避免tail一直引用元素，造成元素无法回收
                tail = null;
            }
            return e;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E e) {
            this.item = e;
        }
    }
}
