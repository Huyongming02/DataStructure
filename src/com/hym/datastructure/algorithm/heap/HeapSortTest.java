package com.hym.datastructure.algorithm.heap;

import org.junit.Test;

import java.util.Random;

public class HeapSortTest {

    @Test
    public void testCreate() {
        for (int k = 1; k < 20; k++) {
            System.out.println("k:" + k);
            int size = k;
            int[] array = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                array[i] = new Random().nextInt(size);
            }
            print(array, " org:");
            HeapSort.createHeap(array, size);
            print(array, "heap:");
            System.out.println("isHeap:" + isHeap(array, 1, size));
        }
    }

    @Test
    public void teatSort() {
        for (int k = 1; k < 20; k++) {
            System.out.println("k:" + k);
            int size = k;
            int[] array = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                array[i] = new Random().nextInt(size);
            }
            print(array, " org:");
            HeapSort.sort(array, size);
            print(array, "heap:");
            System.out.println("isSorted:" + isSorted(array, size));
        }
    }


    /**
     * 判断是否有序
     *
     * @param array
     * @param size
     * @return
     */
    private boolean isSorted(int[] array, int size) {
        for (int i = 2; i <= size; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 判断是否是堆
     *
     * @param array
     * @param index
     * @param size
     * @return
     */
    private boolean isHeap(int[] array, int index, int size) {
        int left = index * 2;
        int right = index * 2 + 1;
        if (left <= size) {
            if (array[index] < array[left]) {
                return false;
            } else {
                return isHeap(array, left, size);
            }
        }
        if (right <= size) {
            if (array[index] < array[right]) {
                return false;
            } else {
                return isHeap(array, right, size);
            }
        }
        return true;
    }

    private static void print(int[] array, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] + ",");
        }
        System.out.println(s + builder.toString());
    }
}
