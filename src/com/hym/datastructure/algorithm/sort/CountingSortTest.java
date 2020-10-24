package com.hym.datastructure.algorithm.sort;

import org.junit.Test;

import java.util.Random;

public class CountingSortTest {
    /**
     * 验证排序的正确性
     */
    @Test
    public void test() {
        int size = 50;
        int[] array = new int[size];
        int[] array1 = new int[size];
        for (int i = 0; i < size; i++) {
            int value = 10000 + new Random().nextInt(20);
            array[i] = value;
            array1[i] = value;
        }
        print(array, "   org:");
        print(array1, "   org:");
        CountingSort.sort(array);
        MergeSort.sort(array1);
        print(array, "sorted:");
        print(array1, "sorted:");
    }

    /**
     * 与归并对比速度
     */
    @Test
    public void test2() {
        int size = 10000000;
        int[] array = new int[size];
        int[] array2 = new int[size];
        for (int i = 0; i < size; i++) {
            int value = new Random().nextInt(10);
            array[i] = value;
            array2[i] = value;
        }
        long bucketSortStartTime = System.currentTimeMillis();
        CountingSort.sort(array);
        System.out.println("CountingSort time:" + (System.currentTimeMillis() - bucketSortStartTime));

        long quickSortStartTime = System.currentTimeMillis();
        MergeSort.sort(array2);
        System.out.println("   MergeSort time:" + (System.currentTimeMillis() - quickSortStartTime));
    }

    private static void print(int[] array, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] + ",");
        }
        System.out.println(s + builder.toString());
    }
}
