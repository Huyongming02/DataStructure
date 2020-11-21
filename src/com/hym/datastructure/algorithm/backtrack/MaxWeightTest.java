package com.hym.datastructure.algorithm.backtrack;

import com.hym.datastructure.algorithm.greedy.HuffmanTree;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class MaxWeightTest {

    @Test
    public void test1() {
        int max = 100;
        int size = 10;
        int[] goods = new int[size];
        for (int i = 0; i < size; i++) {
            goods[i] = new Random().nextInt(max);
        }
        print(goods, "weights:");
        System.out.println("maxWeight:" + MaxWeight.countMax(goods, max));
    }


    private static void print(int[] array, String s) {
        StringBuilder builder = new StringBuilder();
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                builder.append(array[i] + ",");
            }
        }
        System.out.println(s + builder.toString());
    }
}
