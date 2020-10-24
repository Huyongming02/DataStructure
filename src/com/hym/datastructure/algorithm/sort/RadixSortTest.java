package com.hym.datastructure.algorithm.sort;

import org.junit.Test;

import java.util.Random;

public class RadixSortTest {
    /**
     * 验证算法的正确性
     */
    @Test
    public void test1() {
        int size = 10;
        int[] array = new int[size];
        int[] array2 = new int[size];
        for (int i = 0; i < size; i++) {
            int num = 1;
            for (int j = 0; j < 5; j++) {
                num = num * 10 + new Random().nextInt(10);
            }
            array[i] = num;
            array2[i] = num;
        }
        print(array, "   org:");
        print(array2, "   org:");
        RadixSort.sort(array);
        MergeSort.sort(array2);
        print(array, "sorted:");
        print(array2, "sorted:");
    }

    private static void print(int[] array, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] + ",");
        }
        System.out.println(s + builder.toString());
    }
}
