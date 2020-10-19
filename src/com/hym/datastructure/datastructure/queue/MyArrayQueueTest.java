package com.hym.datastructure.datastructure.queue;

import org.junit.Test;

/**
 * 顺序队列
 */
public class MyArrayQueueTest {

    @Test
    public void test1() {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>(10);
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
        MyArrayQueue<Integer> queue = new MyArrayQueue<>(10);
        for (int i = 0; i < 12; i++) {
            System.out.println("enqueue " + i + ":" + queue.enqueue(i));
        }
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
        //测试出队入队之后，队列的容量是否变化
        for (int i = 100; i < 112; i++) {
            System.out.println("enqueue " + i + ":" + queue.enqueue(i));
        }
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
