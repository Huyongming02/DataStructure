package com.hym.datastructure.algorithm.backtrack;

import org.junit.Test;

public class CalQueenTest {

    /**
     * 寻找一种摆放方式
     */
    @Test
    public void test1() {
        int locations[] = CalQueen.calculate(8);
        int size = locations.length;

        for (int i = 0; i < size; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < size; j++) {
                if (locations[i] == j) {
                    builder.append(" Q ");
                } else {
                    builder.append(" * ");
                }
            }
            System.out.println("第" + i + "列：" + builder.toString());
        }
    }

    /**
     * 计算总共有多少中摆放方式
     */
    @Test
    public void test2() {
        for (int i = 1; i <= 8; i++) {
            int size = i;
            int sum = CalQueen.countSum(size);
            System.out.println(size + "皇后问题，总共有" + sum + "种解");
        }
    }
}
