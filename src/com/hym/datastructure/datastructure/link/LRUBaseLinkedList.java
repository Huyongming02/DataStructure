package com.hym.datastructure.datastructure.link;

public class LRUBaseLinkedList<E> {
    /**
     * 1. 节点定义
     * 2. 大小限制
     * 3. 添加
     */

    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public LRUBaseLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public void add(E e) {
        Node<E> node = findNode(e);
        if (node != null) {
            deleteElement(node);
            insertElementAtBegin(e);
        } else {
            if (size >= capacity) {
                deleteElementAtEnd();
            }
            insertElementAtBegin(e);
        }
    }

    public void printAll() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = head;
        while (node != null) {
            builder.append(node.item + ",");
            node = node.next;
        }
        System.out.println("printAll:" + builder.toString());
    }

    private void deleteElementAtEnd() {
        if (tail != null) {
            deleteElement(tail);
        }
    }

    private void insertElementAtBegin(E e) {
        if (head == null) {
            Node<E> node = new Node<>(e, null, null);
            head = node;
            tail = node;
        } else {
            Node<E> node = new Node<>(e, head, null);
            head.prev = node;
            head = node;
        }
        size++;
    }

    private void deleteElement(Node<E> node) {
        if (node == head || node == tail) {
            if (node == head) {
                head = node.next;
                if (head != null) {//head!=tail
                    head.prev = null;
                }
            }
            if (node == tail) {
                tail = node.prev;
                if (tail != null) {//head!=tail
                    tail.next = null;
                }
            }
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        node.item = null;
        size--;
    }

    private Node<E> findNode(E e) {
        Node temp = head;
        while (temp != null) {
            if (temp.item.equals(e)) {
                return temp;
            } else {
                temp = temp.next;
            }
        }
        return null;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node() {
        }

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
