package com.hym.datastructure.datastructure.link;

public class MyLinkedList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
    }

    /**
     * 添加
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        addToLast(e);
        return true;
    }

    /**
     * 插入
     *
     * @param index
     * @param e
     * @return
     */
    public boolean add(int index, E e) {
        checkPositionIndex(index);
        if (index == size) {
            addToLast(e);
        } else {
            addBefore(e, getNode(index));
        }
        return true;
    }

    /**
     * 替换
     *
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e) {
        checkElementIndex(index);
        Node<E> node = getNode(index);
        E oldItem = node.item;
        node.item = e;
        return oldItem;
    }

    /**
     * 删除指定索引位置的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        checkElementIndex(index);
        return remove(getNode(index));
    }

    /**
     * 删除特定元素
     *
     * @param node
     * @return
     */
    private E remove(Node<E> node) {
        E oldItem = node.item;
        if (node == first || node == last) {//删除头和尾需要特殊处理
            if (node == first) {
                if (node.next != null) {//node.next==null为只剩一个元素的情况
                    node.next.prev = null;
                }
                first = node.next;
            }
            if (node == last) {
                if (node.prev != null) {//node.prev==null为只剩一个元素的情况
                    node.prev.next = null;
                }
                last = node.prev;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.item = null;
        size--;
        return oldItem;
    }

    /**
     * 获取指定索引位置的元素值
     *
     * @param index
     * @return
     */
    public E get(int index) {
        checkElementIndex(index);
        Node<E> node = getNode(index);
        return node.item;
    }

    public boolean remove(E e) {
        if (first != null) {
            Node<E> temp = first;
            if (e == null) {
                while (temp != null) {
                    if (temp.item == null) {
                        remove(temp);
                        return true;
                    } else {
                        temp = temp.next;
                    }
                }
            } else {
                while (temp != null) {
                    if (e.equals(temp.item)) {
                        remove(temp);
                        return true;
                    } else {
                        temp = temp.next;
                    }
                }
            }
        }
        return false;
    }


    private void addBefore(E e, Node<E> node) {
        Node<E> tempNode = new Node<>(e, node, node.prev);
        if (node == first) {
            node.prev = tempNode;
            first = tempNode;
        } else {
            node.prev.next = tempNode;
            node.prev = tempNode;
        }
        size++;
    }

    private void addToLast(E e) {
        if (first == null) {//空链表
            Node<E> node = new Node<>(e, null, null);
            first = node;
            last = node;
        } else {//非空链表
            Node<E> node = new Node<>(e, null, last);
            last.next = node;
            last = node;
        }
        size++;
    }


    public int size() {
        return size;
    }

    private Node<E> getNode(int index) {
        if (index < (size >> 1)) {//index在链表的左半边
            Node<E> e = first;
            for (int i = 0; i < index; i++) {
                e = e.next;
            }
            return e;
        } else {//index在链表的右半边
            Node<E> e = last;
            for (int i = size - 1; i > index; i--) {
                e = e.prev;
            }
            return e;
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
