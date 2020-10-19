package com.hym.datastructure.datastructure.queue;

import org.junit.Test;

public class MyLinkedQueueTest {
    @Test
    public void test1() {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        System.out.println("enqueue :" + queue.dequeue());
        //测试入队操作
        for (int i = 0; i < 12; i++) {
            System.out.println("enqueue " + i + ":" + queue.enqueue(i));
        }
        //测试出队操作
        for (int i = 0; i < 12; i++) {
            System.out.println("enqueue " + i + ":" + queue.dequeue());
        }
    }

}
