package com.hym.datastructure.algorithm.sort;

import org.junit.Test;

import java.util.Random;

public class QuickSortTest {

    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(size * 10);
        }
        print(array, "org:");

        QuickSort.sort(array);
        print(array, "sorted:");
    }

    @Test
    public void testGetMaxKth() {
        int size = 10;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(size * 10);
        }
        print(array, "org:");

        int index = 5;
        System.out.println("the " + index + "th:" + QuickSort.getMaxK(array, index));

        print(array, "sorted:");
    }

    private static void print(int[] array, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] + ",");
        }
        System.out.println(s + builder.toString());
    }
}
