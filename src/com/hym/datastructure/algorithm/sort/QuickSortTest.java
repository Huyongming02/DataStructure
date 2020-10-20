package com.hym.datastructure.algorithm.sort;

import java.util.Random;

public class QuickSortTest {
    private static int MAX = 100;

    public static void main(String[] args) {
        int[] array = new int[MAX];
        StringBuilder builder1 = new StringBuilder();
        for (int i = 0; i < MAX; i++) {
            array[i] = new Random().nextInt(MAX * 10);
            builder1.append(array[i] + ",");
        }
        System.out.println("org:" + builder1.toString());

        QuickSort.sort(array);
        StringBuilder builder2 = new StringBuilder();
        for (int i = 0; i < MAX; i++) {
            builder2.append(array[i] + ",");
        }
        System.out.println("sort:" + builder2.toString());
    }
}
