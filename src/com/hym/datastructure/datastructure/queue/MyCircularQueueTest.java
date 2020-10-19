package com.hym.datastructure.datastructure.queue;

import org.junit.Test;

public class MyCircularQueueTest {

    @Test
    public void test() {
        MyCircularQueue<Integer> queue = new MyCircularQueue<>(10);
        //测试入队操作
        for (int i = 0; i < 12; i++) {
            System.out.println("enqueue " + i + ":" + queue.enqueue(i));
        }
        //测试出队操作
        for (int i = 0; i < 12; i++) {
            if (!queue.isEmpty()) {
                try {
                    System.out.println("enqueue " + i + ":" + queue.dequeue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("enqueue " + i + " queue is empty");
            }
        }
    }

    @Test
    public void test2() {
        MyCircularQueue<Integer> queue = new MyCircularQueue<>(10);
        for (int i = 0; i < 12; i++) {
            System.out.println("enqueue " + i + ":" + queue.enqueue(i));
        }
        //出队一部分
        for (int i = 0; i < 5; i++) {
            if (!queue.isEmpty()) {
                try {
                    System.out.println("enqueue " + i + ":" + queue.dequeue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("enqueue " + i + " queue is empty");
            }
        }
        //再次入队
        for (int i = 100; i < 112; i++) {
            System.out.println("enqueue " + i + ":" + queue.enqueue(i));
        }
        //全部出队
        for (int i = 0; i < 20; i++) {
            if (!queue.isEmpty()) {
                try {
                    System.out.println("enqueue " + i + ":" + queue.dequeue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("enqueue " + i + " queue is empty");
            }
        }
    }
}
