package com.hym.datastructure.algorithm.sort;

import org.junit.Test;

import java.util.Random;

public class BucketSortTest {
    /**
     * 测试算法的正确性
     */
    @Test
    public void test() {
        int size = 20;
        int[] array = new int[size];
        int[] array2 = new int[size];
        for (int i = 0; i < size; i++) {
            int value = new Random().nextInt(size);
            array[i] = value;
            array2[i] = value;
        }
        print(array, "   org:");
        print(array2, "   org:");
        BucketSort.sort(array, 5);
        QuickSort.sort(array2);
        print(array, "sorted:");
        print(array2, "sorted:");
    }

    /**
     * 与快排对比速度
     */
    @Test
    public void test2() {
        int size = 10000000;
        int[] array = new int[size];
        int[] array2 = new int[size];
        for (int i = 0; i < size; i++) {
            int value = new Random().nextInt(size);
            array[i] = value;
            array2[i] = value;
        }
        long bucketSortStartTime = System.currentTimeMillis();
        BucketSort.sort(array, 1000);
        System.out.println("bucketSort time:" + (System.currentTimeMillis() - bucketSortStartTime));

        long quickSortStartTime = System.currentTimeMillis();
        QuickSort.sort(array2);
        System.out.println(" QuickSort time:" + (System.currentTimeMillis() - quickSortStartTime));
    }

    private static void print(int[] array, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] + ",");
        }
        System.out.println(s + builder.toString());
    }
}
