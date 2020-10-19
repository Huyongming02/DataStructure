package com.hym.datastructure.algorithm.sort;

import com.hym.datastructure.datastructure.link.LinkedListAlgo;
import org.junit.Test;

import java.util.Random;

public class MaoPaoSortTest {

    @Test
    public void test1() {
        int size = 20;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(100);
        }
        print(array, "org:");
        MaoPaoSort.sort(array);
        print(array, "sorted:");
    }


    private void print(int[] array, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] + ",");
        }
        System.out.println(s + builder.toString());
    }
}
