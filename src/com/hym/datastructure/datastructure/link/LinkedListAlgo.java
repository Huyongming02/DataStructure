package com.hym.datastructure.datastructure.link;

/**
 * * 1) 单链表反转
 * * 2) 链表中环的检测
 * * 3) 两个有序的链表合并
 * * 4) 删除链表倒数第n个结点
 * * 5) 求链表的中间结点
 */
public class LinkedListAlgo {
    /**
     * 链表反转(思路：新建一个新的空链表newHead；然后遍历原来的链表，依次取出节点插入到newHead的头部)
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        Node current = head;
        Node newHead = null;
        while (current != null) {
            Node next = current.next;//保存当前节点的下一个节点
            current.next = newHead;//将当前遍历的节点插入到新链表的头部
            newHead = current;//移动新链表的头指针指向当前节点
            current = next;//将当前节点移动到下一个要遍历的节点
        }
        return newHead;
    }

    /**
     * 链表中环的检测(使用两个指针去遍历链表，一个一次走两步，一个一次走一步，两个指针同时从前向后遍历链表，如果他们后面还能相遇，则说明有环)
     *
     * @param head
     * @return
     */
    public static boolean checkCircle(Node head) {
        if (head == null) {
            return false;
        }

        Node quick = head.next;
        Node slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (slow == quick) {
                return true;
            }
            System.out.println("slow:" + slow.item);
        }
        return false;
    }

    /**
     * 两个有序的链表合并
     * （实现思路：创建一个新的链表来存放合并后的结果，
     * 使用两个指针分别指向两个链表的头部，比较两个指针的值，
     * 将小的节点添加到新的列表中，并移动其指针到下一个节点，
     * 然后再次比较两个指针的值，重复这个过程直到一个链表遍历完毕。
     * 然后继续遍历未遍历完毕的链表剩下的节点插入到新的链表的后面）
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeSortedList(Node head1, Node head2) {
        Node head = null;
        Node current = null;
        while (head1 != null && head2 != null) {
            Node temp = null;
            if (head1.item < head2.item) {
                temp = head1;
                head1 = head1.next;
            } else {
                temp = head2;
                head2 = head2.next;
            }
            if (head == null) {
                head = temp;
                current = head;
            } else {
                current.next = temp;
                current = temp;
            }
        }
        while (head1 != null) {
            if (head == null) {
                head = head1;
                current = head;
            } else {
                current.next = head1;
                current = head1;
            }
            head1 = head1.next;
        }
        while (head2 != null) {
            if (head == null) {
                head = head2;
                current = head;
            } else {
                current.next = head2;
                current = head2;
            }
            head2 = head2.next;
        }
        return head;
    }

    /**
     * 删除链表倒数第n个结点
     * （实现思路：先用一个指针从链表头部开始遍历k-1个节点，然后再用一个指针指向链表头部，
     * 两个指针同时开始向后遍历，当第一个指针遍历到链表的尾部时，
     * 第二个指针指向的就是倒数第k个节点）
     *
     * @param head
     * @param k
     * @return
     */
    public static Node deleteLastKth(Node head, int k) {
        Node fast = head;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {//链表的元素不够k个
            return head;
        }
        Node slow = head;
        Node pre = null;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre == null) {
            head = head.next;
        } else {
            pre.next = pre.next.next;
        }
        return head;
    }

    /**
     * 求链表的中间结点
     * （实现思路：使用两个指针，一个指针一次走两步，一个指针一次走一步，
     * 两个指针同时从链表的头部向尾部遍历，当一次走两步的指针走到链表尾部时，
     * 一次走一步的指针指向的就是链表的中间元素）
     *
     * @param head
     * @return
     */
    public static Node findMiddleNode(Node head) {
        if (head == null) {
            return null;
        }
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static class Node {
        int item;
        Node next;

        public Node() {
        }

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
