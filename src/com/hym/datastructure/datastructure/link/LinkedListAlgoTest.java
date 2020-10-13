package com.hym.datastructure.datastructure.link;

import org.junit.Test;

public class LinkedListAlgoTest {
    /**
     * 测试链表反转
     */
    @Test
    public void testReverse() {
        LinkedListAlgo.Node head = null;
        for (int i = 10; i > 0; i--) {
            LinkedListAlgo.Node node = new LinkedListAlgo.Node(i, head);
            head = node;
        }
        print(head, "reverse org:");
        head = LinkedListAlgo.reverse(head);
        print(head, "reverse result:");
    }

    /**
     * 检测链表是否有环
     */
    @Test
    public void testCheckCircle() {
        //构造有环的链表
        LinkedListAlgo.Node head = null;
        LinkedListAlgo.Node first = null;
        for (int i = 10; i > 0; i--) {
            LinkedListAlgo.Node node = new LinkedListAlgo.Node(i, head);
            head = node;
            if (i == 10) {
                first = node;
            }
            if (i == 6) {//将10的next指针指向5，造成一个环
                first.next = node;
            }
        }
        StringBuilder builder = new StringBuilder();
        LinkedListAlgo.Node node = head;
        int count = 0;
        while (node != null && count < 100) {
            builder.append(node.item + ",");
            node = node.next;
            count++;
        }
        System.out.println("testCheckCircle org:" + builder.toString());//打印的数据中可以看到从5到10在不停的重复，说明有环
        System.out.println("testCheckCircle hasCircle:" + LinkedListAlgo.checkCircle(head));
    }

    /**
     * 合并两个有序链表
     */
    @Test
    public void testMergeSortedLists() {
        LinkedListAlgo.Node head1 = null;
        LinkedListAlgo.Node head2 = null;
        for (int i = 20; i > 0; i = i - 2) {
            LinkedListAlgo.Node node = new LinkedListAlgo.Node(i, head1);
            head1 = node;
        }
        for (int i = 11; i > 0; i = i - 2) {
            LinkedListAlgo.Node node = new LinkedListAlgo.Node(i, head2);
            head2 = node;
        }
        print(head1, "testMergeSortedLists org1:");
        print(head2, "testMergeSortedLists org2:");
        LinkedListAlgo.Node head = LinkedListAlgo.mergeSortedList(head2, head1);
        print(head, "testMergeSortedLists merge:");
    }

    /**
     * 删除倒数第K个节点
     */
    @Test
    public void testDeleteLastKth() {
        LinkedListAlgo.Node head = null;
        for (int i = 10; i > 0; i--) {
            LinkedListAlgo.Node node = new LinkedListAlgo.Node(i, head);
            head = node;
        }
        print(head, "deleteLastKth org:");
        head = LinkedListAlgo.deleteLastKth(head, 2);//删除倒数第二个
        print(head, "deleteLastKth deleted:");//倒数第二个，元素9被删除了
    }

    /**
     * 求链表的中间结点
     */
    @Test
    public void testFindMiddleNode() {
        LinkedListAlgo.Node head = null;
        for (int i = 9; i > 0; i--) {
            LinkedListAlgo.Node node = new LinkedListAlgo.Node(i, head);
            head = node;
        }
        print(head, "testFindMiddleNode org:");
        LinkedListAlgo.Node temp = LinkedListAlgo.findMiddleNode(head);
        System.out.println("testFindMiddleNode middle:" + temp.item);
    }


    private void print(LinkedListAlgo.Node node, String s) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.item + ",");
            node = node.next;
        }
        System.out.println(s + builder.toString());
    }
}
