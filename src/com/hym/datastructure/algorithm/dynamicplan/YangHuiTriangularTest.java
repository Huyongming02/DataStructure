package com.hym.datastructure.algorithm.dynamicplan;

import org.junit.Test;

import java.util.Random;

public class YangHuiTriangularTest {


    @Test
    public void test() {
        int size = 5;
        int[][] weights = new int[size][];
        for (int i = 0; i < size; i++) {
            weights[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                weights[i][j] = new Random().nextInt(8) + 1;
            }
        }
        print(weights, "");
        int min = YangHuiTriangular.count(weights);
        System.out.println("min:" + min);
    }

    private static void print(int[][] weights, String des) {
        System.out.println(des + "************************************");
        for (int i = 0; i < weights.length; i++) {
            StringBuilder builder = new StringBuilder();
            int num = weights.length - i;
            for (int k = 0; k < (num-1) / 2; k++) {
                builder.append("   " + " " + "   ");
            }
            if (i % 2 != 0) {
                builder.append("    ");
            }
            for (int k = 0; k <= i; k++) {
                builder.append("   " + weights[i][k] + "   ");
            }
            System.out.println(builder.toString());
            if (i < weights.length - 1) {
                StringBuilder builder2 = new StringBuilder();
                for (int k = 0; k < (num-1) / 2; k++) {
                    builder2.append("   " + " " + "   ");
                }
                if (i % 2 != 0) {
                    builder2.append("    ");
                }
                for (int k = 0; k <= i; k++) {
                    builder2.append("  /" + " " + "\\  ");
                }
                System.out.println(builder2.toString());
            }
        }
        System.out.println(des + "**************************************");
    }

}
